package Sergio_Lizana_Grafico;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Sergio_Lizana_AccesoDatos.ConexionBBDD;

public class Pedidos extends JFrame{
	
	JLabel[] etiqueta;
	JTextField[] campo;
	private JPanel panel;
	ArrayList<String> producto;
	ConexionBBDD bbdd = new ConexionBBDD();
	
	public Pedidos(String usu){
		producto = new ArrayList<String>();
		producto = bbdd.HacerPedido();
		GridLayout column = new GridLayout(producto.size(),2); //El primer numero es el de filas y el segundo el de columnas
		panel = new JPanel();
		JButton aceptar = new JButton("Enviar!");
		panel.setLayout(column);
		etiqueta = new JLabel[producto.size()];//Array de etiquetas
		campo = new JTextField[producto.size()];
		for(int i=0;i<producto.size();i++){
			etiqueta[i] = new JLabel(producto.get(i));
			campo[i] = new JTextField("",6);
			panel.add(etiqueta[i]);
			panel.add(campo[i]);
			
		}
		aceptar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent evento3) {
					int[] cantidad = new int[producto.size()];
					for(int i=0;i<producto.size();i++){
						cantidad[i] = Integer.parseInt(campo[i].getText());
						bbdd.EnviarDatos();
						
					}
				}
			}
		);
		
		/*
		 public void actionPerformed(ActionEvent arg0) { 
								int id=bd.Encargo(usu);
								for(int i=0;i<lproductos.size();i++){
									if(num[i]>0){
										System.out.println(id+" - "+idprod[i]+" - "+num[i]);
										bd.LineaEncargo(id,idprod[i],num[i]);
		 
		 */
		
		this.add(panel, BorderLayout.NORTH);
		this.add(aceptar, BorderLayout.SOUTH);
		this.setSize(400,100);
		this.setVisible(true);
	}

}
