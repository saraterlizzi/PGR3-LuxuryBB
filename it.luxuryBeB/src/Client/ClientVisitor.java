package Client;

import Client.Authentication.AuthenticationFacade;
import Client.Interface.Memento;
import Client.Interface.SocketProxy;
import Client.Interface.Visitor;
import Client.Private.PrivateFacade;

public class ClientVisitor implements Visitor {
    private static ClientVisitor instance=null;

    public static ClientVisitor getInstance() {
        if (instance == null) {
            instance = new ClientVisitor();
        }
        return instance;
    }

    @Override
    public void VisitAuthentication(String where) {
        AuthenticationFacade F=AuthenticationFacade.getInstance();
        switch(where){
            case "login" -> F.login();
            case "register" -> F.register();
        };
    }

    @Override
    public void VisitPrivate(String where) {
        PrivateFacade F = PrivateFacade.getInstance();
        switch(where) {
            case "init" -> F.PrivateInt();
            case "booking" -> F.Booking();
            case "payment" -> F.Payment();
        };
    }

    public void VisitProxy(String where){
        switch (where){
            case "start" -> {
                SocketProxy.getInstance().connectionSetup("localhost", 58);
            }
            case "end" -> {
                SocketProxy.getInstance().end();
            }
        };
    }
}
