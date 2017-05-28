/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enzorazuri.persistencia.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author dam1b
 */
public class GestorBBDD {
    
    public Connection conexion;
    private String usr; 
    private String pwd;
    private String ip;
    private String bbddName;
    private int puerto;

    public GestorBBDD(String usr, String pwd, String ip, String bbddName, int puerto) {
        this.usr = usr;
        this.pwd = pwd;
        this.ip = ip;
        this.bbddName = bbddName;
        this.puerto = puerto;
    }
    
    public GestorBBDD(String usr, String pwd, String ip, String bbddName) {
        this.usr = usr;
        this.pwd = pwd;
        this.ip = ip;
        this.bbddName = bbddName;
        this.puerto=3306;
        
    }
                                    
    
    public void establecerConexion() throws ClassNotFoundException, SQLException{
    
    try{
    PreparedStatement st = null;
    String driver="com.mysql.jdbc.Driver";
    Class.forName(driver);
    String servidor="jdbc:mysql://"+ip+"/"+bbddName;
    String user=usr;
    String pass=pwd;
    conexion=DriverManager.getConnection(servidor,user,pass);
    }catch(Exception e){
    	System.out.println("Base de datos apagada.");
    }
    }
    
    
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    
}