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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.juanxxiii.j23guiappframework.gui.Coche;

/**
 *
 * @author dam1b
 */
public class GestorBBDDcoches extends GestorBBDD{
	
	String marca = "";
	int consumo;
    int idModelo;
    String todas =  "Todas las marcas";
    
    public GestorBBDDcoches(String usr, String pwd, String ip, String bbddName) {
        super(usr, pwd, ip, bbddName);
    }
    
  
    
    /**
     * 
     * RECOGE LOS COCHES QUE SE ENCUENTRAN EN LA CONSULTA Y LOS METE EN EL ARRAY
     * 
     * @param coches
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void getCoches(ArrayList <Coche> coches) throws ClassNotFoundException, SQLException{
    
    	if(marca.equals(todas)==true){
    		
        	String sql = 
        			"select mar.*, mo.MODELO, mo.CONSUMO, mo.EMISIONES "
        			+ "from marcas mar, modelos mo where mar.id=mo.ID_MARCA "
        			+ "and consumo<=" + consumo + ";";
        	establecerConexion();
        	Statement st = conexion.createStatement();
        	ResultSet rs = st.executeQuery(sql);
        	while(rs.next()==true){
        		
        		coches.add(new Coche(rs.getString("modelo"), rs.getString("marca"), rs.getFloat("consumo"), rs.getFloat("emisiones")));
        		
        		System.out.println(rs.getString("Modelo"));
        		
        	
        		
        	}
        	
        	cerrarConexion();
    		
    	}else{
	    	
	    	String sql = 
	    			"select mar.MARCA, mo.MODELO, mo.CONSUMO, mo.EMISIONES "
	    			+ "from marcas mar, modelos mo where mar.id=mo.ID_MARCA "
	    			+ "and lower(marca) like'"+ marca + "' and consumo<="
	    					+ ""+ consumo + ";";
	    	establecerConexion();
	    	Statement st = conexion.createStatement();
	    	ResultSet rs = st.executeQuery(sql);
	    	while(rs.next()==true){
	    		
	    		coches.add(new Coche(rs.getString("modelo"), rs.getString("marca"), rs.getFloat("consumo"), rs.getFloat("emisiones")));
	    		
	    		System.out.println(rs.getString("Modelo"));
	    		
	    	
	    		
	    	}
	    	cerrarConexion();}
    }
    


    /**
     * 
     * IMPORTA EL MODELO HACIA LA TABLA DE MODELOS CON SUS RESPECTIVOS CAMPOS
     * 
     * @param id: ID DE LA MARCA
     * @param modelo: NOMBRE DEL MODELO 
     * @param con: CONSUMO 
     * @param emi: EMISIONES
     * @param cla: CLASIFICACION
     * @throws SQLException
     */
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
    
    
    /**
     * 
     * @param combo RECOGE TODAS LAS MARCAS Y LAS METE EN EL JCOMBOBOX
     */
    public void comboMarcas(JComboBox combo){
    	
    	
    	
    	try {
    		GestorBBDD gestor = new GestorBBDD("root", "", "127.0.0.1", "bbdd_gestmotor");
			gestor.establecerConexion();
			Statement stat = (Statement) gestor.conexion.createStatement();
			ResultSet resultado = stat.executeQuery("SELECT marca from marcas");
			while(resultado.next()){
				combo.addItem(resultado.getObject("marca"));
			}
				
			gestor.cerrarConexion();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
   
    }
    
    
    /**
     * OBTIENE LA MARCA SELECCIONADA EN EL JCOMBOBOX
     * @param boxMarca 
     */
    public void getMarca (String boxMarca){
    	
    	marca = boxMarca;
    	
    }
    
    
    /**
     * OBTIENE EL CONSUMO MARCADO EN EL SLIDER
     * @param sliderConsumo  
     */
    public void getConsumo (int sliderConsumo){
    	consumo = sliderConsumo;
    }
    

    /**
     * @return DEVUELVE EL ID DE LA MARCA SELECCIONADA EN EL COMBO DEL FORMULARIO
     * @throws SQLException
     */
    public int setId() throws SQLException{
    	
    	
    	int id;
    	
    	Statement st = conexion.createStatement();

		ResultSet rs = st.executeQuery("select id from marcas where lower(marca) like '"+marca+"'");
		
		rs.next();
		
		String idS = rs.getObject(1).toString();
		
		id = Integer.parseInt(idS);
    	
    	return id;    
    
    }
    
    
    
    
    /**
     * 
     * @param textFields CAMPOS DEL FORMULARIO
     * @return DEVUELVE TRUE SI ALGUN CAMPO ESTA VACIO
     */
    public boolean vacio(JTextField...textFields){
    	
    	for(JTextField textField : textFields){
    		if(textField.getText().isEmpty()){
    			return true;
    		}
    	}
    	
		return false;
    	
    }
    
    /**
     * OBTIENE EL ID DEL MODELO SELECCIONADO
     * 
     * @param modelo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void getIdModelo(String modelo) throws SQLException, ClassNotFoundException{
    	
    	
    	establecerConexion();
    	
    	Statement st = conexion.createStatement();
    	
    	ResultSet rs = st.executeQuery("select id from modelos where modelo like '"+ modelo +"';");
		
    	rs.next();
    	
    	String idSt = rs.getObject("id").toString();
    	
    	idModelo = Integer.parseInt(idSt);
    	
    	cerrarConexion();
    	
    }
    
    public void mostrarId(){
    	
    	
    	System.out.println("id: " + idModelo);
    	
    }
    
    public void borrarCoche() throws SQLException, ClassNotFoundException{
    	
    	establecerConexion();
    	
    	Statement st = conexion.createStatement();
    	
    	ResultSet rs = st.executeQuery("delete * from modelos where id = "+ idModelo + ";");
    	
    	cerrarConexion();
    	
    }
    
    

    /* TERMINAR : MULTIPLICAR POR 10 PARA OBTENER EL ENTERO
    public int consumoMax() throws SQLException{
    	
    	float consMaxFlo;
    	int consMax;
    	
    	Statement st = conexion.createStatement();

		ResultSet rs = st.executeQuery("select max(consumo) from modelos");
		
		rs.next();
		
		consMaxFlo = rs.getFloat(1);
	
    	consMax = (int) (consMaxFlo * 10);
		
    	return consMax;    
   
    	
    }*/

	
    
    
    
}