package variable;

public class Def {
	public static final String dbUrl = "A";
	public static final String dbUsername = "A";
	public static final String dbPassword = "A";
	
	public static String tab_user = "T_User";
	public static String tab_user_name 	= "username";
	public static String tab_user_pass		="password";
	public static String tab_user_realname = "realname";
	
	public static String serviceLogin(String user, String pass){
		String sql = "SELECT * FROM " +  tab_user + " WHERE  " + tab_user_name  +  " = " + user +
				"AND " + tab_user_pass + " = " +  pass;	
		return sql;
	}
}
