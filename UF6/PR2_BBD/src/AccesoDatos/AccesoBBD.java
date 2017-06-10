package AccesoDatos;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AccesoBBD {
	  Connection con;
	  Statement st;
	  ResultSet rs,rs2;
	
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
			System.out.println("Error en conexión");
			return 0;
		}
		
		
	}
		
	public void cerrarConexion(){
		
		try {
			con.close();
			System.out.println("Conexión cerrada");
			
			
		} catch (Exception e) {
			
			System.out.println("Error al cerrar conexión");
		}
		
	}


	public int BuscarUsuario(String usu, int contra) throws SQLException {
				
		st=con.createStatement();

		ResultSet rs=st.executeQuery("select ID from clients where ID='"+contra+"' and NOM='"+usu+"'");
		
		if (rs.next()==false){
			
			return 0;
		}
	
		else {
			return 1;
		}
	
	}
	

	public  ArrayList<String>  listaProductos() {		
		
		ArrayList<String> prod = new ArrayList<>();
		try {
			abrirConexion();
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select nom from productes");
			while(rs.next()){
			
				prod.add((String) (rs.getString(1)));

			}
			
			
			
		} catch (SQLException e) {
			System.out.println("No se pudo acceder a lista");
			
		}
		
		return prod;
		
	}
	
	
	public  ArrayList<String>  precios() {		
		
		ArrayList<String> preu = new ArrayList<>();
		try {
			abrirConexion();
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select PREU from productes");
			while(rs.next()){
			
				preu.add((String) (rs.getString(1)));
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("No se pudo acceder a lista");
			
		}
		
		return preu;
		
	}
	
	public  ArrayList<String>  paisos() {		
		
		ArrayList<String> preu = new ArrayList<>();
		try {
			abrirConexion();
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from paisos");
			while(rs.next()){
			
				preu.add((String) (rs.getString(1)));
				preu.add((String) (rs.getString(2)));

			}
			

			
		} catch (SQLException e) {
			System.out.println("No se pudo acceder a lista");
			
		}
		
		return preu;
		
	}
	
	public  ArrayList<String>  busquedaPais(int IDp) {		
		
		ArrayList<String> info = new ArrayList<>();
		System.out.println("id "+IDp);

		try {
			abrirConexion();
			st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from productes where IDPAIS='"+IDp+"'");

			int i=1;
			while(rs.next()){
				
				info.add((String) (rs.getString(1)));
				info.add((String) (rs.getString(2)));
				info.add((String) (rs.getString(3)));
				info.add((String) (rs.getString(4)));

			}

			
			System.out.println(info);

			
		} catch (SQLException e) {
			System.out.println("No se pudo acceder a lista");
			
		}
		
		return info;
		
	}
	
	
	public int  Encargo(String usu) {
		
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	
		int id1=0;
        System.out.println(usu+"\t"+startDate);
        
		try {
			abrirConexion();
			st=con.createStatement();
			
			ResultSet rs2=st.executeQuery("select ID from clients where NOM='"+usu+"'");
			
			String id = null;
			while(rs2.next()){	
				id=rs2.getString(1);
			}		
			System.out.println(id);
			id1=Integer.parseInt(id);
			
			
			System.out.println("NO hay nada");
			
			PreparedStatement pst = con.prepareStatement("insert into encarrec2 (DATE , IDclient) values(?,?);");
		    pst.setDate(1,startDate);
		    pst.setInt(2,id1); 
		    pst.executeUpdate();
			
		
		    System.out.println("3");
			ResultSet rs3=st.executeQuery("select MAX(ID) from encarrec2 ");
			
			while(rs3.next()){	
					id1=Integer.parseInt(rs3.getString(1));
				}	
		    
	
			System.out.println("Actulizado correctamente ");
			
			
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar insetaar");
			
		}
		
		return id1;
		
	}
	
	public void  LineaEncargo(int id,int idPROD, int cantidad) {
		

		try {
			abrirConexion();
			
			PreparedStatement pst = con.prepareStatement("insert into liniaencarrec values(?,?,?);");
		    
			pst.setInt(1,id);
		    pst.setInt(2,idPROD); 
		    pst.setInt(3,cantidad);
		    pst.executeUpdate();
		
			System.out.println("Actulizado correctamente ");
			

			
		} catch (SQLException e) {
			System.out.println("Error al actualizar insetaar");
			
		}

	}
	
	public ArrayList<String> MostrarEnc(String usu) {
		
		ArrayList<String> info = new ArrayList<>();
		int id1=0;
		try {
			abrirConexion();
			st=con.createStatement();
			
			ResultSet rs2=st.executeQuery("select ID from clients where NOM='"+usu+"'");
			
			String id = null;
			while(rs2.next()){	
				id=rs2.getString(1);
			}	
			
			
			System.out.println(id);
			id1=Integer.parseInt(id);
			
			
			System.out.println("busco  "+id);
			
			ResultSet rs=st.executeQuery("select ID from encarrec2 where IDclient='"+id1+"'");

			while(rs.next()){
				info.add(usu);
				info.add((String) (rs.getString(1)));
			}
			
			System.out.println(info);

			
			System.out.println("Actulizado correctamente ");
	
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar buscar");
			
		}
		return info;

	}
	
	
}
