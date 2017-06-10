package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarUsuario {

	Connection con;
	Statement st;
	ResultSet rs;
	
 public BuscarUsuario(String usu, int contra){
	 
		try {
			String bd="productosbd";
			String user="root";
			String password="";
			String server="jdbc:mysql://localhost/"+bd;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(server,user,password);
			
			
			Statement st=con.createStatement();
			
			String sentencia_sql="select * from productos  where NOM='"+usu+"'";
			
			rs=st.executeQuery(sentencia_sql);
			
			System.out.println("\n----- PRECIO DE MAYOR A MENOR -------");
			
			
			System.out.println("--------------------------------------");
			
			
			
		} catch (Exception e) {
			System.out.println("Erro en conexión productos");
			
		}
		
		
 
 }
}
