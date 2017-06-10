package Sergio_Lizana_AccesoDatos;

import Sergio_Lizana_Grafico.LogIn;
import Sergio_Lizana_Grafico.MostrarUsuarios;
import Sergio_Lizana_Grafico.Pedidos;

public class MainBBDD {

	
	public static void main(String[] args) {
		
		MostrarUsuarios most = new MostrarUsuarios();
		LogIn log = new LogIn();
		
		ConexionBBDD conexion = new ConexionBBDD();
	}

}