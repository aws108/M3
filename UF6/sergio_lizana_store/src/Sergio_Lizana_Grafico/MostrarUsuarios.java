package Sergio_Lizana_Grafico;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Sergio_Lizana_AccesoDatos.ConexionBBDD;

public class MostrarUsuarios extends JFrame{
	
	private JTextArea textarea1;
	private JScrollPane scrollpane1;
	private JPanel panel;
	
	ConexionBBDD bbdd = new ConexionBBDD();
	
	
	public MostrarUsuarios(){
		//Container c = this.getContentPane();
		this.setLayout(new FlowLayout());
		JLabel etiqueta = new JLabel("Usuarios");
		
		textarea1=new JTextArea();
		 
        textarea1.setBounds(10,50,400,300);
     
        this.add(etiqueta);
        
        scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(10,50,400,300);
        this.add(scrollpane1);
        
      
        bbdd.MostrarUsu();
        for(int i=0;i<bbdd.lista.size();i++){
        	textarea1.setText(textarea1.getText()+bbdd.lista.get(i)+"\n");
        }
        
     
        this.setVisible(true); //Que sea visible
		this.setSize(400,200); //Marcar el tamaño
		
		
						

	}

}