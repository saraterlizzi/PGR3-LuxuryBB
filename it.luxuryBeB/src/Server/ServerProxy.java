package Server;

import Client.Interface.SocketProxy;
import Server.Interface.Proxy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe per l'implementazione del pattern Proxy per il collegamento tramite socket tra Client e Server
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Proxy
 */
public class ServerProxy implements Proxy {
    /** Attributo per la connessione mediante socket del Client
     */
    private Socket socket = null;

    /** Attributo per il socket del Server
     */
    private ServerSocket serverSocket = null;

    /** Attributo per la cattura degli elementi in input tramite socket
     */
    private InputStream in = null;

    /** Attributo per il buffer di lettura
     */
    private BufferedReader bf = null;

    /** Attributo per la scrittura degli elementi in output
     */
    private DataOutputStream dos = null;

    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static Proxy instance = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static Proxy getInstance(){
        if (instance==null){
            instance=new ServerProxy();
        }
        return instance;
    }

    /**Funzione per l'inizializzazione del Server socket
     * @param port (porta d'ascolto, su cui avviene la connessione)
     * @return nulla poichè void
     */
    @Override
    public void init(int port) {
        try {
            serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**Funzione wrapper per accettare la richiesta di connessione dal Client
     * @return nulla poichè void
     */
    @Override
    public void accept() {
        try {
            socket=serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**Funzione per il settaggio delle richieste di input/output tramite socket
     * @return nulla poichè void
     */
    @Override
    public void setIO() {
        try {
            in=socket.getInputStream();
            bf= new BufferedReader(new InputStreamReader(in));
            dos=new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Funzione wrapper per la scrittura su socket
     @param text
     @return nulla, poichè void
     */
    @Override
    public void write(String text) {
        try {
            dos.writeUTF(text);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Funzione wrapper per la lettura su socket
     @return la stringa di risposta del Server
     */
    @Override
    public String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
