package Server;

import Server.Handler.Request;
import Server.Interface.DBBridge;
import Server.Interface.Proxy;
import Server.Query.Query;
import Server.Query.QueryAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    public static void main (String [] args) {

        DBBridge db = Database.getInstance();

        db.connect();

        System.out.println("Avviamento completato del server, in attesa di connessione.");

        Proxy server = ServerProxy.getInstance();
        try {
            server.init(58);
            System.out.println("Server inizializzato, in attesa di connessioni.");
            while (true){
                server.accept();
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        server.setIO();
                        String text = server.read();
                        System.out.println(text);
                        if(text.isEmpty()||text.equalsIgnoreCase("quit")){
                            System.out.println("Thread"+Thread.currentThread().getName()+"terminato");
                            return;
                        }
                        QueryAdapter adapter = new QueryAdapter();
                        List<String> list = Arrays.asList(text.split(","));
                        ArrayList<String> request = new ArrayList<>(list);

                        String sottosistema = request.get(0);
                        request.remove(0);

                        String oggetto = request.get(0);
                        request.remove(0);

                        String table = request.get(0);
                        request.remove(0);

                        Query query = adapter.adapter(request);
                        query.setTable(table);

                        Request richiesta = new Request(sottosistema, oggetto, query);
                    }
                };
                t.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
