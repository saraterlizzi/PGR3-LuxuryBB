package Server.Interface;

import java.sql.Connection;

public interface DBBridge {

    public void connect();

    public void close();

    public Connection getConnection();
}
