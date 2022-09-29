package Server;

import java.io.IOException;

public interface Proxy {

    void init (int port) throws IOException;
    void accept();

    void setIO();
    void write(String text);
    String read();

}
