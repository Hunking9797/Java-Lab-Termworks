/*
 	Write a Java program to search and display details of book(s)
     authored by a particular author from a “BOOKS” table. 
 Assume an appropriate structure and attributes for the table.
 */
import java.util.Scanner;
import java.sql.*;

public class TW9 {
    public static void main(String[] args) throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the author name: ");
            String authorName = in.next();
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root","12345");
            Statement stmt = conn.createStatement();
            String sql = "select * from books where authorName = "+ authorName + ";" ;
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int bookId = rs.getInt("bookID");
                String bookName = rs.getString("bookName");
                System.out.println(bookId + " " + bookName);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.getStackTrace();
        }
    }
}
