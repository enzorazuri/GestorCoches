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
    
    public GestorBBDDcoches(String usr, String pwd, String ip, String bbddName) {
        super(usr, pwd, ip, bbddName);
    }
    
    
    public void getCoches(ArrayList <Coche> coches) throws ClassNotFoundException, SQLException{
    

    	
    	String sql = 
    			"select mar.MARCA, mo.MODELO, mo.CONSUMO, mo.EMISIONES "
    			+ "from marcas mar, modelos mo where mar.id=mo.ID_MARCA "
    			+ "and lower(marca) like'"+ marca + "' and consumo<"+ consumo + ";";
    	establecerConexion();
    	Statement st = conexion.createStatement();
    	ResultSet rs = st.executeQuery(sql);
    	while(rs.next()==true){
    		
    		coches.add(new Coche(rs.getString("modelo"), rs.getString("marca"), rs.getFloat("consumo"), rs.getFloat("emisiones")));
    		
    		System.out.println(rs.getString("Modelo"));
    		
    		
    		
    	}
    	cerrarConexion();
    }
    


    
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
     * 
     * @param boxMarca OBTIENE LA MARCA SELECCIONADA EN EL JCOMBOBOX
     */
    public void getMarca (String boxMarca){
    	
    	marca = boxMarca;
    	
    }
    
    
    public void getConsumo (int sliderConsumo){
    	consumo = sliderConsumo;
    }
    

    /**
     * 
     * @return DEVUELVE EL ID DE LA MARCA SELECCIONADA EN EL COMBO DEL FORMULARIO
     * 
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
    
    public void borrarCoche() throws SQLException{
    	
    	
    	Statement st = conexion.createStatement();
    	
    	ResultSet rs = st.executeQuery("delete * from modelos where id = "+ idModelo + ";");
    	
    	
    	
    }
    
    

    
    

	
    
    
    
}