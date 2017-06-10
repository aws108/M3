package EntornoGrafico;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import AccesoDatos.AccesoBBD;

public class Pais extends JFrame{
	AccesoBBD bd= new AccesoBBD();
	private JLabel labTitulo;
	JRadioButton[] rbuton;
	private JPanel panel1;
	private JTextArea list;
	private JButton pedir,cancelar;
	double num=0;
	int j=0,contadorB=0;
	int[]nombres;
	JButton[] buton;
	ArrayList<String> preu, info;
	ArrayList<String> lproductos;
	public AccesoBBD bdp= new AccesoBBD();

	public Pais(int[] num,String usu) throws SQLException{


			panel1 = new JPanel(new GridBagLayout());
	        panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        panel1.setBorder(new TitledBorder("LLista Pa�sos"));

	        gbc.gridy=0;
	        gbc.gridwidth = 1;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	        labTitulo = new JLabel("          ID     Pa�s");
			labTitulo.setFont(new Font("Arial",Font.BOLD,12));
	        panel1.add(labTitulo, gbc);



			list =new JTextArea();
	        gbc.gridy=1;
	        gbc.gridwidth = 2;
	        gbc.gridwidth = GridBagConstraints.CENTER;
	        lproductos=new ArrayList<>();
	        preu=new ArrayList<>();
	        info=new ArrayList<>();

	        lproductos=bd.listaProductos();
	        preu=bd.paisos();
	        rbuton=new JRadioButton[preu.size()];

	        list.setEditable(false);
	        list.setBackground(null);

	        int k=1;
	        nombres= new int[preu.size()];
	        for(int i=0;i<preu.size();i++){
	        	if(i%2==0){
	        		rbuton[contadorB]=new JRadioButton(preu.get(i)+"         "+preu.get(i+1));
	 	        	rbuton[contadorB].setName(""+contadorB);
	        		nombres[contadorB]=Integer.parseInt(preu.get(i));
	 	        	gbc.gridy=k++;
	 	        	gbc.gridwidth = 2;
	 	        	panel1.add(rbuton[contadorB],gbc);
	 	        	contadorB++;
	        	}
	        }


	        for (j=0;j<contadorB;j++){
					rbuton[j].addActionListener(
			     				new ActionListener(){
			     					public void actionPerformed(ActionEvent e){
			     						JRadioButton b=(JRadioButton)e.getSource();
			     						String nom=b.getName();
			     						 int nom2=Integer.parseInt(nom);
			     						 int puesto=Integer.parseInt(rbuton[nom2].getName());
			     						 info=bdp.busquedaPais(nombres[puesto]);

										JOptionPane.showMessageDialog(null,"PROD PAIS: \n"+info.get(1)+" : "+rbuton[nom2].getText()+"");
			     					}
			     				}
			     			);
				}




	        this.add(panel1);
	        this.setVisible(true);
			this.setSize(400,300);





	}
}
