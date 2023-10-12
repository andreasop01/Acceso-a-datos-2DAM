package nuevosDep;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Nuevosdepartamentos")
public class departamentos {
	ArrayList<departamento> listaDepartaamentos;
	

	@Override
	public String toString() {
		return "departamentos [listaDepartaamentos";
	}
	@XmlElement(name="departamento")
	public ArrayList<departamento> getListaDepartaamentos() {
		return listaDepartaamentos;
	}

	public void setListaDepartaamentos(ArrayList<departamento> listaDepartaamentos) {
		this.listaDepartaamentos = listaDepartaamentos;
	}

	public departamentos(ArrayList<departamento> listaDepartaamentos) {
		super();
		this.listaDepartaamentos = listaDepartaamentos;
	}
	
	public departamentos() {}
	
}
