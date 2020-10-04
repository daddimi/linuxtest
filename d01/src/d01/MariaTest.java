package d01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaTest {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mariadb://192.168.111.100:3306/shopdb";
		String id = "winuser"; // �̸� �ٸ� �ɷ� ������ �ٸ��ɷ� ����
		String password = "111111";
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, id, password);
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM items");
		// ������ ���� ��ҹ��� ������ �ؼ� items �� id, name �̷� �̸��� �ҹ��ڷ� �ٲ���� �Ѵ�.
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
