package Server;

import Server.Interface.DBBridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements DBBridge {

    private static Database instance;

    private Connection connection = null;

    protected String url = "jdbc:mysql://0.0.0.0:3306/luxurybb";

    protected String user = "root";

    protected String password = "root";

    public static Database getInstance(){
        if(instance==null){
            instance=new Database();
        }
        return instance;
    }

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione al Database effettuata.\n");
        } catch (SQLException e) {
            System.out.println("Impossibile connettersi al Database. \n");
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
