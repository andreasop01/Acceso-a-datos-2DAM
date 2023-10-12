package TipoExamen;

public class Notas {

	private int codAlumno;
	private String nombreAsignatura;
	private float notaAsignatura;
	
	
	public Notas() {}
	
	
	
	public Notas(int codAlumno, String nombreAsignatura, float notaAsignatura) {
		super();
		this.codAlumno = codAlumno;
		this.nombreAsignatura = nombreAsignatura;
		this.notaAsignatura = notaAsignatura;
	}
	
	public int getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	public float getNotaAsignatura() {
		return notaAsignatura;
	}
	public void setNotaAsignatura(float notaAsignatura) {
		this.notaAsignatura = notaAsignatura;
	}
	
	
	
	
}
