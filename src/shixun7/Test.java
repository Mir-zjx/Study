package shixun7;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws SQLException {
		UserDAO userdao = new UserDAO();
		//userdao.insertBookP("7", "zzz", "À²À²À²");
		//userdao.Update("4","tryet","rew");
		//userdao.Delete("8");
		userdao.queryBook();
	}
}
