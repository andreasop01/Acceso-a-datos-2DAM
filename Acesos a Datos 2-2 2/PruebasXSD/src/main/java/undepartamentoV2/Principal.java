package undepartamentoV2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Ventas_articulos.DatosArtic;
import Ventas_articulos.ObjectFactory;
import Ventas_articulos.Ventas;
import Ventas_articulos.VentasType;

public class Principal {
	private static final  String XML_FILE="./undeparvariosemples.xml";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leerXml();
		
	}

	private static void leerXml() {
		// TODO Auto-generated method stub
		try {
			 JAXBContext jaxbContext =     
			          JAXBContext.newInstance(ObjectFactory.class);


			 	Unmarshaller u = jaxbContext.createUnmarshaller();	


				JAXBElement jaxbElement = (JAXBElement) u.unmarshal
			             (new FileInputStream(XML_FILE));


				Marshaller m = jaxbContext.createMarshaller();


				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


				// Visualiza por consola
				m.marshal(jaxbElement, System.out);
			      
			      //Cargamos ahora el documento en los tipos
				DatosempledepartType misdatos=(DatosempledepartType)jaxbElement.getValue();
				
				Departamento depart=misdatos.getDepartamento();
				Empleados empleados=misdatos.getEmpleados();


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

			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
