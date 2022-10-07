package Server.HandlingSystem;

import Server.Handler.Handler;
import Server.Handler.Request;
import Server.QueryOperations.AuthenticationOP;
import Server.QueryOperations.BookingOP;

/**
 * Classe che estende Handler per la gestione delle richieste ricevute dal Server, sottoparte Booking
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Handler
 */
public class HandlerBooking extends Handler {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static HandlerBooking instance = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static HandlerBooking getInstance() {
        if (instance==null){
            instance = new HandlerBooking();
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
        BookingOP bdb = new BookingOP();
        String req = null;
        if(request.getSottosistema().equals("BOOKING")){
            switch (request.getRichiesta()){
                case "ROOMS" -> req = bdb.get(request.getQuery().getTable(),request.getQuery());
                case "PAYMENT" -> req = bdb.add(request.getQuery().getTable(),request.getQuery());
                case "DELETE" -> req = bdb.delete(request.getQuery().getTable(),request.getQuery());
                case "VIEW" -> req = bdb.get(request.getQuery().getTable(),request.getQuery());
            }
            return req;
        } else return successor.handlerRequest(request);
    }
}
