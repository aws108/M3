package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Productes {

	public Productes() throws ClassNotFoundException, SQLException {
		
		
		try {
			
			
			//st=con.createStatement();
			
			String sentencia_sql="select * from productes ";
			
			//rs=st.executeQuery(sentencia_sql);
			
			System.out.println("\n----- PRECIO DE MAYOR A MENOR -------");
			
			
			System.out.println("--------------------------------------");
			
			
			
		} catch (Exception e) {
			System.out.println("Erro en conexión");
			
		}
		
	}
	
}
