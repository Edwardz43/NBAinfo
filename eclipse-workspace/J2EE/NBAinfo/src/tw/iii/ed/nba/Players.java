package tw.iii.ed.nba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Players")
public class Players extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Connection conn = (Connection)getServletContext().getAttribute("conn");
			String id = request.getParameter("teamID");
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT playerID, firstname, lastname, number, pos, picture, name" + 
					"		FROM players as p JOIN teams as t on p.teamID = t.teamID" + 
					"		where p.teamID = " + id;
			ResultSet rs = stmt.executeQuery(sql);
			//rs.next();
			request.setAttribute("rs", rs);
			request.getRequestDispatcher("Players.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
