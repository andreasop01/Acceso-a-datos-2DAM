package ventasArticulos;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"codigo", "denominacion", "stock","precio"})
public class articulos {
	
	private String codigo;
	private String denominacion;
	private int stock;
	private int precio;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public articulos(String codigo, String denominacion, int stock, int precio) {
		super();
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.stock = stock;
		this.precio = precio;
	}
	
	public articulos() {}
	
	
}
