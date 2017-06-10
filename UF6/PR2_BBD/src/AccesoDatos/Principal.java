package AccesoDatos;

import EntornoGrafico.Usuarios;

public class Principal {
	
	public static void main(String[] args) {
	
		
		AccesoBBD bd= new AccesoBBD();
		
		Usuarios entorno=new Usuarios();
		
		bd.cerrarConexion();
		
		
	}
}
