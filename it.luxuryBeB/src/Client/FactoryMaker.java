package Client;

import Client.Authentication.AuthenticationFactory;
import Client.Interface.AbstractFactory;
import Client.Private.PrivateFactory;

public class FactoryMaker {
    private static FactoryMaker Instance=null;

    public static FactoryMaker getInstance(){
        if (Instance==null){
            Instance = new FactoryMaker();
        }
        return Instance;
    }

    public AbstractFactory getFactory(String factory){
        return switch (factory){
            case "auth" -> new AuthenticationFactory();
            case "private" -> new PrivateFactory();
            default -> null;
        };
    }
}
