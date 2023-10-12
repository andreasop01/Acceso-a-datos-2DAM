package variasLibrerias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 
public class Principal {
    private static final String MIARCHIVO_XML = "./libreria.xml";
    public static void main(String[] args) 
       throws JAXBException, IOException {
       
    	crearXml();
    	leerXml();
  }
	private static void leerXml() throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		JAXBContext context = JAXBContext.newInstance(Librerias.class);
		Unmarshaller unmars = context.createUnmarshaller();
		Librerias objeto = (Librerias) unmars.unmarshal(new FileReader( MIARCHIVO_XML));
		ArrayList<Libreria> lista = objeto.getListaLibrerias();
		for (Libreria obarray : lista) {
		    System.out.println("Atributo array: " + obarray.getNombre());
		    System.out.println("Atributo array: " + obarray.getLugar());
		    
		    ArrayList<Libro> lista2=obarray.getListaLibro();
		    for (Libro obarray2 : lista2) {
			    System.out.println("Atributo array: " + obarray2.getAutor());
			    System.out.println("Atributo array: " + obarray2.getEditorial());
			    System.out.println("Atributo array: " + obarray2.getIsbn());
			    System.out.println("Atributo array: " + obarray2.getNombre());
		    
		    }
		
		}
		
	}
	private static void crearXml() throws JAXBException {
		// TODO Auto-generated method stub
		
		 //Se crea la lista de libros
        ArrayList<Libro> libroLista = new ArrayList<Libro>();
        ArrayList<Libreria> libreriaLista= new ArrayList<Libreria>();
        
        
        
        // Creamos dos libros y los añadimos
        Libro libro1 = new Libro("Entornos de Desarrollo", 
                 "Alicia Ramos","Garceta","978-84-1545-297-3" );
        libroLista.add(libro1);
        Libro libro2 = new Libro("Acceso a Datos","Maria Jesús Ramos",
                 "Garceta","978-84-1545-228-7" );
        libroLista.add(libro2);
 
        // Se crea La libreria y se le asigna la lista de libros
        Libreria milibreria = new  Libreria();
        
        milibreria.setNombre("Prueba de libreria JAXB");
        milibreria.setLugar("Talavera, como no");
        milibreria.setListaLibro(libroLista);
        libreriaLista.add(milibreria);
        
        Libreria milibreria2=new Libreria();
        
        milibreria2.setNombre("Prueba de libreria xml");
        milibreria2.setLugar("Madrid, como no");
        milibreria2.setListaLibro(libroLista);
        libreriaLista.add(milibreria2);
        
        Librerias misLibrerias=new Librerias();
        misLibrerias.setListaLibrerias(libreriaLista);
        
        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance( Librerias.class);
        //Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller m = context.createMarshaller();
       //Formateamos el xml para que quede bien
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // Lo visualizamos con system out
        m.marshal(misLibrerias, System.out);
         // Escribimos en el archivo
        m.marshal(misLibrerias, new File(MIARCHIVO_XML));
		
	}
}
