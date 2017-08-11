package tw.iii.ed.nba;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServerListener implements ServletContextListener{
	private ServletContext servletContext;
	
	@Override
	public void contextInitialized(ServletContextEvent e) {
		// TODO Auto-generated method stub
		try {
			servletContext = e.getServletContext();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost/nba","root","root");
			servletContext.setAttribute("conn", conn);
			servletContext.setAttribute("isConnection", true);
			System.out.println("connect ok");
		} catch (Exception e1) {
			servletContext.setAttribute("isConnection", false);
			System.out.println(e1);}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// TODO Auto-generated method stub
		if((Boolean)(servletContext.getAttribute("isConnection"))&&
				servletContext.getAttribute("conn") != null) {
			Connection conn = (Connection)servletContext.getAttribute("conn");
			try {
				conn.close();
			} catch (Exception e2) {System.out.println(e2);}
		}
	}
}
