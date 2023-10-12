package ventasArticulos2;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


public class Articulo {
	
	private Artic artic;
	private ArrayList<Ventas> listaVenta;
	
	
	public Articulo() {}
	
	public Articulo(Artic artic, ArrayList<Ventas> listaVenta) {
		super();
		this.artic = artic;
		this.listaVenta = listaVenta;
	}
	
	@XmlElement(name="artic")
	public Artic getArtic() {
		return artic;
	}
	public void setArtic(Artic artic) {
		this.artic = artic;
	}
	
	@XmlElementWrapper(name = "ventas")  
	@XmlElement(name = "venta")
	public ArrayList<Ventas> getListaVenta() {
		return listaVenta;
	}
	public void setListaVenta(ArrayList<Ventas> listaVenta) {
		this.listaVenta = listaVenta;
	}
	
	
}
