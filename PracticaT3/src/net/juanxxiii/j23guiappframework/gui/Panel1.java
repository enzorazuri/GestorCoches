package net.juanxxiii.j23guiappframework.gui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JToolBar;

import com.enzorazuri.persistencia.gui.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javafx.scene.layout.Border;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;


public class Panel1 extends JPanel {
	/*public Image imagen;
	public URL fondo;/
	
	/**
	 * Create the panel.
	 */
	
	
	GestorBBDDcoches gc = new GestorBBDDcoches("root", "", "127.0.0.1", "bbdd_gestmotor");
	private JTable table;
	private String nModelo;

	
	
	public Panel1() throws SQLException {	 
		
		setBackground(SystemColor.info);
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		//PANEL PRINCIPAL ENGLOBA FILTROS Y TABLA
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 240, 245));
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		
		//PANEL PARA LOS FILTROS DE MARCAS Y CONSUMO
		JPanel Filtros = new JPanel();
		Filtros.setBackground(new Color(255, 240, 245));
		panelPrincipal.add(Filtros, BorderLayout.NORTH);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Verdana", Font.BOLD, 13));
		
		
		//COMBO CON LAS MARCAS
		JComboBox combo = new JComboBox();
		combo.setToolTipText("");
		combo.setBounds(324, 150, 85, 20);
		combo.addItem("Todas las marcas");
		gc.comboMarcas(combo);
		
		
		JLabel lblConsumo = new JLabel("Consumo Max\r\n:");
		lblConsumo.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JLabel consumoSl = new JLabel("");
		consumoSl.setBackground(Color.WHITE);
		consumoSl.setFont(new Font("Verdana", Font.BOLD, 13));
		consumoSl.setHorizontalAlignment(SwingConstants.CENTER);
		consumoSl.setLabelFor(consumoSl);
		
		//SLIDER DEL CONSUMO MAXIMO
		JSlider slider = new JSlider();
		slider.setBackground(new Color(255, 240, 245));
		
		
		slider.setValue(10);
		

		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			
				//convierte a float el entero para obtener los decimales
				consumoSl.setText(""+(float)slider.getValue()/10);
				
			}
		});
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
	
		try {
			slider.setMaximum(gc.consumoMax());
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel minimoSl = new JLabel("");
		minimoSl.setHorizontalAlignment(SwingConstants.CENTER);
		minimoSl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		minimoSl.setText(""+(float)slider.getMinimum()/10);
		
		
		
		JLabel maximoSl = new JLabel("");
		maximoSl.setHorizontalAlignment(SwingConstants.CENTER);
		maximoSl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		maximoSl.setText(""+(float)slider.getMaximum()/10);
		
		
		GroupLayout gl_Filtros = new GroupLayout(Filtros);
		gl_Filtros.setHorizontalGroup(
			gl_Filtros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Filtros.createSequentialGroup()
					.addGroup(gl_Filtros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Filtros.createSequentialGroup()
							.addGap(94)
							.addComponent(lblMarca))
						.addGroup(gl_Filtros.createSequentialGroup()
							.addGap(60)
							.addComponent(combo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(consumoSl, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addGroup(gl_Filtros.createParallelGroup(Alignment.LEADING, false)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Filtros.createSequentialGroup()
							.addComponent(minimoSl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(maximoSl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_Filtros.setVerticalGroup(
			gl_Filtros.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Filtros.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMarca)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(gl_Filtros.createSequentialGroup()
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Filtros.createParallelGroup(Alignment.BASELINE)
						.addComponent(minimoSl)
						.addComponent(maximoSl))
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_Filtros.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_Filtros.createParallelGroup(Alignment.LEADING)
						.addComponent(consumoSl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblConsumo, Alignment.TRAILING))
					.addGap(30))
		);
		Filtros.setLayout(gl_Filtros);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		panelPrincipal.add(scrollPane, BorderLayout.CENTER);//AGREGA EL SCROLLPANEL AL PANEL  
		
		
		ArrayList<Coche> coches = new ArrayList();
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		

		table.setModel(new DefaultTableModel());
		
		//BUSCAR
		JButton botonBuscar = new JButton("");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					coches.clear();
					

					gc.getConsumo(slider.getValue());
					gc.getMarca(combo.getSelectedItem().toString());			
					
					try {
						gc.getCoches(coches);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					TableModelCoches tmc = new TableModelCoches(coches);
					table.setModel(tmc);


			}
		});

		botonBuscar.setIcon(new ImageIcon(Panel1.class.getResource("/assets/iconsapp/zoom-icon_Graph.png")));
		toolBar.add(botonBuscar);
		

		
		//BUTTON FOR DELETE A CAR
		JButton botonEliminar = new JButton("");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


					int pulsado = table.getSelectedRow();
					
					nModelo = coches.get(pulsado).getnModelo();
					
					try {
						gc.getIdModelo(nModelo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
					
					int dialogResultado = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar este modelo?",
							"Confirmacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					
					if(dialogResultado==JOptionPane.YES_OPTION){	
						
					try {
						gc.borrarCoche();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "La operacion se ha realizado con exito.", "", JOptionPane.INFORMATION_MESSAGE);
					
					coches.clear();
					

					gc.getConsumo(slider.getValue());
					gc.getMarca(combo.getSelectedItem().toString());			
					
					try {
						gc.getCoches(coches);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					TableModelCoches tmc = new TableModelCoches(coches);
					table.setModel(tmc);
					}		
						
									

				
				
				
				
			}
		});
		botonEliminar.setIcon(new ImageIcon(Panel1.class.getResource("/assets/iconsapp/recycle-bin-icon_Graph.png")));
		toolBar.add(botonEliminar);
		


			
		
		
		
		
		
				
		

	}
}
