package unalibreria;
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
	private static void leerXml() {
		// TODO Auto-generated method stub
		try {
			JAXBContext context = JAXBContext.newInstance(libreria.class);
			Unmarshaller unmars = context.createUnmarshaller();
			//una clase es la clase raiz 
			try {
				libreria objeto = (libreria) unmars.unmarshal(new FileReader(MIARCHIVO_XML));
				System.out.println(objeto.getNombre());
				System.out.println(objeto.getLugar());
				ArrayList<libro> lista = objeto.getListaLibro();
				for (libro obarray : lista) {
				    System.out.println("Atributo array: " + obarray.getNombre());
				    System.out.println("Atributo array: " + obarray.getAutor());
				    System.out.println("Atributo array: " + obarray.getEditorial());
				    System.out.println("Atributo array: " + obarray.getIsbn());
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void crearXml() {
		// TODO Auto-generated method stub
		//Se crea la lista de libros
        ArrayList<libro> libroLista = new ArrayList<libro>();
        // Creamos dos libros y los añadimos
        libro libro1 = new libro("Entornos de Desarrollo", 
                 "Alicia Ramos","Garceta","978-84-1545-297-3" );
        libroLista.add(libro1);
        libro libro2 = new libro("Acceso a Datos","Maria Jesús Ramos",
                 "Garceta","978-84-1545-228-7" );
        libroLista.add(libro2);
 
        // Se crea La libreria y se le asigna la lista de libros
        libreria milibreria = new libreria();
        milibreria.setNombre("Prueba de libreria JAXB");
        milibreria.setLugar("Talavera, como no");
        milibreria.setListaLibro(libroLista);
 
        // Creamos el contexto indicando la clase raíz
        JAXBContext context;
		try {
			context = JAXBContext.newInstance(libreria.class);
			 //Creamos el Marshaller, convierte el java bean en una cadena XML
	        Marshaller m = context.createMarshaller();
	       //Formateamos el xml para que quede bien
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        // Lo visualizamos con system out
	        m.marshal(milibreria, System.out);
	         // Escribimos en el archivo
	        m.marshal(milibreria, new File(MIARCHIVO_XML));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
}
