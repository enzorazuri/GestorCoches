package net.juanxxiii.j23guiappframework.gui;

import com.enzorazuri.persistencia.gui.*;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.enzorazuri.persistencia.gui.*;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.Statement;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import com.enzorazuri.persistencia.*;

public class Panel2 extends JPanel {
	private JTextField modeloJt;
	private JTextField consumoJt;
	private JTextField clasificacionJt;
	private JTextField emisionesJt;
	
	private float consumo;
	private float emisiones;
	private String clas;
	private String modelo;
	private int id;
	GestorBBDDcoches gc = new GestorBBDDcoches("root", "", "127.0.0.1", "bbdd_gestmotor");
	
	/**
	 * Create the panel.
	 */
	public Panel2() {

		
		setBackground(SystemColor.inactiveCaption);
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(255, 240, 245));
		add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(null);
		
		
		/*MODELO*/
		JLabel modeloJL = new JLabel("Modelo");
		modeloJL.setForeground(new Color(0, 0, 0));
		modeloJL.setHorizontalAlignment(SwingConstants.CENTER);
		modeloJL.setFont(new Font("Verdana", Font.BOLD, 17));
		modeloJL.setBounds(178, 95, 121, 36);
		panelDatos.add(modeloJL);
		
		modeloJt = new JTextField();
		modeloJt.setBounds(326, 103, 130, 20);
		panelDatos.add(modeloJt);
		modeloJt.setColumns(10);
		
		
		/*CONSUMO*/
		JLabel consumoJL = new JLabel("Consumo");
		consumoJL.setHorizontalAlignment(SwingConstants.CENTER);
		consumoJL.setFont(new Font("Verdana", Font.BOLD, 17));
		consumoJL.setBounds(178, 189, 121, 36);
		panelDatos.add(consumoJL);
		
		consumoJt = new JTextField();
		consumoJt.setColumns(10);
		consumoJt.setBounds(326, 197, 56, 20);
		panelDatos.add(consumoJt);	
		
		
		
		/*CLASIFICACION*/
		JLabel clasificacionJL = new JLabel("Clasificacion");
		clasificacionJL.setFont(new Font("Verdana", Font.BOLD, 17));
		clasificacionJL.setBounds(178, 301, 121, 36);
		panelDatos.add(clasificacionJL);
		
		clasificacionJt = new JTextField();
		clasificacionJt.setColumns(10);
		clasificacionJt.setBounds(326, 309, 26, 20);
		panelDatos.add(clasificacionJt);
		
		
		
		/*EMISIONES*/
		JLabel emisionesJL = new JLabel("Emisiones");
		emisionesJL.setFont(new Font("Verdana", Font.BOLD, 17));
		emisionesJL.setHorizontalAlignment(SwingConstants.CENTER);
		emisionesJL.setBounds(178, 247, 111, 36);
		panelDatos.add(emisionesJL);
		
	
		emisionesJt = new JTextField();
		emisionesJt.setColumns(10);
		emisionesJt.setBounds(326, 255, 56, 20);
		panelDatos.add(emisionesJt);			
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Verdana", Font.BOLD, 17));
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(188, 142, 111, 36);
		panelDatos.add(lblMarca);
		
		
		
		
		
		/*MARCAS - Lista*/
		JComboBox combo = new JComboBox();
		combo.setBounds(324, 150, 85, 20);
		panelDatos.add(combo);
		gc.comboMarcas(combo);
    	
    	
		/*AGREGAR - TITULO*/
		JLabel lblAgregar = new JLabel("AGREGAR");
		lblAgregar.setBackground(new Color(240, 248, 255));
		lblAgregar.setForeground(new Color(0, 0, 128));
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblAgregar.setBounds(218, 11, 191, 61);
		panelDatos.add(lblAgregar);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {

					
					if(gc.vacio(modeloJt,emisionesJt,clasificacionJt,consumoJt) == true){
						JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios.", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					
				
					
					gc.establecerConexion();		
					
					gc.getMarca(combo.getSelectedItem().toString()); 
	
					id = gc.setId();
					modelo = modeloJt.getText();//Pasar JTextField a String
					emisiones = Float.parseFloat(emisionesJt.getText());//Pasa a float un JTextField					
					clas = clasificacionJt.getText();
					consumo = Float.parseFloat(consumoJt.getText());
					

					gc.importarCochePS(id, modelo, consumo, emisiones, clas);
					
					
					JOptionPane.showMessageDialog(null, "Los datos han sido guardados.");
					gc.cerrarConexion();
										
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(NumberFormatException e){
					System.out.println("Los campos no pueden quedar vacios");
				}
				
		
			}

				
				
		});
		
		button.setIcon(new ImageIcon(Panel2.class.getResource("/assets/iconsapp/Save-as-icon.png")));
		toolBar.add(button);
		
		

	}
}
