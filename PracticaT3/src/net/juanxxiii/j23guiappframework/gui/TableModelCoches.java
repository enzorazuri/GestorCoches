package net.juanxxiii.j23guiappframework.gui;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 * 
 * @author Enzo Razuri
 *
 */
public class TableModelCoches implements TableModel{

	public ArrayList<Coche> coches;

	public TableModelCoches(ArrayList<Coche> _coches) {
		this.coches = _coches;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * DEVUELVE EL PARAMETRO SEGUN EL ENTERO QUE SE LE PASE
	 */
	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		
		switch (arg0){
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Float.class;
		case 3:
			return Float.class;
		default:
			return String.class;
			
		}
	}

	/**
	 * NUMERO DE COLUMNAS
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	/**
	 * NOMBRE DE CADA COLUMNA
	 */
	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex){
		case 0:
			return "Modelo";
		case 1:
			return "Marca";
		case 2:
			return "Consumo";
		case 3:
			return "Emisiones";
		default:
			return "";
			
		}
	}

	@Override
	/**
	 * CANTIDAD DE FILAS
	 */
	public int getRowCount() {
		// TODO Auto-generated method stub
		return coches.size();
	}


	/**
	 * DEVUELVE EL VALOR DEL PARAMETRO PASANDOLE LA FILA Y COLUMNA QUE DESEE EL USUARIO
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Coche c = coches.get(rowIndex);
		switch(columnIndex){
	 	case 0:
	 		return c.getnModelo();
	 	case 1:
	 		return c.getnMarca();
	 	case 2:
	 		return c.getConsumo();
	 	case 3:
	 		return c.getEmisiones();
	 	default:
	 		return null;
	
		}
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
