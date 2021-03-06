import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//La conexión a la base de datos y la consulta de la
//misma se desarrollará en una clase java llamada AccesoDatos
public class AccesoDatos {
	Connection con;
	Statement st;
	ResultSet rs;
	private String matricula;
	private String marca;
	private int precio;
	private String dni;
	private Scanner lector;
	
	public void abrirConexion(){
		try{
			String bd="DatosCoches";
			String user="root";
			String password="brillante69";
			String server="jdbc:mysql://localhost:3306/DatosCoches?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");//driver de base de datos
			con = DriverManager.getConnection(server,user,password);//abrimos connecion con los parametros de la base de datos a conectar
		}
		catch (Exception e){
			System.out.println("Error en la conexion");
		}
	}
	
	//------------------------------------------------------------------------------------
	public void obtenerregistros(){
		//Obtener los registros de la tabla Coches ordenados según el precio de mayor a menor.
		try {
			 st =con.createStatement(); //Recupera los datos de la BD
			 rs = st.executeQuery("SELECT * FROM Coches ORDER BY precio DESC");
			 rs.next();
			 while (rs.next()) {
	//Esto es un ResulSet que se desplaza hacia delante, como un puntero que recorre los campos
				 String matricula = rs.getString("Matricula");
				 String marca = rs.getString("Marca");
				 int precio = rs.getInt("Precio");
				System.out.println(matricula + ", " + marca + ", " +precio); 
				}
			} 
			catch (SQLException e){
			 System.out.println("Error al acceder a la tabla ");
			}
	}
	
//Si quiero acceder a todos los registros del ResultSet, tengo que usar el método 'next' y así
//moverme por los registros y métodos para sacar la info de cada campo con un getInt, getFloat, getString, etc.
		
//Cuando recorro el ResultSet hay que saber cuando he llegado al final de éste y se hace con el 'next'
//El 'next' va de registro en registro y devuelve un falso cuando ha llegado al último registro
	
	
	public void listarPropietarios() {
		 try {
			  
			 st =con.createStatement(); //Recupera los datos de la BD
			 rs = st.executeQuery("SELECT pro.DNI, co.Marca FROM Propietarios pro, Coches co WHERE pro.DNI=co.DNI;");
			//Union de tablas Propietarios pro Coches co. Donde el DNI del Propietarios es igual al del Coches 
			 while (rs.next()){
				 int DNI = rs.getInt("DNI");
				 String marca = rs.getString("Marca");
				 System.out.println(DNI + ", " + marca); 
			 	}
			} 
		 catch (SQLException e){
			 System.out.println("Error al acceder a la tabla ");
				}
	} 
	
	
	public void modificarPrecio(){
//Modificar el precio de los coches. Le pedirá al usuario una matrícula y cambiará el precio de ese coche.
//A la hora de modificar el en vez de executeQuery, se usará 'executeUpdate' que devuelve la cantidad de registros afectados
		lector = new Scanner(System.in);
		System.out.print("Introduce una matricula: ");
		this.matricula=lector.toString(); //Todo lo que introduzcas se parseara a String
		lector.nextLine();
		System.out.print("Introduce el nuevo precio: ");
		this.precio=lector.nextInt();
		
		try{
			String sql_sentencia="UPDATE Coches SET Precio="+ precio +" WHERE Matricula = '"+ matricula + "'; ";
			PreparedStatement prep = con.prepareStatement(sql_sentencia);
			prep.executeUpdate();
			System.out.println("Modificacion Correcta");
			
		}
		catch (SQLException e){
			 System.out.println("Error al modificar");
		} 
	}

	public void eliminarCoche(){
		lector = new Scanner(System.in);
		System.out.print("Introduce una matricula a borrar: ");
		this.matricula=lector.toString();
		lector.nextLine();
		
		try{
			st =con.createStatement();
			st.executeUpdate("DELETE FROM Coches WHERE Matricula = '"+ matricula + "';");
			System.out.println("Se ha eliminado Correctamente");
		}
		catch (SQLException e){
			 System.out.println("Error al modificar");
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
