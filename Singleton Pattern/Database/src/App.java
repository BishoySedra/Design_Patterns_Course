import javax.xml.crypto.Data;

class Database{

    // instance to the own class
    private static Database instance = null;

    // array to store queries strings
    private String[] queries = new String[10];

    // private constructor to prevent initialization using new from the app
    private Database(){};

    public static Database getInstance(){
        if(instance == null){
            synchronized(Database.class){
                if(instance == null){
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public void setQuery(int index, String query){
        queries[index] = query;
    }

    public String[] getAllQueries(){
        return queries;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
            Database db = Database.getInstance();
            db.setQuery(0, "SELECT * FROM users");
            db.setQuery(1, "SELECT * FROM products");
            db.setQuery(2, "SELECT * FROM orders");

            Database db2 = Database.getInstance();
            db2.setQuery(3, "SELECT * FROM categories");

            String[] queries = db2.getAllQueries();
            for(String query : queries){
                if(query != null)
                    System.out.println(query);
            }
    }
}
