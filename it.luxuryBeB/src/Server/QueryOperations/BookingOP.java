package Server.QueryOperations;

import Server.Database;
import Server.Query.Operations;
import Server.Query.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingOP implements Operations {
    @Override
    public String get(String table, Query query) {
        Connection db = Database.getInstance().getConnection();
        try {
            Statement statement = db.createStatement();
            StringBuilder q = new StringBuilder();
            q.append("select * from "+table+" where numero not in (select numero_stanza from booking where "+query.getValori().get(0)+" >= date '"+query.getAttributi().get(0)+"' AND "+query.getValori().get(1)+ " <= date '"+query.getAttributi().get(1)+"') AND stato = 1");
            System.out.println(q.toString());
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

    @Override
    public String add(String table, Query query) {

        return "False";
    }

    @Override
    public String modify(String table, Query query) {
       return null;
    }

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

    @Override
    public boolean research(String table, Query query, Statement statement) {
        return false;
    }
}
