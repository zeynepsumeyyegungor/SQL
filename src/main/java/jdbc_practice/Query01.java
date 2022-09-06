package jdbc_practice;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        // 2. Adim: Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "hesma2015");

        // 3. Adim: Statement olustur.
        Statement st = con.createStatement();

        // 4. Adim: Query calistir.
        // 4) ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        // 5) Sonuclari al
        while(veri.next()){

            // index kullanarak
            System.out.println(veri.getInt(1)+veri.getString(2)+
                    veri.getString(3)+veri.getString(4));

            // stun ismi kullanarak
            System.out.println(veri.getInt("okul_no")+veri.getString("ogrenci_ismi")+
                    veri.getString("sinif")+veri.getString("cinsiyet"));
        }
        con.close();
        st.close();
    }
}
