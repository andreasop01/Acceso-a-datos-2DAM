package variasLibrerias;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="milibrerias")
public class Librerias {

	ArrayList<Libreria> listaLibrerias;
	
	@XmlElementWrapper(name = "")  
	@XmlElement(name = "librerias")
	public ArrayList<Libreria> getListaLibrerias() {
		return listaLibrerias;
	}

	public void setListaLibrerias(ArrayList<Libreria> listaLibrerias) {
		this.listaLibrerias = listaLibrerias;
	}

	public Librerias(ArrayList<Libreria> listaLibrerias) {
		super();
		this.listaLibrerias = listaLibrerias;
	}
	public Librerias() {
	}
	
	
	
}
