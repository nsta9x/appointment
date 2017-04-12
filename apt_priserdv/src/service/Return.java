package service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class Return {
	public static String r_key_stat = "statut";
	public static String r_key_data = "data";
	
	public static int return_ok = 1;
	public static int return_wrong_pass = 2;
	public static int return_email_not_exist = 3;
	public static int return_exception = 4;
	
	
	public static void response(int statut, String data, HttpServletResponse response) throws IOException{
		// {"statut" : 1 , "data" : {"name":"A", "sex":"homme"}}
		String result = "{\"" 
					+ r_key_stat + "\" : \"" + statut + "\", "
					+ "\"" + r_key_data + "\" : " + data 		
					+ "}" ;
		response.getWriter().write(result);
	}
}
