package Client;

/**
 * Classe main del package Client
 * @author Filomena De Rosa, Sara Terlizzi
 * @see ClientVisitor
 * @see ClientProxy
 */
public class Client {
    /**
     Metodo main dell'intero package Client
     @param args valori presi tramite linea di comando
     */
    public static void main(String[] args) {
        ClientVisitor CV = ClientVisitor.getInstance();

        CV.VisitProxy("start");

        CV.VisitAuthentication("login");
    }
}
