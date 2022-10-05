package Server.HandlingSystem;

import Server.Handler.Handler;
import Server.Handler.Request;
import Server.QueryOperations.AuthenticationOP;
import Server.QueryOperations.BookingOP;

public class HandlerBooking extends Handler {

    private static HandlerBooking instance = null;

    public static HandlerBooking getInstance() {
        if (instance==null){
            instance = new HandlerBooking();
        }
        return instance;
    }

    @Override
    public String handlerRequest(Request request) {
        BookingOP bdb = new BookingOP();
        String req = null;
        if(request.getSottosistema().equals("BOOKING")){
            switch (request.getRichiesta()){
                case "ROOMS" -> req = bdb.get(request.getQuery().getTable(),request.getQuery());
                case "PAYMENT" -> req = bdb.add(request.getQuery().getTable(),request.getQuery());
            }
            return req;
        } else return successor.handlerRequest(request);
    }
}
