package Client;

import Client.Authentication.AuthenticationFactory;
import Client.Interface.AbstractFactory;
import Client.Interface.SocketProxy;
import Client.Private.PrivateFactory;

/**
 * Classe per l'implementazione del pattern Factory Method per istanziamenti di AbstractFactory per la creazione di
   oggetti in java swing
 * @author Filomena De Rosa, Sara Terlizzi
 */
public class FactoryMaker {

    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static FactoryMaker Instance=null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static FactoryMaker getInstance(){
        if (Instance==null){
            Instance = new FactoryMaker();
        }
        return Instance;
    }
    /** Metodo per ritornare le istanze degli Abstract Factory
     @param factory (stringa di riferimento per capire quale Abstract Factory si vuole utilizzare)
     @return l'istanziamento dell'Abstract Factory scelto
     */
    public AbstractFactory getFactory(String factory){
        return switch (factory){
            case "auth" -> new AuthenticationFactory();
            case "private" -> new PrivateFactory();
            default -> null;
        };
    }
}
