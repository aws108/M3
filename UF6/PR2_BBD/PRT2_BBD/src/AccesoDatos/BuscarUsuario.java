package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarUsuario extends AccesoBBD {

public int comprobar(String usu, int contra) throws SQLException {
		
		System.out.println(usu+"\n"+contra);
		
		 st=con.createStatement();

		ResultSet rs=st.executeQuery("select ID from clients where ID='"+contra+"' and NOM='"+usu+"'");

		
		if (rs.next()==false){
			
			return 0;
		}
	
		else {
			System.out.println("nadasdad");
			return 1;
		}
	}


}
