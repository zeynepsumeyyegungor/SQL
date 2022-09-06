package jdbc_practice;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "hesma2015");
        Statement st = con.createStatement();
        ResultSet data = st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");

        // SORU: Öğrenciler tablosundaki erkek öğrencileri listeleyiniz.

        while(data.next()){
            //System.out.println(data.getInt(1)+" "+data.getString(2)+" "+data.getString(3)+" "+data.getString(4));
            // asıl çözüm bu, alttaki printf ile daha güzel görünsün diye bunu yoruma aldık
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", data.getInt(1), data.getString(2), data.getString(3), data.getString(4));
        }
    }
}
