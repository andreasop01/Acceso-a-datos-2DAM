package ventasArticulos2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Principal {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		JAXBContext context = JAXBContext.newInstance(VentasArticulos.class);
		Unmarshaller unmars = context.createUnmarshaller();
		VentasArticulos objeto = (VentasArticulos) unmars.unmarshal(new FileReader("./ventasarticulosdos.xml"));
		
		
		
		ArrayList<Articulo> lista = objeto.getListaArticulo();
		System.out.println("Numero de articulos: "+lista.size());
		
		
		for (Articulo arti : lista) {
		   
			Artic art=arti.getArtic();
			System.out.println("Codigo: "+art.getCodigo()+"\tNombre: "+art.getDenominacion()+"\tPrecio: "+art.getPrecio());
			System.out.printf("%9s %-11s %-11s %8s %7s%n","NUM VENTA","FECHA ALTA","NOM-CLIENTE","UNIDADES","IMPORTE");
			System.out.printf("%9s %-11s %-11s %8s %7s%n","---------","----------","-----------","--------","-------");
			
			ArrayList<Ventas> listaVenta=arti.getListaVenta();
			
			float importeT=0;
			int unidadesT=0;
			for(Ventas v:listaVenta) {
				float importe=v.getUnidades()*art.getPrecio();
				unidadesT+=v.getUnidades();
				System.out.printf("%9s %11s %11s %8s %7s%n",v.getNumventa(),v.getFecha(),v.getNombrecliente(),v.getUnidades(),importe);
				
				importeT+=importe;
			}
			
			System.out.printf("%9s %-11s %-11s %8s %7s%n","---------","----------","-----------","--------","-------");
			System.out.printf("%9s %-11s %-11s %8s %7s%n","TOTALES","","",unidadesT,importeT);
			
			
		
			
			
		}

	}

}