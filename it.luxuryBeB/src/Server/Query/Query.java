package Server.Query;

import java.util.ArrayList;

public class Query {
    private String table;
    private final ArrayList<String> attributi;
    private final ArrayList<String> valori;
    public Query(){
        this.attributi = new ArrayList<String>();
        this.valori = new ArrayList<String>();
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public ArrayList<String> getAttributi() {
        return attributi;
    }

    public ArrayList<String> getValori() {
        return valori;
    }

    public void addValori(String valore){
        this.valori.add(valore);
    }

    public void addAttributo(String attrivuti){
        this.attributi.add(attrivuti);
    }
}
