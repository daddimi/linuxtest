package d01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaTest {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mariadb://192.168.111.100:3306/shopdb";
		String id = "winuser"; // 이름 다른 걸로 했으면 다른걸로 적기
		String password = "111111";
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, id, password);
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM items");
		// 마리아 디비는 대소문자 구분을 해서 items 나 id, name 이런 이름을 소문자로 바꿔줘야 한다.
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()) {
			String did = rset.getString("id");
			String name = rset.getString("name");
			int price = rset.getInt("price");
			System.out.println(did+" "+name+" "+price);
		}
		con.close();
	}

}
