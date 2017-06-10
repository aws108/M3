package EntornoGrafico;
import AccesoDatos.AccesoBBD;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.StringValueExp;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import AccesoDatos.AccesoBBD;

public class Encargo extends JFrame {
	AccesoBBD bd= new AccesoBBD();	
	private JLabel labTitulo; 
	private JPanel panel1;
	private JTextArea list;
	private JButton pedir,pais,mostrarEnc;
	double num=0;
	JTextField[] cant;
	int j=0;
	JButton[] buton;
	String usu=null;
	 ArrayList<String> lproductos=new ArrayList<>();
	 
	public Encargo(String usu) throws SQLException{
		
		 labTitulo = new JLabel(usu);
		
		 labTitulo.setFont(new Font("Arial",Font.BOLD,16));
		 
	
	        panel1 = new JPanel(new GridBagLayout());
	        panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
	        
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	
 
	        gbc.gridy=0;
	        gbc.gridwidth = 1;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	        
	        panel1.add(labTitulo, gbc);
	        
	       
	      
	        gbc.gridy=1;
	        gbc.gridwidth = 2;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	       
	        
	        lproductos=bd.listaProductos();
	        
	        JLabel[] nom=new JLabel[lproductos.size()];
	        cant= new JTextField[lproductos.size()];
	        buton= new JButton[lproductos.size()];
	        
	        int k=1;
	        for(int i=0;i<lproductos.size();i++){
	        	String id=String.valueOf(i+1);
	        	nom[i]=new JLabel(id+" "+lproductos.get(i)); 
	        	cant[i]= new JTextField("0",2);
	        	buton[i]= new JButton("+");
	        	gbc.gridy=k++;
	        	gbc.gridwidth = 2;
	        	panel1.add(nom[i],gbc);
	        	panel1.add(cant[i],gbc);
	        	buton[i].setBackground( SystemColor.control );
	        	buton[i].setBounds(new Rectangle(50,50,50,50));
	        	buton[i].setName(""+i);
	        	panel1.add(buton[i],gbc);
	      
	        }
	        
	        pedir = new JButton("Afegir compra");
	        gbc.gridy=k++;
        	gbc.gridwidth = 2;
	        panel1.add(pedir,gbc);
	        
	        pais = new JButton("Mostar Països");
	        gbc.gridy=k++;
        	gbc.gridwidth = 2;
	        panel1.add(pais,gbc);
	        
	        
	        mostrarEnc = new JButton("Mostar Encarrec");
	        gbc.gridy=k++;
        	gbc.gridwidth = 2;
	        panel1.add(mostrarEnc,gbc);
	        
	        this.add(panel1);
	        this.setVisible(true);
			this.setSize(400,300);
			
			for (j=0;j<lproductos.size();j++){
			buton[j].addActionListener(
		     				new ActionListener(){
		     					public void actionPerformed(ActionEvent e){
		     						JButton b=(JButton)e.getSource();
		     						String nom=b.getName();
		     						 int nom2=Integer.parseInt(nom);
		     						String sum = cant[nom2].getText();
		     						int result = Integer.parseInt(sum);
		     						result= result+1;
		     						String sum2 =String.valueOf(result);
		     						cant[nom2].setText(sum2);
		     					}
		     				}
		     			);
			}
		
			
	
			 pedir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
		
							try {
								
								int pedido[]=new int[lproductos.size()];
								for(int i=0;i<lproductos.size();i++){
									
									int num=Integer.parseInt(cant[i].getText());
									pedido[i]=num;

								}
				
								new pedido(pedido,labTitulo.getText());
								
							} catch (SQLException e1) {
								
								e1.printStackTrace();
							}
							}

						}
						
					);
			
	
			 pais.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
		
							try {
								
								int pedido[]=new int[lproductos.size()];
								for(int i=0;i<lproductos.size();i++){
									
									int num=Integer.parseInt(cant[i].getText());
									pedido[i]=num;

								}
				
								new Pais(pedido,labTitulo.getText());
								
								
							} catch (SQLException e1) {
								
								e1.printStackTrace();
							}
							}

						}
						
					);
			
			
			 
			 mostrarEnc.addActionListener(
	     				new ActionListener(){
	     					public void actionPerformed(ActionEvent e){
	     						
	     						try {
									new encargos(labTitulo.getText());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
	     						
	     						
	     						
	     					}
	     				}
	     			);
	
	}
	

	
}
