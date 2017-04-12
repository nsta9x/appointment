package service;

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

import object.User;
import variable.Def;

@WebServlet( name="Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
	
	public Login() {
		super(); //dung de goi lai HttpServlet
	}
	private static final long serialVersionUID = 1L; // bat buoc phai co
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
         
         String user = request.getParameter("username");
         String pass = request.getParameter("password");
         
         try {  
        	 Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    Def.dbUrl, Def.dbUsername, Def.dbPassword);
            Statement stmt = conn.createStatement();
            
            // Step 2: Execute a SQL SELECT query
            String sql = Def.serviceLogin(user, pass);
            ResultSet rset = stmt.executeQuery(sql);

            // Step 3: Process the query result set
            if (rset.next()) {
            	//id username password
            	User a 	= User.createUser(rset);
            	String b= User.stringUser(a);
            	response.getWriter().write(b);
            }
            else{
            	response.getWriter().write("Pas de resultat");
            }
            stmt.close();
            conn.close();
            
        } catch (Exception ex) {
            response.getWriter().write("Error:  " + ex);
        } finally {
        	 response.getWriter().close();
        }
    }
}