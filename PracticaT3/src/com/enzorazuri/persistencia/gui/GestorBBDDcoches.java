/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enzorazuri.persistencia.gui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author dam1b
 */
public class GestorBBDDcoches extends GestorBBDD{
	
	String marca = "";
    
    public GestorBBDDcoches(String usr, String pwd, String ip, String bbddName) {
        super(usr, pwd, ip, bbddName);
    }
    
    
    public ArrayList<String> getCoches() throws ClassNotFoundException, SQLException{
    	ArrayList<String> coches = new ArrayList();
    	String sql = "select id,modelo from modelos limit 100";
    	establecerConexion();
    	Statement st = conexion.createStatement();
    	ResultSet rs = st.executeQuery(sql);
    	while(rs.next()==true){
    		System.out.println(rs.getInt(1));
    		System.out.println(rs.getString("Modelo"));
    	}
    	cerrarConexion();
    	return coches;
    }
    
    
    public void importarCoche(String modelo) throws SQLException{
        
        String sql = "INSERT INTO modelos(modelo) values('"+modelo+"');";
        Statement st;
        st=conexion.createStatement();
        st.executeUpdate(sql);
    }    
    
    
    /*Esta funcion es mas precisa que la anterior, 
    se utiliza para importar las poblaciones*/
    
    public void importarCochePS(int id,String modelo,float con,float emi,String cla) throws SQLException{
    	
    	
    	
	        String sql= 
	        		"INSERT INTO modelos (id_marca, modelo,consumo,emisiones,c_energetica) VALUES(?,?,?,?,?);";
	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.setString(2,modelo);   
	        ps.setFloat(3, con);
	        ps.setFloat(4,emi);
	        ps.setString(5, cla);
	        
        	ps.executeUpdate();
    	
        
        
    }
    
    public void getMarca (String boxMarca){
    	
    	marca = boxMarca;
    	
    }
    

    
    public int setId() throws SQLException{
    	
    	
    	int id;
    	
    	Statement st = conexion.createStatement();

		ResultSet rs = st.executeQuery("select id from marcas where lower(marca) like '"+marca+"'");
		
		rs.next();
		
		String idS = rs.getObject(1).toString();
		
		id = Integer.parseInt(idS);
    	
    	return id;    
    
    }
    
    
    
}