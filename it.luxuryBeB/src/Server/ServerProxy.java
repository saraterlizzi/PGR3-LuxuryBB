package Server;

import Server.Interface.Proxy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProxy implements Proxy {

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private InputStream in = null;
    private BufferedReader bf = null;
    private DataOutputStream dos = null;
    private static Proxy instance = null;

    public static Proxy getInstance(){
        if (instance==null){
            instance=new ServerProxy();
        }
        return instance;
    }

    @Override
    public void init(int port) {
        try {
            serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void accept() {
        try {
            socket=serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    @Override
    public void write(String text) {
        try {
            dos.writeUTF(text);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String read() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
