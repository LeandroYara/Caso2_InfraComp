package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	private int numeroMarcos;
	private Hashtable<Integer, String> marcoPaginas;
	private Hashtable<Integer, Integer> registroPaginas;
	private ArrayList<Integer> registroTemporal;
	private boolean listaMarcosLlena = false;

	public int getNumeroMarcos() {
		return this.numeroMarcos;
	}

	public void setNumeroMarcos(int numeroMarcos) {
		this.numeroMarcos = numeroMarcos;
	}

	public Hashtable<Integer,String> getMarcoPaginas()
	{
		return this.marcoPaginas;
	}

	public void setMarcoPaginas(Hashtable<Integer,String> nuevoMarco)
	{
		this.marcoPaginas = nuevoMarco;
	}

	public Hashtable<Integer, Integer> getRegistroPaginas()
	{
		return this.registroPaginas;
	}

	public void setRegistroPaginas(Hashtable<Integer,Integer> nuevoRegistro)
	{
		this.registroPaginas = nuevoRegistro;
	}

	public ArrayList<Integer> getRegistroTemporal() {
		return this.registroTemporal;
	}

	public void setRegistroTemporal(ArrayList<Integer> registroTemporal) {
		this.registroTemporal = registroTemporal;
	}

	public boolean isListaMarcosLlena() {
		return this.listaMarcosLlena;
	}

	public void setListaMarcosLlena(boolean listaLlena) {
		this.listaMarcosLlena = listaLlena;
	}

	public Principal() {
		this.numeroMarcos = 0;
		this.marcoPaginas = new Hashtable<Integer, String>();
		this.registroPaginas = new Hashtable<Integer, Integer>();
		this.registroTemporal = new ArrayList<Integer>();
		this.listaMarcosLlena = false;
	}
	
	//Funcion de creacion del archivo
	
	public static void main(String[] args) throws IOException {

		Principal buffer = new Principal();
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
						buffer.numeroMarcos = scanConfiguracion.nextInt();

						int numeroPaginas = 0;

						try {
							Scanner archivoConfiguracion = new Scanner(new File("Caso2_InfraComp\\docs\\" + nombreArchivo));
							int numeroLinea = 1;

							while (archivoConfiguracion.hasNextLine()){
								String linea = archivoConfiguracion.nextLine();
								char[] cadenaSeparada = linea.toCharArray();
								if (numeroLinea <= 7){
									System.out.println(linea);
									if (numeroLinea == 6){
										int cuentaDigitos = 3;
										String numeroString = "";
										while (cuentaDigitos < linea.length()){
											numeroString = numeroString + String.valueOf(cadenaSeparada[cuentaDigitos]);
										}
										numeroPaginas = Integer.parseInt(numeroString);
										for (int i = 0; i < numeroPaginas; i++) {
											buffer.registroPaginas.put(i,0);
										}
									}
								}
								else {
									int numPagina = Integer.parseInt(String.valueOf(cadenaSeparada[8]));
									buffer.registroTemporal.add(numPagina);
								}
							}

						} catch (FileNotFoundException e){

							System.out.println("No se encontró el archivo");

						}

						System.out.println();

						AlgoritmoEnvejecimiento analizador = new AlgoritmoEnvejecimiento(buffer);
						Registro manejador = new Registro(buffer);
			
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

	public synchronized void agregarRegistro(int numPagina) {

		this.registroPaginas.put(numPagina, 0);

	}

	public synchronized int agregarMarco(int numPagina) {

		int resultado = 0;

		if (this.listaMarcosLlena == false){
			this.marcoPaginas.put(numPagina, "00000000");
		}
		return resultado;

	}

}
