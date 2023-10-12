package Ventas_articulos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Principal {

	
	private static final  String XML_FILE="./ventasarticulos.xml";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		leerXml();
		insertarventa(13 , "Nuevo cli", 2, "abril");

		}
	
	public static void crearnuevoventasxml() {
		  
		  // Creo el objeto DatosArtic y asigno valores
		  DatosArtic articulo = new DatosArtic();
		  articulo.setCodigo("Arti 1");
		  articulo.setDenominacion("Bicicleta Plegable");
		  BigInteger stv = BigInteger.valueOf(10);
		  BigDecimal pvv = BigDecimal.valueOf(200);
		  articulo.setPrecio(pvv);
		  articulo.setStock(stv);


		  // Creamos el objeto Ventas
		  Ventas ventas = new Ventas();
		  // Creo la primera venta y la añado a ventas
		  Ventas.Venta ven = new Ventas.Venta();
		  ven.setNombrecliente("Alicia Ramos");
		  ven.setNumventa(BigInteger.valueOf(1));
		  ven.setUnidades(2);
		  ven.setFecha("10-02-2016");
		  ventas.getVenta().add(ven);


		  // Creo la segunda venta y la añado a ventas
		  ven = new Ventas.Venta();
		  ven.setNombrecliente("Dori Martín");
		  ven.setNumventa(BigInteger.valueOf(2));
		  ven.setUnidades(1);
		  ven.setFecha("21-02-2016");
		  ventas.getVenta().add(ven);


		  // Creo un VentasType y asigno los datos del artículo y sus ventas
		  VentasType miventaarticulo = new VentasType();
		  miventaarticulo.setArticulo(articulo);
		  miventaarticulo.setVentas(ventas);


		  // Creo el ObjectFactory
		  ObjectFactory miarticulo = new ObjectFactory();
		  // Creo El JAXBElement lo obtenemos del ObjectFactory y del VentasType
		  JAXBElement<VentasType> element = 
		        miarticulo.createVentasarticulos(miventaarticulo);
		  // Creo el contexto y el Marshaller
		  JAXBContext jaxbContext;
		  try {
		 	jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Marshaller m = jaxbContext.createMarshaller();
		  	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, 
		            Boolean.TRUE);
			String fiche = "./nuevo_ventasarticulos.xml";
		   	m.marshal(element, new FileOutputStream(fiche));
			System.out.println("Venta creada. ");


			// Visualizamos por por consola
			 m.marshal(element, System.out);


			} catch (JAXBException e) {e.printStackTrace();	
		      } catch (FileNotFoundException e){	e.printStackTrace();}
		}

	
	private void borraVenta(int numeVenta) throws FileNotFoundException {
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
		    JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));
		    VentasType miventa = (VentasType) jaxbElement.getValue();
		    
		    
		    Ventas vent = miventa.getVentas();
		    List listaVentas = new ArrayList();
		    listaVentas = vent.getVenta();
		    boolean borrar=false;
		    int existe=0;
		    for(int i=0;i<listaVentas.size();i++) {
		    	 Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i);
		    	 
		    	 
		    	 if(numeVenta==ve.getNumventa().intValue()) {
		    		 
		    		 //borramos
		    		 listaVentas.remove(i);
		    		  Marshaller m = jaxbContext.createMarshaller();
					   m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, 
				       Boolean.TRUE); 
					   m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml")); 
					   
					

		    	} 
		    		
		    }
		    
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());}
		
	}
	
	
	private static void insertarventa(int numeventa, String nomcli, int uni, String fecha) {
	  
	  System.out.println("---------------------------- ");
	  System.out.println("-------AÑADIR VENTA--------- ");
	  System.out.println("---------------------------- ");
	  	
	  try {
	     JAXBContext jaxbContext =   
	             JAXBContext.newInstance(ObjectFactory.class);
		     Unmarshaller u = jaxbContext.createUnmarshaller();
		     JAXBElement jaxbElement = (JAXBElement) 
	     u.unmarshal(new FileInputStream("./ventasarticulos.xml"));


		     VentasType miventa = (VentasType) jaxbElement.getValue();


		     Ventas vent = miventa.getVentas();


		     List listaVentas = new ArrayList();
		     listaVentas = vent.getVenta();


		     // comprobar si existe el número de venta, 
	     // reccorriendo el arraylist
		     int existe = 0; 
		     for (int i = 0; i < listaVentas.size(); i++) {
			  Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i);
			  if (ve.getNumventa().intValue() == numeventa) {
				existe = 1;	break;}
		     }
		     if (existe == 0) {
		       // Crear el objeto Ventas.Venta
		       Ventas.Venta ve = new Ventas.Venta();
		       ve.setNombrecliente(nomcli);
		       ve.setFecha(fecha); ve.setUnidades(uni);
		       BigInteger nume = BigInteger.valueOf(numeventa);
		       ve.setNumventa(nume);
	       // Se añade la venta a la lista
	       listaVentas.add(ve);
	       //Se crea el Marshaller, volcar la lista al fichero XML
			   Marshaller m = jaxbContext.createMarshaller();
			   m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, 
		       Boolean.TRUE); 
		       m.marshal(jaxbElement, new 
		       FileOutputStream("./ventasarticulos.xml"));
		       System.out.println("Venta añadida: " + numeventa);
		   } else
		       System.out.println("En número de venta ya existe: " + 
	           numeventa);
	  } catch (JAXBException je) {
			System.out.println(je.getCause());
	  } catch (IOException ioe) {
			System.out.println(ioe.getMessage());}


	}

	
	
	
	private static void leerXml() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------ ");
		  System.out.println("-------VISUALIZAR XML--------- ");
		  System.out.println("------------------------------ ");
		  try {
		      //Creamos el contexto
		      JAXBContext jaxbContext =     
		          JAXBContext.newInstance(ObjectFactory.class);


		 	Unmarshaller u = jaxbContext.createUnmarshaller();	


			JAXBElement jaxbElement = (JAXBElement) u.unmarshal
		             (new FileInputStream("./ventasarticulos.xml"));


			Marshaller m = jaxbContext.createMarshaller();


			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


			// Visualiza por consola
			m.marshal(jaxbElement, System.out);
		      
		      //Cargamos ahora el documento en los tipos
			VentasType miventa = (VentasType) jaxbElement.getValue();


			//Obtenemos una instancia para obtener todas las ventas
		      Ventas vent = miventa.getVentas();


			 // Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();


			System.out.println("---------------------------- ");
			System.out.println("---VISUALIZAR LOS OBJETOS--- ");
			System.out.println("---------------------------- ");
			// Cargamos los datos del artículo
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();
			System.out.println("Nombre art: " + 
		               miartic.getDenominacion());
			System.out.println("Coodigo art: " + miartic.getCodigo());
			System.out.println("Ventas  del artículo , hay: " + 
		          listaVentas.size());
		      //Visualizamos las ventas del artículo
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i);
				System.out.println("Número de venta: " +
				   ve.getNumventa() + ". Nombre cliente: " + 
				   ve.getNombrecliente() + ", unidades: " + 
				   ve.getUnidades() + ", fecha: " + ve.getFecha());
			      }
		   } catch (JAXBException je) {
					System.out.println(je.getCause());
		   } catch (IOException ioe) {
					System.out.println(ioe.getMessage());}

	}

	
}
