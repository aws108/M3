package EntornoGrafico;

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

import AccesoDatos.AccesoBBD;
import AccesoDatos.BuscarUsuario;

public class Usuarios extends JFrame {
	
	private JButton aceptar;
	private JLabel labTitulo,conexion,nom,contra; 
	private JTextField usu;
	private JPasswordField pass;
	private JPanel panel1;
	double num=0;
	
	public Usuarios(){
		
		 labTitulo = new JLabel( "Usuaris" );
		
		 labTitulo.setFont(new Font("Arial",Font.BOLD,16));
		 
			aceptar =new JButton ("Iniciar Sessio");
			
	
	        panel1 = new JPanel(new GridBagLayout());
	        panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);
	        gbc.gridx = GridBagConstraints.RELATIVE;
	        gbc.gridy = 0;

	       
	        gbc.gridy=4;
	        gbc.gridwidth = 4;
	        
	        gbc.gridwidth = GridBagConstraints.NONE;
	    	AccesoBBD bdp= new AccesoBBD();
	    	int a=bdp.abrirConexion();
	    	conexion = new JLabel( "Conexi�" );
	    	if(a==1){conexion.setForeground(Color.GREEN);}
	    	else{conexion.setForeground(Color.RED);}	
	    	
	    	nom = new JLabel("Usuari :");
	    	gbc.gridy=1;
		    gbc.gridwidth = 3;
	    	panel1.add(nom, gbc);
	    	
	    	usu = new JTextField(4);
	    	gbc.gridy=1;
		    gbc.gridwidth = 2;
	    	panel1.add(usu, gbc);
	    	
	    	contra = new JLabel("Contrasenya (ID): ");
	    	gbc.gridy=2;
		    gbc.gridwidth = 3;
	    	panel1.add(contra, gbc);
	    	
	    	
	    	pass = new JPasswordField(4);
	    	gbc.gridy=2;
		    gbc.gridwidth = 3;
	    	panel1.add(pass, gbc);
	    	
	    	
	    	gbc.gridy=3;
		    gbc.gridwidth = 4;
	    	panel1.add(conexion, gbc);
	        
	        gbc.gridy=0;
	        gbc.gridwidth = 3;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	        
	        panel1.add(labTitulo, gbc);
	        
	        gbc.gridy=5;
	        gbc.gridwidth = 3;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	        panel1.add(aceptar, gbc);
	  
	        this.add(panel1);
	        this.setVisible(true);
			this.setSize(400,300);
			
			
			 aceptar.addActionListener(
						new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
								char[] a=pass.getPassword();
								int contra= Integer.parseInt(String.valueOf(a) );
								AccesoBBD bd= new AccesoBBD();
								try {
									bd.BuscarUsuario(usu.getText(),contra);
									 new Encargo(usu.getText());
								} catch (SQLException e1) {
									JOptionPane.showMessageDialog(null,"Usuario incorrecto");
								}
								
								 
								 
								
						       
							}
						}
					);	
			
	
	}
	

	
}
