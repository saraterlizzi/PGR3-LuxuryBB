package Server.Query;

import java.util.ArrayList;

/**Classe che estende la funzione Query per l'applicazione del pattern adapter
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Query
 */
public class QueryAdapter extends Query{

    /**Metodo che adatta le stringhe prese in input per inserirle nella query
     * @param x
     * @return query
     */
    public Query adapter(ArrayList<String> x){

        Query query = new Query();

        for(int n=0; n< x.size(); n++){
            if(n%2==0){
                query.addValori(x.get(n));
            } else{
                query.addAttributo(x.get(n));
            }
        }
        return query;
    }
}
