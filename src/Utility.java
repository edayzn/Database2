import  java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.*;
import java.sql.Statement;
import java.sql.ResultSet;


public class Utility {
 // public static String sgl;
    Connection connection = null;

    public static void main(String[] args) throws SQLException {
        Utility gst = new Utility();
        gst.goster();
    }

    public  void baglan(){
       System.out.println("-------- MySQL JDBC Connection Testing ------------");
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Where is your MySQL JDBC Driver?");
        Logger.getAnonymousLogger("Hayda!" + e);
        return;
    }
    System.out.println("MySQL JDBC Driver Registered!");
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proje", "root", "123456");
    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        Logger.getAnonymousLogger("Hayda!" + e);
        return;
    }
    if (connection != null) {
        System.out.println("You made it, take control your database now!");
    } else {
        System.out.println("Failed to make connection!");
    }
    }

    public void goster() throws SQLException {
        baglan();
        StringBuffer sgl = new StringBuffer("SELECT pkid,adi,ozellik,fiyat,altkategoriId From urunler");
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(String.valueOf(sgl));
        while (rs.next()) {

            int pkid = rs.getInt("pkid");
            String adi = rs.getString("adi");
            String ozellik = rs.getString("ozellik");
            int fiyat = rs.getInt("fiyat");
            int altkategoriId = rs.getInt("altkategoriId");

            System.out.print("ID: " + pkid);
            System.out.print(", adi: " + adi);
            System.out.print(", ozellik: " + ozellik);
            System.out.print(", fiyat: " + fiyat);
            System.out.println(", altkategoriId: " + altkategoriId);

        }
        connection.close();
        rs.close();
    }
}


