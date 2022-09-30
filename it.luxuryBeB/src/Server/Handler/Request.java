package Server.Handler;

import Server.Query.Query;

public class Request {
    public String sottosistema;

    private String richiesta;

    private Query query;

    public Request(String sottosistema, String richiesta, Query query){
        this.sottosistema = sottosistema;
        this.richiesta = richiesta;
        this.query = query;
    }

    public String getSottosistema() {
        return sottosistema;
    }

    public String getRichiesta() {
        return richiesta;
    }

    public Query getQuery() {
        return query;
    }
}
