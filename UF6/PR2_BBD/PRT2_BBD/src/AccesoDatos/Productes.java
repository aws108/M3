package AccesoDatos;

import java.sql.*;

public class Productes extends AccesoBBD{
	
	
	private ResultSet rs;

	public  Productes() throws SQLException {
		System.out.println("--------------------------------------");
			
			st=con.createStatement();
			
			rs = st.executeQuery("SELECT * FROM productes ");
			
			System.out.println("--------------------------------------");
			
	
	}
	
}
