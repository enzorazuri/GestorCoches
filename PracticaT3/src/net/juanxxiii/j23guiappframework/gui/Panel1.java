package net.juanxxiii.j23guiappframework.gui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
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


public class Panel1 extends JPanel {
	/*public Image imagen;
	public URL fondo;/
	
	/**
	 * Create the panel.
	 */
	
	
	
	public Panel1() {	 
		
		setBackground(SystemColor.info);
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		btnNewButton_1.setIcon(new ImageIcon(Panel1.class.getResource("/iconos/CD.jpg")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Panel1.class.getResource("/iconos/Android Smartphone.jpg")));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Panel1.class.getResource("/iconos/Microphone 1.jpg")));
		toolBar.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		add(panel, BorderLayout.CENTER);

	}
}
