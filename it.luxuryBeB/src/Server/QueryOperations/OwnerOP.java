package Server.QueryOperations;

import Server.Database;
import Server.Query.Operations;
import Server.Query.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe che estende Operations per la gestione delle operazioni sul database, sottoparte Owner
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Operations
 */
public class OwnerOP implements Operations {
    /** Metodo per prendere esito dal database
     * @param table (tabella di riferimento)
     * @param query (query di riferimento)
     * @return l'esito della query
     */
    @Override
    public String get(String table, Query query) {
        Connection db = Database.getInstance().getConnection();
        try {
            Statement statement = db.createStatement();
            StringBuilder q = new StringBuilder();
            q.append("select * from "+table);

            StringBuilder list = new StringBuilder();
            ResultSet result = statement.executeQuery(String.valueOf(q));
            while(result.next()){
                list.append(result.getString(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4)+","+result.getString(5));
                if(!result.isLast()){
                    list.append("-");
                }
            }
            return list.toString();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** Metodo per prendere aggiungere dati al database
     * @param table (tabella di riferimento)
     * @param query (query di riferimento)
     * @return l'esito dell' aggiunta
     */
    @Override
    public String add(String table, Query query) {
        Connection db = Database.getInstance().getConnection();
        try {
            Statement statement = db.createStatement();
            if(research(table, query, statement)){
                return "False";
            }
            StringBuilder insert = new StringBuilder("insert into "+table+" values (");
            for (int i=0; i<query.getValori().size(); i++){
                insert.append("'"+query.getAttributi().get(i)+"'");
                if(i<query.getValori().size()-1){
                    insert.append(",");
                }
            }
            insert.append(")");
            statement.executeUpdate(insert.toString());
            return "True";
        } catch (SQLException e) {
            try {
                Statement statement = db.createStatement();
                if(research(table,query,statement)){
                    statement.executeUpdate("DELETE FROM "+table+" where "+query.getAttributi().get(0)+" = '"+query.getValori().get(0)+"'");
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return "False";
    }

    /** Metodo per modificare dati dal database
     * @param table (tabella di riferimento)
     * @param query (query di riferimento)
     * @return l'esito della modifica
     */
    @Override
    public String modify(String table, Query query) {
        Connection db = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = db.createStatement();
            StringBuilder q = new StringBuilder();
            q.append("UPDATE "+table+" set "+query.getValori().get(0)+" = "+query.getAttributi().get(0)+" where "+query.getValori().get(1)+" = "+query.getAttributi().get(1));
            System.out.println(q.toString());
            statement.executeUpdate(q.toString());
            return "True";
        } catch (SQLException e) {
            return "False";
        }
    }

    /** Metodo per ricercare query nel database
     * @param table (tabella di riferimento)
     * @param query (query di riferimento)
     * @return l'esito della ricerca
     */
    @Override
    public boolean research(String table, Query query, Statement statement) {
        StringBuilder q = new StringBuilder();
        q.append("select * from "+table+" where ");
        for (int i=0; i<query.getAttributi().size(); i++){
            q.append(query.getValori().get(i));
            q.append(" = '");
            q.append(query.getAttributi().get(i));
            q.append("' ");
            if (i!=query.getAttributi().size()-1){
                q.append("and ");
            }
        }
        try {
            ResultSet risultato = statement.executeQuery(q.toString());
            if(!risultato.next()){
                return false;
            } else{
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
