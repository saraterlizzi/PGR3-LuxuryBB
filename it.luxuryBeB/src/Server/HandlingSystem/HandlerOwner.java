package Server.HandlingSystem;

import Client.Interface.Handler.ActionHandler;
import Server.Handler.Handler;
import Server.Handler.Request;
import Server.QueryOperations.OwnerOP;

/**
 * Classe che estende Handler per la gestione delle richieste ricevute dal Server, sottoparte Owner
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Handler
 */
public class HandlerOwner extends Handler {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static HandlerOwner instance = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static HandlerOwner getInstance(){
        if(instance==null){
            instance = new HandlerOwner();
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
        OwnerOP oop = new OwnerOP();
        String req = null;
        if(request.getSottosistema().equals("OWNER")){
            switch (request.getRichiesta()) {
                case "INSERTROOM" -> req = oop.add(request.getQuery().getTable(), request.getQuery());
                case "ROOM" -> req = oop.get(request.getQuery().getTable(), request.getQuery());
                case "MODIFY" -> req = oop.modify(request.getQuery().getTable(),request.getQuery());
            }
        } else {
            return successor.handlerRequest(request);
        }
        return req;
    }
}
