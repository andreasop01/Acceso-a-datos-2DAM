package nuevosDep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"no", "nombre", "localidad"})
public class departamento {
	
	private int no;
	private String nombre;
	private String localidad;
	
	public departamento() {}
	
	public departamento(int no, String nombre, String localidad) {
		super();
		this.no = no;
		this.nombre = nombre;
		this.localidad = localidad;
	}
	 @XmlElement(name = "deptno")
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	 @XmlElement(name = "dnombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 @XmlElement(name = "localidad")
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
}
