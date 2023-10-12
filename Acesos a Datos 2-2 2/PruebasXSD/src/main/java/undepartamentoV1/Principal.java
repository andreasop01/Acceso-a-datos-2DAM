package undepartamentoV1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Principal {
	private static final  String XML_FILE="./undeparvariosemples.xml";
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		leerXml();
		
	}


	private static void leerXml() throws FileNotFoundException {
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
				
				List<Empleados.Emple> listaEmpleados=empleados.getEmple();
				
				System.out.println("----------------------------------------------------");
				System.out.println("-------VISUALIZAR LOS OBJETOS-----------------------");
				System.out.println("----------------------------------------------------");
				System.out.println("CODIGO DEPAR:"+depart.getCodigodep());
				System.out.println("NOMBRE DEPAR:"+depart.getNombredep());
				System.out.println("LOCALIDAD DEPAR:"+depart.getLocalidad());
				System.out.println("PRESUPUESTO DEPAR:"+depart.getPresupuesto());
				
				for(int i=0;i<listaEmpleados.size();i++) {
					Empleados.Emple emp=(Empleados.Emple)listaEmpleados.get(i);
					System.out.println("Nombre:"+ emp.getEmpno()+"Apellido: "+ emp.getApellido()+"Oficio: "+ emp.getOficio()+"Salario: "+ emp.getSalario());
				}

			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}