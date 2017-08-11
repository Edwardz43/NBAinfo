package tw.iii.ed.nba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlayerDetails")
public class PlayerDetails extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Connection conn = (Connection)getServletContext().getAttribute("conn");
			String id = request.getParameter("id");
			boolean isEmpty = false;
			Map<String, String> player = new HashMap<>();
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT *, "
					+"FORMAT(min / gp, 1) as mpg," 
					+"FORMAT(pts / gp, 1) as ppg,"
					+"FORMAT(reb / gp, 1) as rpg," 
					+"FORMAT(ast / gp, 1) as apg," 
					+"FORMAT(blk / gp, 1) as bpg " 
					+"FROM players as p, career as c "
					+"where p.playerID ="+ id +" and c.playerID ="+ id;
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.next()) {
				sql = "select * from players where playerID = " + id;
				rs = stmt.executeQuery(sql);
				isEmpty = true;
			}
			rs.beforeFirst();
			if(rs.next()) {
				player.put("firstname", rs.getString("firstname"));
				player.put("lastname", rs.getString("lastname"));
				player.put("picture", rs.getString("picture"));
				player.put("number", rs.getString("number"));
				player.put("pos", rs.getString("pos"));
				player.put("height", rs.getString("height"));
				player.put("weight", rs.getString("weight"));
				player.put("debut", rs.getString("debut"));
				player.put("from", rs.getString("[from]"));
				player.put("born", rs.getString("born"));
				player.put("age", rs.getString("age"));
				player.put("website", rs.getString("website"));
				if(!isEmpty) {
					player.put("mpg", rs.getString("mpg"));
					player.put("fg%", rs.getString("fg%"));
					player.put("3p%", rs.getString("3p%"));
					player.put("ft%", rs.getString("ft%"));
					player.put("ppg", rs.getString("ppg"));
					player.put("rpg", rs.getString("rpg"));
					player.put("apg", rs.getString("apg"));
					player.put("bpg", rs.getString("bpg"));
				}
			}
			request.setAttribute("isEmpty", isEmpty);
			request.setAttribute("player", player);
			request.getRequestDispatcher("PlayerDetails.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
}
