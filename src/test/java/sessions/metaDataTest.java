package sessions;

import java.sql.*;

public class metaDataTest {

    static String dbURL = "jdbc:mysql://localhost:3306/sakila";
    static String dbUsername = "root";
    static String dbPassword = "root";

    public static void main(String[] args) throws SQLException {


        //database ile bağlantı yapmamızı sağlar
        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword) ;

        //sql queryleri koşmamızı sağlar.
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //databaseden aldığımız dataları resultset içine atarız.
        ResultSet rs  = stmt.executeQuery(  "select * from customer"  );



        DatabaseMetaData dbMetaData = conn.getMetaData();

        System.out.println("username is "+dbMetaData.getUserName());
        System.out.println("driver version is "+dbMetaData.getDriverVersion());
        System.out.println("driver name is "+dbMetaData.getDriverName());
        System.out.println("product name is "+dbMetaData.getDatabaseProductName());

        System.out.println("------------------------------------");


        //tabloda kaç column var

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        System.out.println("column count is "+ columnCount);

        System.out.println("------------------------------------");


        //2. kolonun ismi nedir*
        //System.out.println("second column name is "+ rsmd.getColumnName(2));

        //tüm kolon isimleri yazdırmak için

        for (int i = 1; i <= columnCount; i++) {

            System.out.println("column name is "+ rsmd.getColumnName(i));
        }





        //testler sonunda connection kapalıtılır.
        rs.close();
        stmt.close();
        conn.close();



    }



}
