package Client;

import Client.Authentication.AuthenticationFacade;
import Client.Interface.Memento;
import Client.Interface.Visitor;

public class ClientVisitor implements Visitor {
    private static Visitor instance=null;

    public static Visitor getInstance() {
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

    }
}
