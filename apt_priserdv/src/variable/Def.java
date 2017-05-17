package variable;

import object.User;

public class Def {
	public static final String dbUrl = "jdbc:mysql://hnv.hnv-tech.com:3306/test";
	public static final String dbUsername = "web101010";
	public static final String dbPassword = "web101010";
	
	public static String serviceLogin(String email, String pass){
		String sql = "SELECT * FROM " +  User.tab_client + " WHERE  " + User.tC_email  +  " = '" + email +
				"' AND " + User.tC_password + " = '" +  pass+"';";	
		return sql;
	}
}
