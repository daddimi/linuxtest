package d01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleTest {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@192.168.111.111:1521:xe";
		String id = "semi";
		String password = "111111";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(url, id, password);
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MENU");
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()) {
			String did = rset.getString("ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			int tsales = rset.getInt("TSALES");
			int category = rset.getInt("CATEGORY");
			String img1 = rset.getString("IMG1");
			String img2 = rset.getString("IMG2");
			String img3 = rset.getString("IMG3");
			System.out.println(did+" "+name+" "+price);
		}
		con.close();
	}

}
