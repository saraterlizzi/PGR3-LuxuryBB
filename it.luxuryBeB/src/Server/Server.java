package Server;

import Client.ClientProxy;
import Client.ClientVisitor;
import Server.Handler.Request;
import Server.HandlingSystem.HandlerAuth;
import Server.HandlingSystem.HandlerBooking;
import Server.HandlingSystem.HandlerOwner;
import Server.Interface.DBBridge;
import Server.Interface.Proxy;
import Server.Query.Query;
import Server.Query.QueryAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe main del package Server
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Database
 * @see ServerProxy
 */
public class Server {
    /**
     Metodo main dell'intero package Server
     @param args valori presi tramite linea di comando
     */
    public static void main (String [] args) {

        DBBridge db = Database.getInstance();

        db.connect();

        System.out.println("Avviamento completato del server, in attesa di connessione.");

        Proxy server = ServerProxy.getInstance();
        try {
            server.init(58);
            System.out.println("Server inizializzato, in attesa di connessioni.");

            HandlerAuth.getInstance().setSuccessor(HandlerOwner.getInstance());
            HandlerOwner.getInstance().setSuccessor(HandlerBooking.getInstance());
            HandlerBooking.getInstance().setSuccessor(null);

            while (true){
                server.accept();
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        server.setIO();
                        while (true) {
                            String text = server.read();
                            System.out.println(text);
                            if (text.isEmpty() || text.equalsIgnoreCase("quit")) {
                                System.out.println("Thread" + Thread.currentThread().getName() + "terminato");
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

                            server.write(HandlerAuth.getInstance().handlerRequest(richiesta));
                        }
                    }
                };
                t.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
