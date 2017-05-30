package object;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	public static int C_id;
	public String C_email;
	public String C_nom;
	public String C_prenom;
	public String C_sex;
	public String C_address;
	public int C_cp;
	public String C_tel;
	public String C_work;
	public String C_bday;
	
	public static String tab_client 	= "Client";
	public static String tC_id 			= "C_id";
	public static String tC_email		= "C_email";
	public static String tC_password 	= "C_password";
	public static String tC_nom			= "C_nom";
	public static String tC_prenom		= "C_prenom";
	public static String tC_sex			= "C_sex";
	public static String tC_address		= "C_address";
	public static String tC_cp			= "C_cp";
	public static String tC_tel			= "C_tel";
	public static String tC_work		= "C_work";
	public static String tC_bday		= "C_bday";
			
	public User(int C_id, String C_email, String C_nom, String C_prenom, String C_sex, String C_address, 
			int C_cp, String C_tel, String C_work, String C_bday){
		User.C_id = C_id;
		this.C_email = C_email;
		this.C_nom = C_nom;
		this.C_prenom = C_prenom;
		this.C_sex = C_sex;
		this.C_address = C_address;
		this.C_cp = C_cp;
		this.C_tel = C_tel;
		this.C_work = C_work;
		this.C_bday = C_bday;
	}
	
	public static User createUser(ResultSet r) throws SQLException{
		int id = r.getInt(tC_id);
	    String email= r.getString(tC_email);
	    String nom = r.getString(tC_nom);
	    String prenom = r.getString(tC_prenom);
	    String sex = r.getString(tC_sex);
	    String address = r.getString(tC_address);
	    int cp = r.getInt(tC_cp);
	    String tel = r.getString(tC_tel);
	    String work = r.getString(tC_work);
	    String bday = r.getString(tC_bday);
	    User objectUser = new User(id, email, nom, prenom, sex, address, cp, tel, work, bday);
		return objectUser;
	}
	
	public static String stringUser(User a){
		String s = "{" 
				+  "\""  + tC_id + "\" : \"" + a.C_id  + "\"" + ","
				+  "\""  + tC_nom + "\" : \"" + a.C_nom  + "\"" + "," 
				+  "\""  + tC_prenom + "\" : \"" + a.C_prenom  + "\"" + "," 
				+  "\""  + tC_email + "\" : \"" + a.C_email  + "\"" + "," 
				+  "\""  + tC_sex + "\" : \"" + a.C_sex  + "\"" + ","
				+  "\""  + tC_address + "\" : \"" + a.C_address  + "\"" + "," 
				+  "\""  + tC_cp + "\" : \"" + a.C_cp  + "\"" + "," 
				+  "\""  + tC_tel + "\" : \"" + a.C_tel  + "\"" + "," 
				+  "\""  + tC_work + "\" : \"" + a.C_work  + "\"" + ","
				+  "\""  + tC_bday + "\" : \"" + a.C_bday  + "\"" 
					+ "}";
		return s;
	}
			
			
}
