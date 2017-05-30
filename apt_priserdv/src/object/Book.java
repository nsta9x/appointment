package object;
import java.sql.ResultSet;
import java.sql.SQLException;

import object.Doctor;
import object.User;
public class Book {
	int R_id;
	int R_did;
	int R_cid;
	float R_heure;
	String R_date;
	String R_status;
	
	public static String tab_reservation	= "reservation";
	public static String tR_id				= "R_id";
	public static String tR_did				= "R_did";
	public static String tR_cid				= "R_cid";
	public static String tR_heure			= "R_heure";
	public static String tR_date			= "R_date";
	public static String tR_status			= "R_status";


public Book(int R_id, int R_did, int R_cid, float R_heure, String R_date, String R_status){
	this.R_id = R_id;
	this.R_did = R_did;
	this.R_cid = R_cid;	
	this.R_heure = R_heure;
	this.R_date = R_date;
	this.R_status = R_status;
}
public static Book createBook(ResultSet r) throws SQLException{
	int id=r.getInt(tR_id);
	int did=r.getInt(tR_did);
	int cid=r.getInt(tR_cid);
	float heure=r.getFloat(tR_heure);
	String date= r.getString(tR_date);
	String status= r.getString(tR_status);
	Book book = new Book(id, did, cid, heure, date, status);
	return book;
}
public static String stringBook(Book a){
	String s = "{" 
			+  "\""  + tR_id + "\" : \"" + a.R_id  + "\"" + ","
			+  "\""  + tR_did + "\" : \"" + a.R_did  + "\"" + ","
			+  "\""  + tR_cid + "\" : \"" + a.R_cid  + "\"" + ","
			+  "\""  + tR_heure + "\" : \"" + a.R_heure  + "\"" + ","
			+  "\""  + tR_date + "\" : \"" + a.R_date  + "\"" + ","
			+  "\""  + tR_status + "\" : \"" + a.R_status  + "\"" + ","
			+ "}";
	return s;
}
//SELECT * FROM reservation, doctor WHERE R_did = D_id AND D_cp='75013' AND D_spe = 'Dentiste'
public static String searchBook(int D_id){
	String sql = "SELECT * FROM " +  Book.tab_reservation + " WHERE  " 
			//+ Book.tR_did+ " = " + Doctor.tD_id+ " AND "
			+ Book.tR_did  +  " = '" + D_id +
			"';";	
	return sql;
}


}