package Client;

import Client.Authentication.AuthenticationFacade;
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
            case "view" -> F.ViewB();
        };
    }

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
