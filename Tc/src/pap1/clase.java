package pap1;

public class clase {
	private String talla;
	private double cant;
	private double precio;
private String ropa;
public clase(String talla, int cant, double Precio, String ropa) {
	super();
	this.talla = talla;
	this.cant = cant;
	this.precio = Precio;
	this.ropa = ropa;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public double getCant() {
		return cant;
	}
	public void setCant(double cant) {
		this.cant = cant;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getRopa() {
		return ropa;
	}
	public void setRopa(String ropa) {
		this.ropa = ropa;
	}
}
