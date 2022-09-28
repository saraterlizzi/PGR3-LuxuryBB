package Client;

import Client.Authentication.AuthenticationFacade;
import Client.Interface.Memento;
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
            case"login" -> F.login();
            case"register" -> F.register();
        }

    }

    @Override
    public void VisitPrivate(String where) {
        PrivateFacade F = PrivateFacade.getInstance();
        switch(where) {
            case "init" -> F.PrivateInt();
            case "Booking" -> F.Booking();
            case "Payment" -> F.Payment();
        }
    }
}
