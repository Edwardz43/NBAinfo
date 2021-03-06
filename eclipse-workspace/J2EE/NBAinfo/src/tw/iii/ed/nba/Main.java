package tw.iii.ed.nba;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Main")
public class Main extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Connection conn = (Connection)getServletContext().getAttribute("conn");
			//boolean isConnection = (boolean)getServletContext().getAttribute("isConnection");
			//System.out.println(conn.toString());
			
			Statement stmt = conn.createStatement();
			String sql = "select * from teams";
			ResultSet rs = stmt.executeQuery(sql);
			//rs.next();
			request.setAttribute("rs", rs);
			request.getRequestDispatcher("Main.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
