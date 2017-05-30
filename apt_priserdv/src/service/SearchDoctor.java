package service;


import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import object.Book;
import variable.Def;
import object.Doctor;

@WebServlet( name="SearchDoctor", urlPatterns = "/SearchDoctor")
public class SearchDoctor extends HttpServlet {
	
	public SearchDoctor() {
		super(); //dung de goi lai HttpServlet
	}
	private static final long serialVersionUID = 1L; // bat buoc phai co
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
         
         String spe = request.getParameter("spe");
         String cp = request.getParameter("cp");
         
         try {  
        	 Class.forName("com.mysql.jdbc.Driver");
        	 Connection conn = DriverManager.getConnection(Def.dbUrl, Def.dbUsername, Def.dbPassword);
        	// Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/apt_priserdv","root", "");
        	 Statement stmt = conn.createStatement();
            
            // Step 2: Execute a SQL SELECT query
        	 
            String sql = Doctor.searchDoctor(spe, cp);
            ResultSet r = stmt.executeQuery(sql);
            r.last();
            int count=r.getRow(); // number of results
            //r.next();

            // Step 3: Process the query result set
            List<Doctor> listDoctor = new ArrayList<Doctor>();
            String s="";
            r.first();
            Doctor d;
            if(count>0){
            	d = Doctor.createDoctor(r);
            	listDoctor.add(d);
	            while (r.next()) {
	            	d = Doctor.createDoctor(r);
	            	listDoctor.add(d);         	
	          	
	            }
            }
            else{
            	Return.response(Return.return_wrong_pass, null, response);
            }
            
            
       
        Book b;
        String s2="";
        List<Book> listBook = new ArrayList<Book>();
        String s1="";
        int countBook=0;

        
        int D_id=0;
        for(int i=0; i<count;i++){
        	D_id = listDoctor.get(i).getId();
            String d1= Doctor.stringDoctor(listDoctor.get(i));
            String sqlBook = Book.searchBook(D_id);//"SELECT * FROM reservation WHERE R_did='1'";;//
            ResultSet rset = stmt.executeQuery(sqlBook);
            rset.last();
            countBook=rset.getRow();
            rset.first();
            if(countBook>0){
            	b = Book.createBook(rset);
            	listBook.add(b);
                while (rset.next()) {
                	b = Book.createBook(rset);
                	listBook.add(b);         	
              	
                }
           }
            
            for(int x=0;x<countBook;x++){
            	String b1=Book.stringBook(listBook.get(x));
            	s2 = s2+b1;
            }
            s1=s1+d1;
            
        }
        s=s+s1+s2;
        stmt.close();
        conn.close();
            Return.response(Return.return_ok, s, response);
        
         } catch (Exception ex) {
        	Return.response(Return.return_exception, "Error: " + ex, response);
        } finally {
        	 response.getWriter().close();
        }
    }
}