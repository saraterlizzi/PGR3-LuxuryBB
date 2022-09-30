package Owner;

import Client.ClientProxy;
import Owner.Interface.SocketProxy;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class OwnerProxy implements SocketProxy {
    private Socket socket=null;
    private DataInputStream dis = null;
    private PrintWriter pw = null;
    private static OwnerProxy instance = null;

    public static OwnerProxy getInstance(){
        if (instance==null){
            instance=new OwnerProxy();
        }
        return instance;
    }

    @Override
    public String read() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void write(String richiesta) {
        pw.println(richiesta);
        pw.flush();
    }

    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    @Override
    public Socket getSocket() {
        return socket;
    }

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

    @Override
    public void end() {
        pw.println("exit");
        pw.flush();
    }
}
