package pruebasFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OperarAleatorio {

	public static void main(String[] args) {

		File fichero = new File(".\\AleatorioEmple.dat");
		// declara el fichero de acceso aleatorio
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");

			// consultar(file, 5);
			// consultar(file, 15);
			// id apellido dep salario
			// insertarempleado(file, 15, "Emple15", 10, 2000d);

			// insertarempleado(file, 3, "Emple3", 10, 2000d);

			// insertarempleado(file, 11, "Emple11", 110, 2000d);

			// id nombre salario
			actualizarnombresalario(file, 11, "Nuevo11", 2100d);

			actualizarnombresalario(file, 30, "Nuevo11", 2100d);

			// actualizar salario de los empleados del dep 10, se sube la subida
			// dep subida
			//actualizarsalariodep(file, 10, 130d);

			// id
			borrarempleado(file, 15);
			borrarempleado(file, 1);
			
			borrarempleado(file, 8);
			
			file.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

	}

	private static void borrarempleado(RandomAccessFile file, int id) {
	
		long posi = (id - 1) * 36; // posic del reg
		// preguntamos
		try {
			if (posi > file.length()) {
				System.out.println("ID: " + id + ", NO EXISTE EMPLEADO. NO SE BORRA");
			}
			else {
				file.seek(posi);// nos posicionamos
				int ident = file.readInt();
				if (ident == id) {
					// si existe, se borra
					file.seek(posi);
					file.writeInt(0); // id a 0
					StringBuffer buffer = new StringBuffer("");
					buffer.setLength(10);
					file.writeChars(buffer.toString());
					file.writeInt(0); 
					file.writeDouble(0d);
					System.out.println("ID: " + id + ", EMPLEADO BORRADO");
				} else {
					System.out.println("ID: " + id + ", EMPLEADO NO EXISTE. NO BORRA");
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void actualizarsalariodep(RandomAccessFile file, 
			int dep, double subida) {

		long posicion = 0; // para situarnos al principio
		try {
			int con=0;
			for (;;) { // recorro el fichero

				file.seek(posicion);
				// nos posicionamos en posicion
				int id = file.readInt(); // obtengo id de empleado
				String apellido = "";
				for (int i = 0; i < 10; i++) {
					apellido = apellido + file.readChar();// recorro uno a uno los caracteres del apellid
				}
				int dd = file.readInt();// obtengo dep
				if (dd==dep) {
					// actualizar
					long punt = file.getFilePointer();
					double salario = file.readDouble();
					double nuevo = salario + subida;
					// grabar nuevo
					file.seek(punt);
					file.writeDouble(nuevo);
					System.out.println("ID: " + id + ", Actualizado el salario "+nuevo);
					con=con+1;
				}
				posicion=posicion + 36;
				
				if ( posicion>=file.length() )
					break;

			}
			System.out.println("Actualizados "+con+ " empleados.");
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void actualizarnombresalario(RandomAccessFile file, int id, String apellido, double salario) {
		// actualizar ape y salario
		long posi = (id - 1) * 36; // posic del reg

		// preguntamos
		try {
			if (posi > file.length()) {
				System.out.println("ID: " + id + ", NO EXISTE EMPLEADO");
			}

			else {

				file.seek(posi);// nos posicionamos
				int ident = file.readInt();
				if (ident == id) {
					// si existe, actualizo
					// Actualizao el nombre
					StringBuffer buffer = new StringBuffer(apellido);
					buffer.setLength(10);
					file.writeChars(buffer.toString());
					// leo el dep y grabo salario
					// o salto el dep para posicionarme en el salario
					int dep = file.readInt();
					// actualizo salario
					file.writeDouble(salario);// actualizo salario
					System.out.println("ID: " + id + ", EMPLEADO ACTUALIZADO");
				} else {
					System.out.println("ID: " + id + ", EMPLEADO NO EXISTE. NO ACTUALIZADO");
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void insertarempleado(RandomAccessFile file, int id, String apellido, int dep, double salario) {
		// TODO Auto-generated method stub
		long posi = (id - 1) * 36; // posic del reg

		// preguntamos
		try {
			if (posi > file.length()) {
				// Nuevo reg al final
				file.seek(posi);
				System.out.println("ID: " + id + ", NO EXISTE EMPLEADO, se añade al final ...");
				file.writeInt(id); // uso i+1 para identificar empleado
				StringBuffer buffer = new StringBuffer(apellido);
				buffer.setLength(10); // 10 caracteres para el apellido
				file.writeChars(buffer.toString());// insertar apellido
				file.writeInt(dep); // insertar departamento
				file.writeDouble(salario);// insertar salario

			}

			else {
				// dentro del fichero, puede ser un reg que existe
				// o puede ser uno nuevo en un hueco
				// nos posicionamos
				file.seek(posi);// nos posicionamos
				int ident = file.readInt(); // leo para ver si es hueco
				if (ident == 0) {
					// es hueco
					// se inserta el nuevo
					System.out.println("ID: " + id + ", NO EXISTE EMPLEADO, HUECO, SE INSERTA");
					file.seek(posi);
					file.writeInt(id); // uso i+1 para identificar empleado
					StringBuffer buffer = new StringBuffer(apellido);
					buffer.setLength(10); // 10 caracteres para el apellido
					file.writeChars(buffer.toString());// insertar apellido
					file.writeInt(dep); // insertar departamento
					file.writeDouble(salario);// insertar salario

				} else {
					// está ocupado
					// Se borraría o se actualizaría
					System.out.println("ID: " + id + " " + ident + ", SI EXISTE EMPLEADO, ACTUALIZAR O BORRAR");
					System.out.println("Estos son los datos:");
					consultar(file, id);

				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void consultar(RandomAccessFile file, int id) {

		long posicion = (id - 1) * 36; // calculo donde empieza el registro
		try {
			if (posicion >= file.length())
				System.out.println("ID: " + id + ", NO EXISTE EMPLEADO...");
			else {
				file.seek(posicion);// nos posicionamos
				id = file.readInt(); // obtengo id de empleado
				String apellido = "";
				for (int i = 0; i < 10; i++) {
					apellido = apellido + file.readChar();// recorro uno a uno los caracteres del apellid
				}

				int dep = file.readInt();// obtengo dep
				double salario = file.readDouble(); // obtengo salario

				System.out.println(
						"ID: " + id + ", Apellido: " + apellido + ", Departamento: " + dep + ", Salario: " + salario);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // fin if

	}

}
