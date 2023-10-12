package Ejercicio_1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio_fichero1 {
	
	static int  LOG=72;

	public static void main(String[] args) {
		// crear el fichero
		
		File fichero=new File(".\\departamentos.dat");
		
		try {
			RandomAccessFile file=new RandomAccessFile(fichero,"rw"); //permite leer y escribir el fichero 
			
			
			//insertar registro 
			insertar(file,1,"Dep1","Talavera",0,1000.00f);
			insertar(file,2,"Dep2","Madrid",4,2000.00f);
			insertar(file,3,"Dep3","Toledo",6,3000.00f);
			insertar(file,4,"Dep4","Talavera",9,4000.00f);
			consultarRegistro(file,1);
			listasRegistro(file);
			visualizarRegistro(file,1); //existe
			visualizarRegistro(file,10);//no existe
			//dep,loc,media salrio
			System.out.println(modificarRegistro(file,1,"NuevaLoc1",1999.0f));;
			modificarRegistro(file,4,"NuevaLoc2",4444.0f);
			modificarRegistro(file,23,"NuevaLoc",1999.0f);
			
			borrarRegistro(file,1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static String borrarRegistro(RandomAccessFile file, int dep) throws IOException {
		// TODO Auto-generated method stub
		
		if(!consultarRegistro(file,dep)) {
			return "REGISTRO NO SE PUEDE BORRAR. NO EXISTE"+dep;
		}
		try {
			long posi=(dep-1)*LOG;
			file.seek(posi);
			file.writeInt(0);
			//nombre
			StringBuffer buffer=new StringBuffer("");
			buffer.setLength(15);
			file.writeChars(buffer.toString());
			//localidad
			buffer=new StringBuffer("");
			buffer.setLength(15);
			file.writeChars(buffer.toString());
			//numero empledo
			file.writeInt (0);
			//media de salario
			file.writeFloat(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR REGISTRO NO INSERTADO";
		}
		return null;
	}

	private static String modificarRegistro(RandomAccessFile file, int dep, String localidad, float media) throws IOException {
		
		if(!consultarRegistro(file,dep)) {
			
			return "REGISTRO NO PUEDE MODIFICAR , NO EXISTE"+dep;
			
		}
		
		long posi=(dep-1)*LOG;
		//cojo una posicion salto 4 del cod deo+30 del nombre
		//me coloc en localida
		try {
			file.seek(posi+34);//puntero en localidad
			
			StringBuffer buffer=new StringBuffer(localidad);
			buffer.setLength(15);
			file.writeChars(buffer.toString());
			//saltamos posi actual + 4
			file.seek(file.getFilePointer()+4); //nos colocamos en el salrio
			file.writeFloat(media);
			
			return "REGISTRO ACTUALIZADO: "+dep;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	private static void visualizarRegistro(RandomAccessFile file, int dep) throws IOException {
		// llamamos el metado
		
		if(consultarRegistro(file,dep)) {
			long posi=(dep-1)*LOG;
			file.seek(posi);
			

			try {

				int dep2=file.readInt();
				String nombre="";
				for(int i=1;i>=15;i++) {
					nombre=nombre+file.readChar();
						}
				String local="";
				for(int i=1;i>=15;i++) {
					local=local+file.readChar();
						}
				
				int numero=file.readInt();
				float salario=file.readFloat();
				
				System.out.println("Dep: "+dep+" Nombre: "+nombre+" Local: "+local+" Numero: "+numero+" Salario:"+salario);
								
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else {
			System.out.println();
		}
		
		
		
		
	}

	private static void listasRegistro(RandomAccessFile file) {
		// TODO Auto-generated method stub
		long posicion=0;
		
		for(;;) {
			
			
			try {

				file.seek(posicion);
				int dep=file.readInt();
				String nombre="";
				for(int i=0;i<15;i++) {
					nombre=nombre+file.readChar();
						}
				String local="";
				for(int i=0;i<15;i++) {
					local=local+file.readChar();
						}
				
				int numero=file.readInt();
				float salario=file.readFloat();
				
				System.out.println("Dep: "+dep+" Nombre: "+nombre+" Local: "+local+" Numero: "+numero+" Salario:"+salario);
								
				posicion=posicion+LOG;
				
				if(posicion>=file.length()) {
					
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	private static boolean consultarRegistro(RandomAccessFile file, int id) throws IOException {
		
		int posi=(id-1)*72;
		
		if(posi>=file.length()) {
			
			System.out.println("Registro no existe");
			return false;
		}
		
		file.seek(posi);
		int dep=file.readInt();
		
		if(dep==id) {
			return true;
		}
		
		return false;
	}

	private static String insertar(RandomAccessFile file, int dep, String nombre, String loc, int num, float media) {
		
		if(dep>=1 && dep<=100) {
			long posi=(dep-1)*72;
			//dep
			try {
				file.seek(posi);
				file.writeInt(dep);
				//nombre
				StringBuffer buffer=new StringBuffer(nombre);
				buffer.setLength(15);
				file.writeChars(buffer.toString());
				//localidad
				buffer=new StringBuffer(loc);
				buffer.setLength(15);
				file.writeChars(buffer.toString());
				//numero empledo
				file.writeInt(num);
				//media de salario
				file.writeFloat(media);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR REGISTRO NO INSERTADO";
			}
			
					
		}
		else {
			
			return "Numero de departamento no esta entre 1 y 100";
			
		}
		return "REGISTRO INSERTADO";
		
	}

}
