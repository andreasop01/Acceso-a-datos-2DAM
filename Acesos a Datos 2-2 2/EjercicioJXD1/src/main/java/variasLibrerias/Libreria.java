package variasLibrerias;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType()
public class Libreria {
	private ArrayList<Libro> listaLibro;
	private String nombre;
	private String lugar;
	
	public Libreria() {}
	
	public Libreria(ArrayList<Libro> listaLibro, String nombre, String lugar) {
		super();
		this.listaLibro = listaLibro;
		this.nombre = nombre;
		this.lugar = lugar;
	}
	
	 //Wrapper, envoltura alrededor la representación XML
    @XmlElementWrapper(name = "ListaLibro")  
    @XmlElement(name = "Libro")
    public ArrayList<Libro> getListaLibro() {
		return listaLibro;
	}
	public void setListaLibro(ArrayList<Libro> listaLibro) {
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
