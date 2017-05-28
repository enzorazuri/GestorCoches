package net.juanxxiii.j23guiappframework.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Portada extends JPanel {

	public Image imagen;
	public URL fondo;
	
	/**
	 * Create the panel.
	 */
	
	/**
	 * ASIGNA LA IMAGEN A LAS VARIABLES CORRESPONDIENTES
	 * */
	
	public Portada() {
		
		setLayout(null);
		
		fondo = this.getClass().getResource("/assets/fondo/ferrari.jpg");
		imagen = new ImageIcon(fondo).getImage();
		
	}
	
	/**
	 * PINTA LA IMAGEN 
	 * 
	 * (0,0, SE UTILIZA PARA QUE EMPIECE DESDE LA ESQUINA)
	 * 
	 * CON EL GETWIDTH Y GETHEIGHT ABORDA TODO EL ESPACIO DE LA VENTANA,
	 * SE PUEDE CAMBIAR Y PONERLE UN TAMA�O FIJO
	 * 
	 * */
	public void paintComponent (Graphics g){
		g.drawImage(imagen, 0,0,getWidth(),getHeight(),null);
	}
}
