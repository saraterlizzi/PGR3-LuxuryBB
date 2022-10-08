package Client;

import Client.Authentication.AuthenticationFacade;
import Client.Interface.SocketProxy;
import Client.Interface.Visitor;
import Client.Private.PrivateFacade;

/**
 * Classe per l'implementazione del pattern Visitor per visitare i sottosistemi del package Client
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Visitor
 */
public class ClientVisitor implements Visitor {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static ClientVisitor instance=null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static ClientVisitor getInstance() {
        if (instance == null) {
            instance = new ClientVisitor();
        }
        return instance;
    }

    /** Metodo per visitare il sottopackage Authentication
     @param where (stringa per distinguere in quale parte del sottopackage dirigersi)
     @return nulla poichè void
     */
    @Override
    public void VisitAuthentication(String where) {
        AuthenticationFacade F=AuthenticationFacade.getInstance();
        switch(where){
            case "login" -> F.login();
            case "register" -> F.register();
        };
    }

    /** Metodo per visitare il sottopackage Private
     @param where (stringa per distinguere in quale parte del sottopackage dirigersi)
     @return nulla poichè void
     */
    @Override
    public void VisitPrivate(String where) {
        PrivateFacade F = PrivateFacade.getInstance();
        switch(where) {
            case "init" -> F.PrivateInt();
            case "booking" -> F.Booking();
            case "payment" -> F.Payment();
            case "view" -> F.ViewB();
        };
    }

    /** Metodo per visitare il sottopackage Proxy
     @param where (stringa per distinguere in quale parte del sottopackage dirigersi)
     @return nulla poichè void
     */
    public void VisitProxy(String where){
        SocketProxy P = ClientProxy.getInstance();
        switch (where){
            case "start" -> {
                P.connectionSetup("localhost", 58);
            }
            case "end" -> {
               P.end();
            }
        };
    }
}
