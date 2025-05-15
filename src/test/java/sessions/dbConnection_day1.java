package sessions;

import java.sql.*;

public class dbConnection {

static String dbURL = "jdbc:mysql://localhost:3306/sakila";
static String dbUsername = "root";
static String dbPassword = "root";


    public static void main(String[] args) throws SQLException {

        // DriverManager class will help us to create connection with the help getConnection method
        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword) ;

        // It helps us to execute queries
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // ResultSet Object will store data after execution.It stores only data
        ResultSet rs  = stmt.executeQuery(  "select first_name, last_name from customer"  );

        //get me first row info
        rs.next();
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        // get me second row
        rs.next();
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

           /*
        ResultSet.TYPE_SCROLL_INSENSITIVE--> To do flexible navigation
        ResultSet.CONCUR_READ_ONLY -->  This type of ResultSet Object is not updatable
         */

        //rs.previous -- > true if the cursor is now positioned on a valid row; false if the cursor is positioned before the first row
        rs.previous();
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        //get me last row information
        // last() --> true if the cursor is on a valid row; false if there are no rows in the result set
        rs.last();
        System.out.println(rs.getString(1)+" "+rs.getString(2));

        rs.first();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        // to print all data from beginning we need to move cursor into beforeFirstRow
        // Moves the cursor to the front of this ResultSet object, just before the first row.
        // This method has no effect if the result set contains no rows.
        rs.beforeFirst();

        //rs.afterLast();
        //System.out.println(rs.getString(1)+ " "+ rs.getString(2));

        // get data from row 8
        rs.absolute(8);
        System.out.println("row number is = "+rs.getRow());
        System.out.println(rs.getString(1)+ " "+ rs.getString(2));


        // How many row we have ?
        // getRow -->  the current row number; 0 if there is no current row
        System.out.println("Total row number is = " + rs.getRow());

        // HOW TO PRINT ALL RESULT SET INFO
        System.out.println("HOW TO PRINT ALL RESULT SET INFO");
        while (rs.next()){

            System.out.println(rs.getRow()+"_"+rs.getString(1)+ " "+ rs.getString(2));
        }



        // CLOSE CONNECTION
        rs.close();
        stmt.close();
        conn.close();

    }

}
