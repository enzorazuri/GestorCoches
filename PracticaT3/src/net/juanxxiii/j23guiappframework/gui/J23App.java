package net.juanxxiii.j23guiappframework.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;
import java.awt.Color;

public class J23App extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J23App frame = new J23App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public J23App() {
		
		getContentPane().setLayout(new CardLayout(0, 0));
		setTitle("Gestion de Vehiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 479);		
		
		
		//CAMBIO DE LOOK&FEEL A WINDOWS
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Windows".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		/*AÑADE MENU*/
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnPanel = new JMenu("Panel");
		menuBar.add(mnPanel);
		
		
		
		
		/*PANEL1 EN MENU*/
		JMenuItem mntmPanel_1 = new JMenuItem("CONSULTAR");
		mntmPanel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Pantalla1");
			}
		});
		JMenuItem mntmInicio = new JMenuItem("INICIO");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Portada");
			}
		});
		mnPanel.add(mntmInicio);
		mnPanel.add(mntmPanel_1);
		
		/*PORTADA DE INICIO EN MENU*/
		
		
		/*AGREGAR EN MENU*/
		JMenuItem mntmAgregar = new JMenuItem("AGREGAR");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Pantalla2");
			}
		});
		mnPanel.add(mntmAgregar);		
		

		
		/*MENU HELP*/
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		/*MENU ABOUT*/
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(J23App.this,
					    "By Enzo Razuri - 2017.",
					    "Ma",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		
		
		/*CONTENT PANE*/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		/*AGREGA PANEL1 PANEL2 Y PORTADA*/
		
		Portada portada = new Portada();
		Panel1 panel1 = new Panel1();
		Panel2 panel2 = new Panel2();
		
		contentPane.add(portada,"Portada");
		contentPane.add(panel1,"Pantalla1");
		contentPane.add(panel2, "Pantalla2");
		
		
		portada.setLayout(null);
		
		
		
		
		/*ASIGNANDO FUNCION AL BOTON DE CONSULTAR*/
		JButton btnNewButton = new JButton("CONSULTAR ");
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(160, 82, 45));
		btnNewButton.setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Pantalla1");	
				
			}
		});
		JButton btnNewButton_1 = new JButton("AGREGAR");
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(new Color(160, 82, 45));
		btnNewButton_1.setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Pantalla2");
				
			}
		});
		btnNewButton_1.setBounds(160, 308, 117, 31);
		portada.add(btnNewButton_1);
		btnNewButton.setBounds(312, 308, 150, 29);
		portada.add(btnNewButton);
		
		/*ASIGNANDO FUNCION AL BOTON DE AGREGAR*/
		
		
	}
}
