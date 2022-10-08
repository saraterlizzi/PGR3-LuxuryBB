package Owner;

import Client.ClientProxy;
import Owner.Interface.SocketProxy;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Classe per l'implementazione del pattern Proxy per il collegamento tramite socket tra Client e Server
 * @author Filomena De Rosa, Sara Terlizzi
 * @see SocketProxy
 */
public class OwnerProxy implements SocketProxy {
    /** Attributo per la connessione mediante socket
     */
    private Socket socket=null;

    /** Attributo per la lettura dei dati presi in input tramite socket
     */
    private DataInputStream dis = null;

    /** Attributo per la scrittura su socket
     */
    private PrintWriter pw = null;

    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static OwnerProxy instance = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static OwnerProxy getInstance(){
        if (instance==null){
            instance=new OwnerProxy();
        }
        return instance;
    }

    /** Funzione wrapper per la lettura su socket
     @return la stringa di risposta del Client
     */
    @Override
    public String read() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /** Funzione wrapper per la scrittura su socket
     @param richiesta
     */
    @Override
    public void write(String richiesta) {
        pw.println(richiesta);
        pw.flush();
    }

    /** Funzione wrapper per la chiusura della connessione
     */
    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    /** Funzione wrapper per acquisire il socket
     @return socket
     */
    @Override
    public Socket getSocket() {
        return socket;
    }

    /** Funzione wrapper per il tentativo di connessione
     @param  IP (codice IPV4 per connessione con Client)
     @param porta (numero della porta)

     */

    @Override
    public void connectionSetup(String IP, int porta) {
        try {
            socket=new Socket(IP,porta);
            dis = new DataInputStream(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    /** Funzione wrapper per porre fine alla connessione
     */
    @Override
    public void end() {
        pw.println("exit");
        pw.flush();
        close();
    }
}
