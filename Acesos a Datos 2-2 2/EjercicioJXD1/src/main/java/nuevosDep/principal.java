package nuevosDep;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class principal {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		JAXBContext context = JAXBContext.newInstance(departamentos.class);
		Unmarshaller unmars = context.createUnmarshaller();
		departamentos objeto = (departamentos) unmars.unmarshal(new FileReader("./NuevosDep.xml"));
		
		System.out.println(objeto);
		
		ArrayList<departamento> lista = objeto.getListaDepartaamentos();
		for (departamento obarray : lista) {
		    System.out.println("Atributo array: " + obarray.getNo());
		    System.out.println("Atributo array: " + obarray.getNombre());
		    System.out.println("Atributo array: " + obarray.getLocalidad());
		    
		}

	}

}
