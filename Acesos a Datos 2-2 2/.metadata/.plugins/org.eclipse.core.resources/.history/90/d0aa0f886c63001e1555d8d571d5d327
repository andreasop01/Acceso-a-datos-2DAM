package examenCursoPasado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ficheroProducto=new File("./Productos.dat");
		RandomAccessFile fileProducto;
		File ficheroDatosVentas=new File("./DatosdeVentas");
		RandomAccessFile fileDatosVentas;
		
		try {
			fileProducto=new RandomAccessFile(ficheroProducto,"rw");
			fileDatosVentas=new RandomAccessFile(ficheroDatosVentas,"rw");
			
			Scanner sn = new Scanner(System.in);
		       boolean salir = false;
		       int opcion; //Guardaremos la opcion del usuario
		        
		       while(!salir){
		            
		           System.out.println("1. Listar Producto");
		           System.out.println("2. Listar Datos Ventas");
		           System.out.println("3. Actualizar el fichero Producto");
		           System.out.println("4. Salir");
		            
		           System.out.println("Escribe una de las opciones");
		           opcion = sn.nextInt();
		            
		           switch(opcion){
		               case 1:
		                   System.out.println("Has seleccionado la opcion 1");
		                   leerProductos(fileProducto);
		                   
		                   break;
		               case 2:
		                   System.out.println("Has seleccionado la opcion 2");
		                   
		                   break;
		                case 3:
		                   System.out.println("Has seleccionado la opcion 3");
		                   
		                   break;
		               
		                case 4:
		                   salir=true;
		                   break;
		                default:
		                   System.out.println("Solo números entre 1 y 4");
		           }
		            
		       }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

	private static void leerProductos(RandomAccessFile fileProducto) {
		// TODO Auto-generated method stub
		
		int posiProducto=0;
		
		System.out.printf("%6s %-15s %11s %7s%n","CODIGO", "NOMBRE", "EXISTENCIAS", "PVP");
		System.out.printf("%6s %-15s %11s %7s%n","------", "---------------", "-----------", "-------");
		
		try {
			while(posiProducto<fileProducto.length()) {
				fileProducto.seek(posiProducto);
				int codigoProducto=fileProducto.readInt();
				
				if(codigoProducto!=0) {
					String nombreP="";
					for(int i =0; i<15;i++) {
						nombreP+=fileProducto.readChar();
					}
					int existencia=fileProducto.readInt();
					double pvp=fileProducto.readDouble();
					
					System.out.printf("%5s %-15s %11s %7s%n",codigoProducto,nombreP.trim(),existencia,pvp);
				}
				
				posiProducto+=46;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
