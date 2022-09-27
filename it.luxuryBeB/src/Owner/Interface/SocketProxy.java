package Owner.Interface;

import java.net.Socket;

public interface SocketProxy {
    public static SocketProxy getInstance(){
        return null;
    }

    public abstract String read();
    public abstract void write(String richiesta);
    abstract void close();
    public Socket getSocket();
    public void connectionSetup(String IP, int porta);
}
