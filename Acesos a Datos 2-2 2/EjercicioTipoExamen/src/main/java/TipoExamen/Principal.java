package TipoExamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fichero=new File("./Alumnos.dat");
		RandomAccessFile fileAlumno;
		
		File ficheroNota=new File("./Notas.dat");
		RandomAccessFile fileNotas;
		
		
		try {
			fileAlumno = new RandomAccessFile(fichero,"rw");
			fileNotas=new RandomAccessFile(ficheroNota,"rw");
			
			Scanner sn = new Scanner(System.in);
		       boolean salir = false;
		       int opcion; //Guardaremos la opcion del usuario
		        
		       while(!salir){
		            
		           System.out.println("1. Listar alumnos");
		           System.out.println("2. Listar notas");
		           System.out.println("3. Actualizar el fichero Alumno");
		           System.out.println("4. Generar el fichero ALumnos.xml");
		           System.out.println("5. Salir");
		            
		           System.out.println("Escribe una de las opciones");
		           opcion = sn.nextInt();
		            
		           switch(opcion){
		               case 1:
		                   System.out.println("Has seleccionado la opcion 1");
		                   leerAlumnos(fileAlumno);
		                   break;
		               case 2:
		                   System.out.println("Has seleccionado la opcion 2");
		                   leerNotas(fileNotas);
		                   break;
		                case 3:
		                   System.out.println("Has seleccionado la opcion 3");
		                   actualizarAlumnos(fileAlumno,fileNotas);
		                   break;
		                case 4:
			                   System.out.println("Has seleccionado la opcion 3");
			                   
			                   break;
		                case 5:
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


	private static void actualizarAlumnos(RandomAccessFile fileAlumno, RandomAccessFile fileNotas) throws IOException {
		// TODO Auto-generated method stub
		
		int codAlumno,numAlumno;
		float nota;
		
		
		int posi=0;
		int posi2=0;
		float notaMediaMax=0;
		String nombreNotaMax="";
		float notaMediaTotal=0;
		int numeroAlumnos=0;
		
		for(;;) {
			int asignaturas=0;
			float notaMedia=0;
			posi2=0;
			
			try {
				fileAlumno.seek(posi);
				codAlumno=fileAlumno.readInt();
				String nombre="";
				
				if(codAlumno!=0) {
					for(;;) {
						
						fileNotas.seek(posi2);
						numAlumno=fileNotas.readInt();
						fileNotas.skipBytes(40);
						if(codAlumno==numAlumno) {
							nota=fileNotas.readFloat();
							notaMedia+=nota;
							asignaturas++;	
						}
						posi2+=48;
						
						if (posi2>=fileNotas.length())break;
					}
					
					for(int i=0;i<20;i++) {
						nombre+=fileAlumno.readChar();
					}
					fileAlumno.skipBytes(40);
					fileAlumno.writeInt(asignaturas);
					notaMedia/=asignaturas;
					fileAlumno.writeFloat(notaMedia);
					posi+=92;
					
					if(notaMedia>notaMediaMax) {
						
						notaMediaMax=notaMedia;
						
						nombreNotaMax=nombre;
						
					}
					
					notaMediaTotal+=notaMedia;
					
					numeroAlumnos++;
					
					
					
					if (posi>=fileAlumno.length())break;
				}else {
					
					posi+=92;	
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}
		
		notaMediaTotal=notaMediaTotal/numeroAlumnos;
		
		leerAlumnos(fileAlumno);
		
		System.out.println("Alumno con nota media Maxima: "+nombreNotaMax);
		System.out.println("Media de nota Total: "+notaMediaTotal);
		
		
	}


	private static void leerNotas(RandomAccessFile fileNotas) throws IOException {
		// TODO Auto-generated method stub
		
		int codAlum;
		float notaAsig;
		int cont=1;
		
		System.out.printf("%5s %7s %20s %5s%n","REGIS","NUMALUM","ASIGNATURA","NOTA");
		System.out.printf("%5s %7s %20s %5s%n","-----","-------","--------------------","-----");
		
		for(;;) {
			
			codAlum=fileNotas.readInt();
			String asignatura="";
			for( int i=0;i<20;i++) {
				asignatura+=fileNotas.readChar();
			}
			notaAsig=fileNotas.readFloat();
			
			
			
			System.out.printf("%5s %7s %20s %5s%n",cont,codAlum,asignatura.trim(),notaAsig);
			
			cont++;
			
			if (fileNotas.getFilePointer()==fileNotas.length())break;
			
		}
		
		fileNotas.close();
		
	}

	private static void leerAlumnos(RandomAccessFile fileAlumnos) throws IOException {
		// TODO Auto-generated method stub
		int codAlum,numAsig,posi;
		float notaMedia;
		
		
		posi=0;
		
		System.out.printf("%7s %-20s %-20s %7s %9s%n", "NUMALUM", "NOMBRE", "LOCALIDAD", "NUMASIG", "NOTAMEDIA");
		System.out.printf("%7s %-20s %-20s %7s %9s%n", "-------", "--------------------", "--------------------", "-------", "---------");
		
		for(;;) {
			String nombre="";
			String localidad="";
			fileAlumnos.seek(posi);
			codAlum=fileAlumnos.readInt();
			
			for(int i=0;i<20;i++) {
				nombre+=fileAlumnos.readChar();
				
			}
			for(int i=0;i<20;i++) {
				localidad+=fileAlumnos.readChar();
			}
			numAsig=fileAlumnos.readInt();
			notaMedia=fileAlumnos.readFloat();
			
			System.out.printf("%7s %-20s %-20s %7s %9s%n", codAlum, nombre.trim(), localidad.trim(), numAsig, notaMedia);
			
			posi=posi+92;
			
			if (fileAlumnos.getFilePointer()==fileAlumnos.length())break;
			
		}
		
		 fileAlumnos.close();
		
	}


	

}
