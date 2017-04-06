package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            // Step 1: Open a connection to Server
            Class.forName("com.mysql.jdbc.Driver");  //JDBC Tool de ket noi voi database luc nao cung the
            
            Connection conn = DriverManager.getConnection(
                    Def.dbUrl, Def.dbUsername, Def.dbPassword);
            Statement stmt = conn.createStatement();
            
            // Step 2: Execute a SQL SELECT query
            String sql = Def.serviceLogin(user, pass);
            ResultSet rset = stmt.executeQuery(sql);

            // Step 3: Process the query result set
            if (rset.next()) {
            	//id username password 
            	String r_realname = rset.getString(Def.tab_user_realname);
   
            	response.getWriter().write(
            			r_realname
            			
            			
            		f	);      			
            }
            else{
            	response.getWriter().write("Error");
            }
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            response.getWriter().write("Error");
        } catch (ClassNotFoundException e) {
        	response.getWriter().write("Error");
        } finally {
        	 response.getWriter().close();
        }
    }
}