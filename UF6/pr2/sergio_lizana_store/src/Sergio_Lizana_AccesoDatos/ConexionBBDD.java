package Sergio_Lizana_AccesoDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConexionBBDD{
	Connection con;
	Statement st;
	ResultSet rs;
	/*private int cliente;
	private int producto;*/
	private int idcliente;
	private String nombreCliente;
	private Scanner lector;
	
	public int abrirConexion(){
		try{
			String bd="store";
			String user="root";
			String password="brillante69";
			String server="jdbc:mysql://localhost/store?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");//driver de base de datos
			con = DriverManager.getConnection(server,user,password);//abrimos connecion con los parametros de la base de datos a conectar
			return 1;
		}
		catch (Exception e){
			System.out.println("Error en la conexion");
			return 0;
		}
		
	}
	//---------------------------------------------------------------------------------------------------
	
	//Abans de demanar el client i el producte mostrarà per pantalla tots els Clients i Productes
	
	
	//Hacer select del usuario, insert a la tabla encargo y un select de la tabla productos
	//Como un login de usuario, una pantalla con los productos que haga un insert con un campo de numeros
	//Pantalla para mostrar los encargos SELECT y SELECT de productos de un pais
	
	public void EncuentraUsuario(String usu, int pass) throws SQLException{
		
		abrirConexion();
		st =con.createStatement(); //Recupera los datos de la BD
		rs = st.executeQuery("SELECT idClientes, nombre FROM clientes WHERE idClientes ='"+pass+"' and nombre = '"+usu+"' ");
			 
	}
	
	//-------------------------------------------------------------------------------------
		public void cerrarConexion(){
			try{
				System.out.println("Conexion cerrada");
				con.close();
			}
			catch (SQLException e){
				System.out.println("Error al cerrar conexion");
			}
		}

}
