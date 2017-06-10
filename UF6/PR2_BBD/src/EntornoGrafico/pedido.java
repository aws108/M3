package EntornoGrafico;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import AccesoDatos.AccesoBBD;

public class pedido extends JFrame{
	
		AccesoBBD bd= new AccesoBBD();	
		private JLabel labTitulo,fecha; 
		private JPanel panel1;
		private JTextArea list;
		private JButton pedir,cancelar;
		double num=0;
		JTextField[] cant;
		int j=0, cont=0, idprod[];
		JButton[] buton;
		 ArrayList<String> lproductos;
		java.util.Date fechaActual = new Date();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
		public pedido(final int[] num,final String usu) throws SQLException{
			
		        
				
				
				
				panel1 = new JPanel(new GridBagLayout());
		        panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
		        
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.anchor = GridBagConstraints.WEST;
		        gbc.fill = GridBagConstraints.HORIZONTAL;
		        panel1.setBorder(new TitledBorder("TICKET : "+usu));
	 
	
		        
		        
		        

		        gbc.gridy=0;
		        gbc.gridwidth = 1;
		        gbc.gridwidth = GridBagConstraints.CENTER;
		        labTitulo = new JLabel("Nom               Quantitat                 Preu");
				labTitulo.setFont(new Font("Arial",Font.BOLD,12));
		        panel1.add(labTitulo, gbc);
		        
		      				
				list =new JTextArea();
		        gbc.gridy=1;
		        gbc.gridwidth = 2;
		        gbc.gridwidth = GridBagConstraints.CENTER;
		        lproductos=new ArrayList<>();
		        ArrayList<String> preu=new ArrayList<>();
		        lproductos=bd.listaProductos();
		        preu=bd.precios();
		        
		       
		        list.setEditable(false);
		        list.setBackground(null);
		       
		        
		       int resp=0,cant=0,cant2=0;
		       idprod= new int[lproductos.size()];
		       
		        for(int i=0;i<lproductos.size();i++){
		        	if(num[i]>0){
		        		cant=Integer.parseInt(preu.get(i));
		        		cant2=cant*num[i];
		        		resp=cant2+cant2;
		        		list.setText(list.getText()+lproductos.get(i)+"\t"+num[i]+"\t"+cant2+"€\n");
		        		idprod[i]=i;
		        		cont++;
		        	}
		        	
		        }
		    	
		        
		        String sum2 =String.valueOf(resp);
		    	list.setText(list.getText()+"---------------------------------------------------\n");
		    	list.setText(list.getText()+"TOTAL \t\t"+sum2+"\n\n");
		    	list.setText(list.getText()+"Fecha: "+formatoFecha.format(fechaActual)+"\t Hora: "+formatoHora.format(fechaActual));
		        gbc.gridy=1;
		        gbc.gridwidth = 2;
		        panel1.add(list, gbc);
		        
		        
		        
		        pedir = new JButton("Realitzar Comanda");
		        gbc.gridy=2;
	        	gbc.gridwidth = 1;
		        panel1.add(pedir,gbc);
		        
		        cancelar = new JButton("Cancel·lar");
		        gbc.gridy=2;
	        	gbc.gridwidth = 1;
		        panel1.add(cancelar,gbc);
		        
		        
		        this.add(panel1);
		        this.setVisible(true);
				this.setSize(400,300);
				
				
				pedir.addActionListener(
						new ActionListener(){
								public void actionPerformed(ActionEvent arg0) { 
								int id=bd.Encargo(usu);
								for(int i=0;i<lproductos.size();i++){
									if(num[i]>0){
										System.out.println(id+" - "+idprod[i]+" - "+num[i]);
										bd.LineaEncargo(id,idprod[i],num[i]);
						        	}
									}
								}
							}
					);
				
				
				cancelar.addActionListener(
							new ActionListener(){
									public void actionPerformed(ActionEvent arg0) { 
										 panel1.setVisible(false);
									}
								}
						);
				

		
		}
}
