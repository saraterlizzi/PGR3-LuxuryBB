package Server.HandlingSystem;

import Server.Handler.Handler;
import Server.Handler.Request;
import Server.QueryOperations.OwnerOP;

public class HandlerOwner extends Handler {

    private static HandlerOwner instance = null;

    public static HandlerOwner getInstance(){
        if(instance==null){
            instance = new HandlerOwner();
        }
        return instance;
    }
    @Override
    public String handlerRequest(Request request) {
        OwnerOP oop = new OwnerOP();
        String req = null;
        if(request.getSottosistema().equals("OWNER")){
            switch (request.getRichiesta()){
                case "INSERTROOM":
                    req = oop.add(request.getQuery().getTable(),request.getQuery());
            }
        } else {
            return successor.handlerRequest(request);
        }
        return req;
    }
}
