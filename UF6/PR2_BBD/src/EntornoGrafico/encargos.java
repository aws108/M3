package EntornoGrafico;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import AccesoDatos.AccesoBBD;

public class encargos extends JFrame {
	
	
	private JButton aceptar;
	private JLabel labTitulo,conexion,nom,contra; 
	private JTextField usu;
	private JTextArea list;
	private JPasswordField pass;
	private JPanel panel1;
	double num=0;
	public AccesoBBD bd= new AccesoBBD();
	
	
	public encargos(String usu) throws SQLException{

		panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.setBorder(new TitledBorder("ENCARRECS"));



        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.CENTER;
        labTitulo = new JLabel("Nom               Num Pedido");
		labTitulo.setFont(new Font("Arial",Font.BOLD,12));
        panel1.add(labTitulo, gbc);
        
        gbc.gridy=1;
        gbc.gridwidth = 2;
        gbc.gridwidth = GridBagConstraints.CENTER;
      
        
        ArrayList<String> encargos=new ArrayList<>();
		encargos=bd.MostrarEnc(usu);
       
		list = new JTextArea();
		
		
        for(int i=0;i<encargos.size();i++){
        	if (i%2==0){
        		list.setText(list.getText()+encargos.get(i)+"\t"+encargos.get(i+1)+"\n");
        	}
        }
    	
        list.setEditable(false);
        list.setBackground(null);
        
        gbc.gridy=1;
        gbc.gridwidth = 2;
        panel1.add(list, gbc);
        
      
        
        this.add(panel1);
        this.setVisible(true);
		this.setSize(400,300);
		
		

	
}

}
