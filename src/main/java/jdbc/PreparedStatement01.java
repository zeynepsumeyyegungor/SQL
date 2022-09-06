package jdbc;

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "hesma2015");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin

        // 1. Adim : Prepared statement query'sini olustur

        String sql1 = "UPDATE companies SET number_of_employees = ?  WHERE company = ? ";


        // 2. Adim : PreparedStatement objesini olustur
        PreparedStatement pst1 = con.prepareStatement(sql1);


        // 3. Adim : set...() methodlari ile soru isaretleri icin deger girin.
        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");

        // 4. Adim : Execute query
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi.");

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()){

            System.out.println(result1.getInt(1)+"--"+result1.getString(2)+"--"+result1.getInt(3));
        }

        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        String sql4 = "SELECT * FROM ?";

        PreparedStatement pst2 = con.prepareStatement(sql4);
        pst2.setString(1,"companies");

        ResultSet result4 = pst2.executeQuery();
        while (result4.next()) {

            System.out.println(result4.getInt(1)+"- -"+result4.getString(2)+"- -"+result4.getInt(3));


        }
    }
}
