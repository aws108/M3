package AccesoDatos;

import java.sql.*;

public class AccesoBBD {
	Connection con;
	Statement st;
	ResultSet rs;
	
	public int  abrirConexion(){
		try {
			String bd="productosbd";
			String user="root";
			String password="";
			String server="jdbc:mysql://localhost/"+bd;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(server,user,password);
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("Erro en conexión");
			return 0;
		}
		
		
	}
		
	public void cerrarConexion(){
		
		try {
			con.close();
			System.out.println("Conexión cerrada");
			
			
		} catch (Exception e) {
			
			System.out.println("Erro al cerrar conexión");
		}
		
	}


	public void BuscarUsuario(String usu, int contra) throws SQLException {
		 
		System.out.println(usu+"\n"+contra);
		
		st=con.createStatement();
		
		String sentencia_sql="select ID from clients where ID='"+contra+"' and NOM='"+usu+"'";
	
		rs=st.executeQuery(sentencia_sql);
	
		System.out.println("nadasdad");
				
	
	
	}
			

}
