package Sergio_Lizana_Grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Sergio_Lizana_AccesoDatos.ConexionBBDD;

public class LogIn extends JFrame{

	private JButton aceptar;
	private JLabel labTitulo,conexion,nombre,contra; 
	private JTextField usu;
	private JPasswordField pass;
	private JPanel panel;
	double num=0;
	ConexionBBDD bbdd = new ConexionBBDD();
	
	
	public LogIn(){
		labTitulo = new JLabel( "Usuarios" ); //Texto label. Titulo de la ventana
		labTitulo.setFont(new Font("Arial",Font.BOLD,12)); //Fuente del texto
		aceptar = new JButton ("Inicia Sesion"); //Botón
		
		panel = new JPanel(new GridBagLayout());//Parrilla donde se incluirá el codigo de arriba
        panel.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10)); //Bordes de la ventana
        
        GridBagConstraints constraint = new GridBagConstraints(); //Constraint que marca los límites del grid
      //Posiciónes: 
        constraint.anchor = GridBagConstraints.WEST; 
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.insets = new Insets(5, 5, 5, 5); //Para crear columnas, separaciones entre los elementos
        constraint.gridx = GridBagConstraints.RELATIVE; //Posición X
        constraint.gridy = 0; //Posición Y
        constraint.gridy = 4;
        constraint.gridwidth = 4; //Anchura
        constraint.gridwidth = GridBagConstraints.NONE;
    	
    
    		int si = bbdd.abrirConexion(); //Abrirremos conexión
    			conexion = new JLabel( "Conexion" ); //Panel de conexión
    				if(si == 1){ //Si se ha conectado
    					conexion.setForeground(Color.GREEN); //Pintamos de verde
    				}
    				else{
    					conexion.setForeground(Color.RED); //Si no se ha conectado, pintamos rojo
    				}
    	
    	//Añadir la conexión al panel
    	constraint.gridy=3;
    	constraint.gridwidth = 4;
    	panel.add(conexion, constraint);
    	
    	//Texto del panel. Usuario
    	nombre = new JLabel("Introduce el usuario :");
    	constraint.gridy=1; 
    	constraint.gridwidth = 3;
    	panel.add(nombre,constraint); //Añade la label al panel
    	
    	//TextField
    	usu = new JTextField(4);
    	constraint.gridy=1;
    	constraint.gridwidth = 2;
    	panel.add(usu, constraint);//Añadimos el TextField al panel
    	
    	//Texto del panel. Contraseña
    	contra = new JLabel("Mete la contraseña (*Es el ID): ");
    	constraint.gridy=2;
    	constraint.gridwidth = 3;
    	panel.add(contra, constraint); //Añadimos la label al panel
    	
    	//Campo de la contraseña
    	pass = new JPasswordField(4);
    	constraint.gridy=2;
    	constraint.gridwidth = 3;
    	panel.add(pass, constraint);//Añadimos el campo al panel
    	
    	//Settings de la ventana
    	constraint.gridy=0;
    	constraint.gridwidth = 3;
    	constraint.gridwidth = GridBagConstraints.CENTER;
        
    	//Añadir elementos de la ventana:
        panel.add(labTitulo, constraint); //Añadir el titulo al panel
    	
        constraint.gridy=5;
        constraint.gridwidth = 3;
        constraint.gridwidth = GridBagConstraints.CENTER;
        panel.add(aceptar, constraint); //Añadir el botón de aceptar al panel
        
        this.add(panel); //Añade el panel
        this.setVisible(true); //Que sea visible
		this.setSize(400,200); //Marcar el tamaño
		
		aceptar.addActionListener( //Añadir un Listener al aceptar
				new ActionListener(){ //Instanciarlo
					public void actionPerformed(ActionEvent evento) {
						char[] pss = pass.getPassword(); //Contraseña que cazas al aceptar
						int contra= Integer.parseInt(String.valueOf(pss) ); 
						//Lo que pillas de pss lo parseas a int y lo comparas con la id de la bbdd
						
						try { 
							bbdd.EncuentraUsuario(usu.getText(),contra);
							new Pedidos( usu.getText());
							 //new Encargo(usu.getText());
							System.out.println(usu.getText());
							System.out.println(contra);
						} 
						catch (SQLException e) {
							JOptionPane.showMessageDialog(null,"Usuario incorrecto");
						}
						
					}
				}
			);	
	

		}
        
}
