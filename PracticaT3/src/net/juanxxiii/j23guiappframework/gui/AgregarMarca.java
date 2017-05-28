package net.juanxxiii.j23guiappframework.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.enzorazuri.persistencia.gui.GestorBBDDcoches;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AgregarMarca extends JPanel {
	private JTextField marcaJT;
	private JTable table;
	GestorBBDDcoches gc = new GestorBBDDcoches("root", "", "127.0.0.1", "bbdd_gestmotor");
	String marca;
	/**
	 * Create the panel.
	 */
	public AgregarMarca() {
		
		try{
		setLayout(null);
		
		//BARRA DONDE VA EL BOTON DE GUARDAR
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 641, 57);
		toolBar.setBackground(new Color(255, 240, 245));
		add(toolBar);
		
		//JTEXTFIELD DE LA MARCA
		marcaJT = new JTextField();
		marcaJT.setFont(new Font("Tahoma", Font.BOLD, 14));
		marcaJT.setBounds(314, 227, 105, 20);
		add(marcaJT);
		marcaJT.setColumns(10);
		
		
		//BOTON DE AGREGAR UNA NUEVA MARCA
		JButton btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				marca = marcaJT.getText();
				
				int dialogResultado = JOptionPane.showConfirmDialog(null, "¿Quiere guardar la siguiente marca?",
						"Confirmacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				
				if(dialogResultado == JOptionPane.YES_OPTION){
					if(marcaJT.getText().isEmpty() != true && marca!=null){
					try{

				
				
					gc.establecerConexion();

					

					gc.agregaMarca(marca);
						
					JOptionPane.showMessageDialog(null, "Los datos han sido guardados.");
					

					gc.cerrarConexion();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch(NumberFormatException e){
						System.out.println("El campo no puede quedar vacio");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "El campo no puede estar vacio.", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
			}
		});
		btnAgregar.setBackground(new Color(255, 240, 245));
		btnAgregar.setIcon(new ImageIcon(AgregarMarca.class.getResource("/assets/iconsapp/Save-as-icon.png")));
		toolBar.add(btnAgregar);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Verdana", Font.BOLD, 17));
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(184, 217, 120, 38);
		add(lblMarca);
		

		
		JLabel lblAgregarMarca = new JLabel("AGREGAR MARCA");
		lblAgregarMarca.setForeground(Color.BLUE);
		lblAgregarMarca.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblAgregarMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarMarca.setBounds(167, 68, 298, 77);
		add(lblAgregarMarca);
		


	}catch(Exception e){
	}
		
		
	}
}
