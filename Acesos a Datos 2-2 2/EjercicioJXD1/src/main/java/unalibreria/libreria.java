package unalibreria;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="milibreria")
public class libreria {
	private ArrayList<libro> listaLibro;
	private String nombre;
	private String lugar;
	
	public libreria() {}
	
	public libreria(ArrayList<libro> listaLibro, String nombre, String lugar) {
		super();
		this.listaLibro = listaLibro;
		this.nombre = nombre;
		this.lugar = lugar;
	}
	
	 //Wrapper, envoltura alrededor la representación XML
    @XmlElementWrapper(name = "ListaLibro")  
    @XmlElement(name = "Libro")
    public ArrayList<libro> getListaLibro() {
		return listaLibro;
	}
	public void setListaLibro(ArrayList<libro> listaLibro) {
		this.listaLibro = listaLibro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
