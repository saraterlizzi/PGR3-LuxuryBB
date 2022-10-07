package Client.Authentication;

import Client.Interface.Memento;

/**
 * Classe per l'implementazione del pattern Memento per salvare lo stato dei dati dell'user e renderlo accessibile
   globalmente a tutte le classi
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Memento
 */
public class UserMemento implements Memento {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
   private static UserMemento instance;

    /** Attributi per memorizzare i dati
     */
   private String email, password, id=null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
   public static UserMemento getInstance(){
       if (instance==null){
           instance=new UserMemento();
       }
       return instance;
    }

    /** Metodo per settare e impostare i dati dell'user
     @param email (dell'user)
     @param password (dell'user)
     @param id (dell'user)
     @return nulla poichè void
     */
    public void setMemento (String email, String password, String id){
        this.email=email;
        this.password=password;
        this.id=id;
    }

    /** Metodo per ripristinare lo stato salvato
     @return email (dell'user)
     */
    public String restoreState(){
        return email;
    }
}
