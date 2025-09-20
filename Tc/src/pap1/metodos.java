package pap1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class metodos {
	private ArrayList<clase>estu;
	public metodos() {
		estu=new ArrayList<clase>();
	}

	public void adicionar(clase x) {
		estu.add(x);	
	}
	
	public int cant(){
		return estu.size();
	}
	
	public clase obtener(int x) {
		return estu.get(x);
	}
	
	public double PromedioGeneral() {
		double suma=0.0;
		for (int i = 0; i <cant(); i++) {
			suma+=obtener(i).getPrecio();
			
		}return suma/cant();
	}
	
	public clase buscar(String tall, String rop) {
		for (int i = 0; i < estu.size(); i++) {
			if (obtener(i).getRopa()==rop && obtener(i).getTalla()==tall )return obtener(i);
		}return null;
	}
	public void Eliminar(String tall, String rop) {
		for (int i = 0; i < estu.size(); i++) {
			if (obtener(i).getTalla()==tall && obtener(i).getRopa()==rop) {
				estu.remove(i);
				JOptionPane.showMessageDialog(null, "Dato eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "Datos no coinciden");
			}
		}
	}
}
