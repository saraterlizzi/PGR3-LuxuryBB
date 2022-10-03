package Server.HandlingSystem;

import Server.Handler.Handler;
import Server.Handler.Request;
import Server.QueryOperations.AuthenticationOP;

public class HandlerAuth extends Handler {
    private static HandlerAuth instance = null;

    public static HandlerAuth getInstance() {
        if (instance==null){
            instance = new HandlerAuth();
        }
        return instance;
    }

    @Override
    public String handlerRequest(Request request) {
        AuthenticationOP adb = new AuthenticationOP();
        String req = null;
        if (request.getSottosistema().equals("AUTHENTICATION")){
            switch (request.getRichiesta()){
                case "LOGIN":
                    req = adb.get(request.getQuery().getTable(), request.getQuery());
                    break;
            };
        }
        return req;
    }
}
