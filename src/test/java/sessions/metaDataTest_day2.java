package sessions;

import java.sql.*;

public class metaDataTest {

    static String dbURL = "jdbc:mysql://localhost:3306/sakila";
    static String dbUsername = "root";
    static String dbPassword = "root";

    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs  = stmt.executeQuery(  "select * from customer"  );

        // Database MetaData --> It is information about database itself
        DatabaseMetaData dbMetaData = conn.getMetaData();

        System.out.println("username is "+dbMetaData.getUserName());
        System.out.println("driver version is "+dbMetaData.getDriverVersion());
        System.out.println("driver name is "+dbMetaData.getDriverName());
        System.out.println("product name is "+dbMetaData.getDatabaseProductName());

        System.out.println("------------------------------------");


        // ResultSet MetaData --> It provides information about table upper side (columnName or columnCount)
        ResultSetMetaData rsmd = rs.getMetaData();

        // how many column we have ?
        int columnCount = rsmd.getColumnCount();
        System.out.println("column count is "+ columnCount);

        System.out.println("------------------------------------");


        // what is the name of my second column?
        System.out.println("second column name is "+ rsmd.getColumnName(2));

        // how can we get all column names?
        for (int i = 1; i <= columnCount; i++) {

            System.out.println("column name is "+ rsmd.getColumnName(i));
        }


        // how can we get all table info?
        System.out.println(" ---- PRINT ALL DATA DYNAMICALLY ----- ");

        // iterate each row
        while(rs.next()){
            // iterate each column
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i)+"-"+rs.getString(i)+" ");
            }
            System.out.println();
        }


        //testler sonunda connection kapalıtılır.
        rs.close();
        stmt.close();
        conn.close();


    }

}
