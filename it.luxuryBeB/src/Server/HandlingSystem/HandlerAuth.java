package Server.HandlingSystem;

import Server.Handler.Handler;
import Server.Handler.Request;
import Server.QueryOperations.AuthenticationOP;

/**
 * Classe che estende Handler per la gestione delle richieste ricevute dal Server, sottoparte Authentication
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Handler
 */
public class HandlerAuth extends Handler {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static HandlerAuth instance = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static HandlerAuth getInstance() {
        if (instance==null){
            instance = new HandlerAuth();
        }
        return instance;
    }

    /** Metodo per gestire le richieste ricevute tramite socket
     * @param request (richiesta ricevuta per operazione su database)
     * @return req (risposta nel caso di successo)
     * @return successor.handlerRequest(request) (nel caso la richiesta non sia gestibile, lo manda al suo successore
       nella COR)
     */
    @Override
    public String handlerRequest(Request request) {
        AuthenticationOP adb = new AuthenticationOP();
        String req = null;
        if (request.getSottosistema().equals("AUTHENTICATION")){
            switch (request.getRichiesta()) {
                case "LOGIN" -> req = adb.get(request.getQuery().getTable(), request.getQuery());
                case "REGISTRATION" -> req = adb.add(request.getQuery().getTable(), request.getQuery());
            };
        } else  return successor.handlerRequest(request);
        return req;
    }
}
