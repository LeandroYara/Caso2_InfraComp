package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	private static int[] marcosPagina;
	private static Hashtable<Integer, int[]> registroPaginas;
	private static boolean listaLlena = false;
	
	//Funcion de creacion del archivo
	
	public static void main(String[] args) throws IOException {

		Principal buffer;
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;

		while (!salir){

		    System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Salir");

			try {
				System.out.println("Escribe una de las opciones: ");
            	opcion = sn.nextInt();

				switch (opcion) {
                    case 1:

                        //Llamado a la funcion de creacion del archivo

                    case 2:
					

						Scanner scanConfiguracion = new Scanner(System.in);
						System.out.println("Escriba el nombre del archivo de referencias: ");
						String nombreArchivo = scanConfiguracion.nextLine();

						System.out.println("Escriba el numero de marcos de pagina: ");
						int numeroMarcos = scanConfiguracion.nextInt();

						try {
							Scanner archivoConfiguracion = new Scanner(new File("Caso2_InfraComp\\docs\\" + nombreArchivo));
							int numeroLinea = 1;

							while (archivoConfiguracion.hasNextLine()){
								String linea = archivoConfiguracion.nextLine();
								if (numeroLinea <= 7){
									System.out.println(linea);
									if (numeroLinea == 6){
										
									}
								}
								else {

								}
							}

						} catch (FileNotFoundException e){

							System.out.println("No se encontró el archivo");

						}

						System.out.println();

						AlgoritmoEnvejecimiento analizador = new AlgoritmoEnvejecimiento();
						Registro manejador = new Registro();
			
						analizador.start();
						manejador.start();

                    case 3:

                        salir = true;

                    default:
                        System.out.println("Solo números entre 1 y 3");
				}

			} catch (InputMismatchException e) {

				System.out.println("Debes insertar un número");
                sn.next();

			}
            
            
		}
		

		
		
	}

}
