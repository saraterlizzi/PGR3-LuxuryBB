package Server.QueryOperations;

import Server.Database;
import Server.Query.Operations;
import Server.Query.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe che estende Operations per la gestione delle operazioni sul database, sottoparte Booking
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Operations
 */
public class BookingOP implements Operations {
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
            if (table.equals("Room")) {
                q.append("select * from "+table+" where numero not in (select numero_stanza from booking where "+query.getValori().get(0)+" >= date '"+query.getAttributi().get(0)+"' AND "+query.getValori().get(1)+ " <= date '"+query.getAttributi().get(1)+"') AND stato = 1");

            } else {
                q.append("select * from "+table+" where "+query.getValori().get(0)+" = '"+query.getAttributi().get(0)+"'");
            }
            StringBuilder list = new StringBuilder();
            ResultSet result = statement.executeQuery(String.valueOf(q));
            while(result.next()){
                list.append(result.getString(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4)+","+result.getString(5));
                if(!result.isLast()){
                    list.append("/");
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
       return null;
    }

    /** Metodo per cancellare dati nel database
     * @param table (tabella di riferimento)
     * @param query (query di riferimento)
     * @return l'esito della cancellazione
     */
    public String delete(String table, Query query){
        Connection db = Database.getInstance().getConnection();
        try {
            Statement statement = db.createStatement();
            String que = "DELETE FROM "+table+" WHERE "+query.getValori().get(0)+" = '"+query.getAttributi().get(0)+"'";
            statement.executeUpdate(que);
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
        return false;
    }
}
