package Server.Handler;

import Client.ClientProxy;
import Client.ClientVisitor;
import Server.Query.Query;

/**
 * Classe per conservare informazioni inerenti ad operazioni effettuate sul Server
 * @author Filomena De Rosa, Sara Terlizzi
 */
public class Request {
    /**Stringa riguardante il sottosistema che gestirà tale richiesta
     */
    public String sottosistema;

    /**Stringa riguardante la richiesta di operazioni da svolgere
     */
    private String richiesta;

    /**Query
     */
    private Query query;


    /**
   Funzione per il settaggio dei dati all'interno della richiesta
     @param sottosistema
     @param richiesta
     @param query
     @return nulla essendo il costruttore
     */
    public Request(String sottosistema, String richiesta, Query query){
        this.sottosistema = sottosistema;
        this.richiesta = richiesta;
        this.query = query;
    }

    /**Metodo per acquisire il sottosistema
     * @return sottosistema
     */
    public String getSottosistema() {
        return sottosistema;
    }

    /**Metodo per acquisire il richiesta
     * @return richiesta
     */
    public String getRichiesta() {
        return richiesta;
    }

    /**Metodo per acquisire la query
     * @return query
     */
    public Query getQuery() {
        return query;
    }
}
