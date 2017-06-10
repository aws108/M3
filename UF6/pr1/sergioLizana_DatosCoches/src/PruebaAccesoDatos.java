
public class PruebaAccesoDatos {

	public static void main(String[] args) {
		
		AccesoDatos acc = new AccesoDatos();
		
		//Menu

		acc.abrirConexion();
		//acc.listarPropietarios();
		acc.modificarPrecio();
		//acc.eliminarCoche();
		
		acc.cerrarConexion();
		
	}

}
