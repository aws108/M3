package Sergio_Lizana_AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ConexionBBDD{
	Connection con;
	Statement st;
	public ResultSet rs;
	public ResultSet sr;
	/*private int cliente;
	private int producto;*/
	private int idcliente;
	private String nombreCliente;
	private Scanner lector;
	
	public ArrayList<String> lista=new ArrayList<String>();
	
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
	
		
	//insert a la tabla encargo y un select de la tabla productos
	//una pantalla con los productos que haga un insert con un campo de numeros
	//Pantalla para mostrar los encargos SELECT y SELECT de productos de un pais
	
	public void MostrarUsu(){
		try{
			abrirConexion();
			st =con.createStatement();
			rs = st.executeQuery("SELECT idClientes, nombre FROM clientes");
		
			while(rs.next()){
				String cad=rs.getInt(1)+" "+rs.getString(2);
				lista.add(cad);
			}
			
		}
		catch (Exception e){
			System.out.println("No se han encontrado usuarios");
			
		}
	}
	
	public void EncuentraUsuario(String usu, int pass) throws SQLException{
		
		abrirConexion();
		st =con.createStatement(); //Recupera los datos de la BD
		rs = st.executeQuery("SELECT idClientes, nombre FROM clientes WHERE idClientes ='"+pass+"' and nombre = '"+usu+"' ");		 
	}
	
	public ArrayList<String> HacerPedido(){
		ArrayList<String> producto = new ArrayList(); //Creas un arraylist de producto
		abrirConexion();
		try{
			st =con.createStatement();
			rs = st.executeQuery("SELECT nombre FROM productos");
			while(rs.next()){
				producto.add(rs.getString(1));
			}
		}catch(SQLException ex){
			System.out.println("Error en la conexion");
		}
	System.out.print(producto);
	return producto;
	}
	
	public void EnviarDatos(){
		abrirConexion();
			try{
				st =con.createStatement();
				rs = st.executeQuery("INSERT INTO encargo VALUES(?,?,?");
				sr = st.executeQuery("INSERT INTO lineaEncargo VALUES(?,?,?");
			}
			catch(SQLException exc){
				System.out.println("Error en la conexion");
			}
	}
	
	public int Encargo(String usu){
		Calendar calendario = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendario.getTime().getTime());
		int id = 0;
		
		System.out.println(usu+"\n");
		System.out.println(startDate+"\n");
		
		try{
			abrirConexion();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT idCLientes FROM clientes WHERE nombre = '"+usu+"' ");
			
			String idd = null;
			while(rs.next()){
				idd = rs.getString(1);
			}
			System.out.println(idd);
			id = Integer.parseInt(idd);
			
			System.out.println("Empty");
			
			PreparedStatement pre = con.prepareStatement("INSERT INTO encargo (DATE, idClientes) VALUES(?,?); ");
			pre.setDate(1,startDate);
			pre.setInt(2, id);
			pre.executeUpdate();
			
			System.out.println("3");
			
		}catch(SQLException exe){
			System.out.println("Error al insertar");
		}
		return id;
	}
	
	public void LineaEncargo(int idLinEncargo, int idLinEncarProd, int cantidad){
		try{
			abrirConexion();
			PreparedStatement prep = con.prepareStatement("INSERT INTO liniaEncargo VALUES(?;?;?); ");
			prep.setInt(1,idLinEncargo);
			prep.setInt(2,idLinEncarProd);
			prep.setInt(3,cantidad);
			prep.executeUpdate();
			
			System.out.println("Actualizado correstamente");
		}catch(SQLException exep){
			System.out.println("Error al azctualizar");
		}
		
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