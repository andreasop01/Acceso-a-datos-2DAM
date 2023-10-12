package ventasArticulos2;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ventasarticulos")
public class VentasArticulos {
	
	
	private ArrayList <Articulo> listaArticulo;

	@XmlElement(name="articulo")
	public ArrayList<Articulo> getListaArticulo() {
		return listaArticulo;
	}

	public void setListaArticulo(ArrayList<Articulo> listaArticulo) {
		this.listaArticulo = listaArticulo;
	}

	public VentasArticulos(ArrayList<Articulo> listaArticulo) {
		super();
		this.listaArticulo = listaArticulo;
	}
	
	public VentasArticulos() {}
	
}
