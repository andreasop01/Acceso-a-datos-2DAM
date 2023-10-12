package ventasArticulos2;

public class Ventas {
	
	private int numventa;
	private int unidades;
	private String nombrecliente;
	private String fecha;
	public int getNumventa() {
		return numventa;
	}
	public void setNumventa(int numventa) {
		this.numventa = numventa;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Ventas(int numventa, int unidades, String nombrecliente, String fecha) {
		super();
		this.numventa = numventa;
		this.unidades = unidades;
		this.nombrecliente = nombrecliente;
		this.fecha = fecha;
	}
	
	public Ventas(){}
	
	
}
