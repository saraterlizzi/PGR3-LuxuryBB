package Server;

import java.io.IOException;

public class Server {

    public static void main (String [] args) {

        Proxy server = ServerProxy.getInstance();
        try {
            server.init(58);
            while (true){
                server.accept();
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        server.setIO();
                    }
                };
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
