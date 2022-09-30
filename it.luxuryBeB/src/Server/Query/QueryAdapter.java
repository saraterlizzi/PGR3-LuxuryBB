package Server.Query;

import java.util.ArrayList;

public class QueryAdapter extends Query{

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
