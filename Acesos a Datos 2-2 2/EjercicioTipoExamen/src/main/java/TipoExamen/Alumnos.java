package TipoExamen;

import java.util.ArrayList;

public class Alumnos {
	
	private int codAlumno;
	private String nombre;
	private String localidad;
	private int numAsignaturas;
	private float notaMedia;
	private ArrayList<Notas> listaNota;
	
	
	
	public Alumnos() {}
	
	public Alumnos(int codAlumno, String nombre, String localidad, int numAsignaturas, float notaMedia,
			ArrayList<Notas> listaNota) {
		super();
		this.codAlumno = codAlumno;
		this.nombre = nombre;
		this.localidad = localidad;
		this.numAsignaturas = numAsignaturas;
		this.notaMedia = notaMedia;
		this.listaNota = listaNota;
	}
	public ArrayList<Notas> getListaNota() {
		return listaNota;
	}
	public void setListaNota(ArrayList<Notas> listaNota) {
		this.listaNota = listaNota;
	}
	public int getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getNumAsignaturas() {
		return numAsignaturas;
	}
	public void setNumAsignaturas(int numAsignaturas) {
		this.numAsignaturas = numAsignaturas;
	}
	public float getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(float notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	

}
