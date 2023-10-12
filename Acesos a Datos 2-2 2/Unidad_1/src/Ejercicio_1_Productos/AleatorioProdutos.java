package Ejercicio_1_Productos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AleatorioProdutos {
	
	static int log=46;

	public static void main(String[] args) {
		 Scanner teclado=new Scanner(System.in);
		File fichero=new File(".\\Productos.dat");
		RandomAccessFile producto;
		File fichero2=new File(".\\DatosdeVentas.dat");
		RandomAccessFile ventas;
		try {
			producto = new RandomAccessFile(fichero,"rw");
			ventas = new RandomAccessFile(fichero2,"rw");
			 int op1=0;
			 
			 System.out.println("OPCIONES CON PRODUTOS");
			 
			 do {
				 System.out.println("1.Ejercicio 1. Listar productos");
				 System.out.println("2.Ejercicio 2. Listar datos ventas");
				 System.out.println("3.Ejercicio 3. Actualizar existencias");
				 System.out.println("4.Salir");
				 
				 op1=Integer.parseInt(teclado.next());
				 
				 switch (op1) {
				 
				 case 1:
					 listarProductos(producto);
					 
				 case 2:
					 listarVentas(ventas);
				 case 3:
					 actualizarExistencias(ventas,producto);
				 }
				 
				 
			 } while(true);
			 

		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	private static void actualizarExistencias(RandomAccessFile ventas, RandomAccessFile producto) {
		// TODO Auto-generated method stub
		int posiV=0;
		int posiP=0;
		for(;;) {
			
			try {
				ventas.seek(posiV);
				int codi=ventas.readInt();
				int unidades=ventas.readInt();
				posiP=(codi-1)*log;
				
				if(posiP>=producto.length()) {
					System.out.println("No existe");
					posiV+=28; //28 es log de ventas
					if(posiV>=ventas.length()) {
						break;
					}
					
					continue;
				}
			
				producto.seek(posiP);
				int codiP=producto.readInt();
				
				if(codi!=codiP) {
					System.out.println("No existe");
					posiV+=28; //28 es log de ventas
					
					if(posiV>=ventas.length()) {
						break;
					}
					
					continue;
				}
				
				producto.skipBytes(30);
				int existencias=producto.readInt();
				
				existencias-=unidades;
				producto.skipBytes(-4);
				producto.writeInt(existencias);
				posiV+=28; //28 es log de ventas
				
				if(posiV>=ventas.length()) {
					break;
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


	private static void listarVentas(RandomAccessFile file) {
		// TODO Auto-generated method stub
		long posi=0;
		
		System.out.printf("%6s %7s %10s %n","CODIGO","UNI VEN","FECHA");
		System.out.printf("%6s %7s %10s %n","------","-------","----------");
		
		for(;;) {
			
			try {
				file.seek(posi);
				int codigo=file.readInt();
				
				if(codigo==0) {
					posi+=log;
					continue; //no se sale del blucle ni continua si no que vuelve al principio
				}
				int unidades=file.readInt();
				String fecha="";
				
				for(int i=0;i<10;i++) {
					fecha=fecha+file.readChar();	
					}

				System.out.printf("%6s %7s %10s %n",codigo,unidades,fecha);
				posi=posi+28;
				
				//salta al siguiente registro
				if(posi>=file.length()) {
					break;
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}


	private static void listarProductos(RandomAccessFile file) {
		// TODO Auto-generated method stub
		
		long posi=0;
		
		System.out.printf("%6s %15s %11s %8s %n","CODIGO","NOMBRE","EXISTENCIAS","PVP");
		System.out.printf("%6s %15s %11s %8s %n","------","---------------","-----------","--------");
		
		
		for(;;) {
			
			try {
				
				file.seek(posi);
				int codi=file.readInt();
				
				//salta los espacios en blanco
				if(codi==0) {
					posi+=log;
					continue; //no se sale del blucle ni continua si no que vuelve al principio
				}
				
				String nombre="";
				for(int i=0;i<15;i++) {
					
					nombre=nombre+file.readChar();
				}
				int existencias=file.readInt();
				double pvp=file.readDouble();		
				
				System.out.printf("%6s %15s %11s %8s %n",codi,nombre,existencias,pvp);
				
				posi=posi+log;
				
				//salta al siguiente registro
				if(posi>=file.length()) {
					break;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
