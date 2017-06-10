package EntornoGrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AccesoDatos.AccesoBBD;
import AccesoDatos.Productes;

public class Encargo extends JFrame {

	
	private JLabel labTitulo; 
	private JPanel panel1;
	private JTextArea list;
	double num=0;
	
	public Encargo(String usu){
		
		 labTitulo = new JLabel(usu);
		
		 labTitulo.setFont(new Font("Arial",Font.BOLD,16));
		 
	
	        panel1 = new JPanel(new GridBagLayout());
	        panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
	        
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(4, 4, 4, 4);
	        gbc.gridx = GridBagConstraints.RELATIVE;
	        gbc.gridy = 0;

	       
	        gbc.gridy=4;
	        gbc.gridwidth = 4;
	        
	        gbc.gridwidth = GridBagConstraints.NONE;
	    	
	        
	        gbc.gridy=0;
	        gbc.gridwidth = 3;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	        
	        panel1.add(labTitulo, gbc);
	        
	        
	        list =new JTextArea();
	        gbc.gridy=1;
	        gbc.gridwidth = 2;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	        //Productes a=new Productes();
	       // System.out.println());
	        list.setText("dasdasdad");
	        panel1.add(list, gbc);
	        
	        
	        
	        
	        this.add(panel1);
	        this.setVisible(true);
			this.setSize(400,300);
	
	
	}
	

	
}
