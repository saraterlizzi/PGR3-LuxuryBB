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
            if(table.equals("Room")){
                q.append("select * from Room where stato stato = 1");
            }else {
                q.append("select * from "+table+" where "+query.getAttributi().get(0)+" = "+query.getValori().get(0));
            }
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
        Connection db = Database.getInstance().getConnection();
        try {
            Statement statement = db.createStatement();
            if(research(table, query, statement)){
                return "False";
            }
            StringBuilder insert = new StringBuilder("insert into "+table+" values (");
            for (int i=0; i<query.getValori().size(); i++){
                insert.append("'").append(query.getAttributi().get(i)).append("'");
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

    @Override
    public String modify(String table, Query query) {
       return null;
    }

    @Override
    public boolean research(String table, Query query, Statement statement) {
        return false;
    }
}