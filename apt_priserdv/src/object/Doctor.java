package object;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Doctor {
	public int D_id;
	public String D_nom;
	public String D_prenom;
	public String D_email;
	public String D_sex;
	public String D_cabinet;
	public String D_adrress;
	public String D_tel;
	public int D_cp;
	public String D_spe;

	public static String tab_doctor 	= "doctor";
	public static String tD_id 			= "D_id";
	public static String tD_nom			= "D_nom";
	public static String tD_prenom		= "D_prenom";
	public static String tD_email		= "D_email";
	public static String tD_sex			= "D_sex";
	public static String tD_cabinet     = "D_cabinet";
	public static String tD_adrress		= "D_adrress";
	public static String tD_cp			= "D_cp";
	public static String tD_tel			= "D_tel";	
	public static String tD_spe			= "D_spe";
//name in database

public Doctor(int D_id, String D_nom, String D_prenom, String D_email, String D_sex, String D_cabinet, String 
		D_adrress, String D_tel, int D_cp, String D_spe){
	this.D_id = D_id;
	this.D_nom = D_nom;
	this.D_prenom = D_prenom;
	this.D_email = D_email;
	this.D_sex = D_sex;
	this.D_cabinet = D_cabinet;
	this.D_cabinet =D_cabinet;
	this.D_adrress = D_adrress;
	this.D_tel = D_tel;
	this.D_cp = D_cp;
	this.D_spe = D_spe;	
}

public static Doctor createDoctor(ResultSet r)throws SQLException{
	int id = r.getInt(tD_id);
	String nom = r.getString(tD_nom);
	String prenom = r.getString(tD_prenom);
	String email= r.getString(tD_email);
    String sex = r.getString(tD_sex);
    String cabinet= r.getString(tD_cabinet);
    String address = r.getString(tD_adrress);
    int cp = r.getInt(tD_cp);
    String tel = r.getString(tD_tel);
    String spe= r.getString(tD_spe);
    Doctor objectDoctor = new Doctor(id,  nom, prenom, email, sex, cabinet, address, tel, cp, spe);
	return objectDoctor;
}
public static String stringDoctor(Doctor a){
	String s = "{" 
			+  "\""  + tD_id + "\" : \"" + a.D_id  + "\"" + "," //nên dùng getId
			+  "\""  + tD_nom + "\" : \"" + a.D_nom  + "\"" + "," 
			+  "\""  + tD_prenom + "\" : \"" + a.D_prenom  + "\"" + "," 
			+  "\""  + tD_email + "\" : \"" + a.D_email  + "\"" + "," 
			+  "\""  + tD_sex + "\" : \"" + a.D_sex  + "\"" + ","
			+  "\""  + tD_cabinet + "\" : \"" + a.D_cabinet  + "\"" + ","
			+  "\""  + tD_adrress + "\" : \"" + a.D_adrress  + "\"" + ","
			+  "\""  + tD_tel + "\" : \"" + a.D_tel  + "\"" + ","
			+  "\""  + tD_cp + "\" : \"" + a.D_cp  + "\""
			+ "}";
	return s;
}
public static String searchDoctor(String spe, String cp){
	String sql = "SELECT * FROM " +  Doctor.tab_doctor + " WHERE  " 
			+ Doctor.tD_spe  +  " = '" + spe +
			"' AND " + Doctor.tD_cp + " = '" +  cp+
			"';";	
	return sql;
}
public void setId(int id){
	this.D_id = id;
}
public int getId(){
		return D_id;
}

}