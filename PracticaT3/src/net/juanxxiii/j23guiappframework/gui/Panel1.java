package net.juanxxiii.j23guiappframework.gui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

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


public class Panel1 extends JPanel {
	/*public Image imagen;
	public URL fondo;/
	
	/**
	 * Create the panel.
	 */
	
	
	GestorBBDDcoches gc = new GestorBBDDcoches("root", "", "127.0.0.1", "bbdd_gestmotor");
	private JTable table;
	private String nModelo;
	
	
	
	public Panel1() {	 
		
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
		lblMarca.setFont(new Font("Verdana", Font.BOLD, 15));
		
		
		//COMBO CON LAS MARCAS
		JComboBox combo = new JComboBox();
		combo.setBounds(324, 150, 85, 20);
		gc.comboMarcas(combo);
		
		
		JLabel lblConsumo = new JLabel("Consumo Max\r\n");
		lblConsumo.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JLabel consumoSl = new JLabel("");
		consumoSl.setHorizontalAlignment(SwingConstants.CENTER);
		consumoSl.setLabelFor(consumoSl);
		consumoSl.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		//SLIDER DEL CONSUMO MAXIMO
		JSlider slider = new JSlider();
		slider.setValue(10);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			
				consumoSl.setText(""+slider.getValue());
				
			}
		});
		slider.setBorder(new LineBorder(new Color(0, 0, 0)));
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(5);
		slider.setMaximum(25);
		
		
		
		GroupLayout gl_Filtros = new GroupLayout(Filtros);
		gl_Filtros.setHorizontalGroup(
			gl_Filtros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Filtros.createSequentialGroup()
					.addGap(51)
					.addComponent(lblMarca)
					.addGap(18)
					.addComponent(combo, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(consumoSl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(slider, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addGap(14))
		);
		gl_Filtros.setVerticalGroup(
			gl_Filtros.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Filtros.createSequentialGroup()
					.addContainerGap()
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(gl_Filtros.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Filtros.createParallelGroup(Alignment.LEADING)
						.addComponent(consumoSl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Filtros.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblConsumo)
							.addComponent(combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMarca)))
					.addGap(26))
		);
		Filtros.setLayout(gl_Filtros);
		
		
		ArrayList<Coche> coches = new ArrayList();
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		panelPrincipal.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
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
				
				JOptionPane.showMessageDialog(null, "Has pulsado: " + nModelo);
				
				
				try {
					System.out.println("NOMBRE DEL MDOELO: " + coches.get(pulsado).getnModelo()+ " y su id: "
				+ gc.getIdModelo(coches.get(pulsado).getnModelo()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonEliminar.setIcon(new ImageIcon(Panel1.class.getResource("/assets/iconsapp/recycle-bin-icon_Graph.png")));
		toolBar.add(botonEliminar);
		


			
		
		
		
		
		
				
		

	}
}
