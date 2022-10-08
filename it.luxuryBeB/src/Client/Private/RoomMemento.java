package Client.Private;

import Client.Interface.Memento;

/**
 * Classe per l'implementazione del pattern Memento per salvare lo stato dei dati della stanza e renderlo accessibile
 globalmente a tutte le classi
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Memento
 */
public class RoomMemento implements Memento {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static RoomMemento instance;

    /** Attributi per memorizzare la richiesta
     */
    private String request = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static RoomMemento getInstance(){
        if (instance==null){
            instance = new RoomMemento();
        }
        return instance;
    }

    /** Metodo per settare e impostare la richiesta
     @param request
     */
    public void setMemento(String request){
        this.request=request;
    }

    /** Metodo per ripristinare la richiesta effettuata
     @return request
     */
    public String restoreState(){
        return request;
    }
}
