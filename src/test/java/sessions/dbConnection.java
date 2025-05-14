package sessions;

import java.sql.*;

public class dbConnection {

static String dbURL = "jdbc:mysql://localhost:3306/sakila";
static String dbUsername = "root";
static String dbPassword = "root";


    public static void main(String[] args) throws SQLException {

        //database ile bağlantı yapmamızı sağlar
        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword) ;

        //sql queryleri koşmamızı sağlar.
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //databaseden aldığımız dataları resultset içine atarız.
        ResultSet rs  = stmt.executeQuery(  "select first_name, last_name from customer"  );

        //ilk rowdaki 1. index ve 2. index teki datayı getirir.
        rs.next();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        rs.next();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        rs.previous();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        rs.last();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        rs.first();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        rs.beforeFirst();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        //rs.next();
        //rs.next();

        //rs.afterLast();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        /*
        rs.absolute(8);
        System.out.println("row number is = "+rs.getRow());
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));
        */

        //tablodaki tüm veriyi nasıl yazdırırız?
        System.out.println("tüm verilerin dökümü");

        while (rs.next()){

            System.out.println(rs.getRow()+"_"+rs.getString(1)+ " "+ rs.getString(2));

        }




        //testler sonunda connection kapalıtılır.
        rs.close();
        stmt.close();
        conn.close();


    }

}
