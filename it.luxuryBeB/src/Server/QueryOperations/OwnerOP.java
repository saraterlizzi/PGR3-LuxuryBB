package Server.QueryOperations;

import Server.Database;
import Server.Query.Operations;
import Server.Query.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerOP implements Operations {
    @Override
    public String get(String table, Query query) {
        Connection db = Database.getInstance().getConnection();
        try {
            Statement statement = db.createStatement();
            if (research(table, query, statement)){
                return "True";
            } else{
                return "False";
            }
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
                insert.append("'"+query.getAttributi().get(i)+"'");
                if(i<query.getValori().size()-1){
                    insert.append(",");
                }
            }
            insert.append(")");
            System.out.println(insert.toString());
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
