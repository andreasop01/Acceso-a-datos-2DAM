package ventasArticulos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class principal {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		JAXBContext context = JAXBContext.newInstance(ventasArticulos.class);
		Unmarshaller unmars = context.createUnmarshaller();
		ventasArticulos objeto = (ventasArticulos) unmars.unmarshal(new FileReader("./ventasarticulos.xml"));
		articulos objeto2= objeto.getArticulo();
		System.out.println(objeto2.getDenominacion());
		System.out.println(objeto2.getStock());
		System.out.println(objeto2.getPrecio());
		
		
		ArrayList<venta> lista = objeto.getListaVenta();
		for (venta obarray : lista) {
		    System.out.println("Atributo array: " + obarray.getNumventa());
		    System.out.println("Atributo array: " + obarray.getUnidades());
		    System.out.println("Atributo array: " + obarray.getNombrecliente());
		    System.out.println("Atributo array: " + obarray.getFecha());
		    
		}

	}

}
