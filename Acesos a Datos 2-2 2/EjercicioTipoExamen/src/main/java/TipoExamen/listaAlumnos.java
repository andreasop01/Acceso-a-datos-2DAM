package TipoExamen;

import java.util.ArrayList;

public class listaAlumnos {
	private ArrayList<Alumnos> listaAlumno ;

	
	public listaAlumnos() {}
	
	public listaAlumnos(ArrayList<Alumnos> listaAlumno) {
		super();
		this.listaAlumno = listaAlumno;
	}

	public ArrayList<Alumnos> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(ArrayList<Alumnos> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}
	
	
	
}
