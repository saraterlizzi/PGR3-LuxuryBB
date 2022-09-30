package Server.Query;

import java.sql.Statement;

public interface Operations {

    public String get(String table, Query query);

    public String add(String table, Query query);

    public String modify(String table, Query query);

    public boolean research(String table, Query query, Statement statement);
}
