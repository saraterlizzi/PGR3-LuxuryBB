package Server.Query;

import java.util.ArrayList;

/**Classe per contenere tutti gli elementi utilizzati per le operazioni su query
 * @author Filomena De Rosa, Sara Terlizzi
 */
public class Query {
    /**Attributo che rappresenta la tabella su cui eseguire le operazioni
     */
    private String table;

    /**Lista contenente gli attributi della query
     */
    private final ArrayList<String> attributi;

    /**Lista contenente i nomi dei valori della tabella
     */
    private final ArrayList<String> valori;

    /**Costruttore della classe Query
     * @param attributi (parametro implicito)
     * @param valori (parametro implicito)
     */
    public Query(){
        this.attributi = new ArrayList<String>();
        this.valori = new ArrayList<String>();
    }

    /**Funzione che ritorna la tabella
     * @return table
     */
    public String getTable() {
        return table;
    }

    /**Funzione che imposta la tabella
     * @param table
     * @return nulla poichè void
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**Lista che ritorna gli attributi
     * @return attributi
     */
    public ArrayList<String> getAttributi() {
        return attributi;
    }

    /**Lista che ritorna i valori
     * @return valori
     */
    public ArrayList<String> getValori() {
        return valori;
    }

    /**Funzione che aggiunge i valori all'interno della tabella
     * @param valore
     * @return nulla poichè void
     */
    public void addValori(String valore){
        this.valori.add(valore);
    }

    /**Funzione che aggiunge i valori all'interno della tabella
     * @param attributi
     * @return nulla poichè void
     */
    public void addAttributo(String attributi){
        this.attributi.add(attributi);
    }
}
