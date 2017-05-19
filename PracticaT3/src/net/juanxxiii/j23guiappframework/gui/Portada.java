package net.juanxxiii.j23guiappframework.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



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

		fondo = this.getClass().getResource("/assets/fondo/ferrari.jpg");
		imagen = new ImageIcon(fondo).getImage();
		
	}
	
	/**
	 * PINTA LA IMAGEN 
	 * 
	 * (0,0, SE UTILIZA PARA QUE EMPIECE DESDE LA ESQUINA)
	 * 
	 * CON EL GETWIDTH Y GETHEIGHT ABORDA TODO EL ESPACIO DE LA VENTANA,
	 * SE PUEDE CAMBIAR Y PONERLE UN TAMAÑO FIJO
	 * 
	 * */
	public void paintComponent (Graphics g){
		g.drawImage(imagen, 0,0,getWidth(),getHeight(),null);
	}

}
