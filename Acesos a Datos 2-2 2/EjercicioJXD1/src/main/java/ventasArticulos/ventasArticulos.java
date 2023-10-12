package ventasArticulos;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ventasarticulos")
public class ventasArticulos {
	
	ArrayList<venta> listaVenta;
	private articulos articulo;

	@XmlElementWrapper(name = "ventas")  
	@XmlElement(name = "venta")
	
	
	public ArrayList<venta> getListaVenta() {
		return listaVenta;
	}

	public articulos getArticulo() {
		return articulo;
	}

	public void setArticulo(articulos articulo) {
		this.articulo = articulo;
	}

	public void setListaVenta(ArrayList<venta> listaVenta) {
		this.listaVenta = listaVenta;
	}

	public ventasArticulos(ArrayList<venta> listaVenta, articulos articulo) {
		super();
		this.listaVenta = listaVenta;
		this.articulo = articulo;
	}

	public ventasArticulos() {}
	
	

}
