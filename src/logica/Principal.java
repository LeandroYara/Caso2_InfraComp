package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Principal {

	private int numeroMarcos;
	private Hashtable<Integer, String> marcoPaginas;
	private Hashtable<Integer, Integer> registroPaginas;
	private ArrayList<Integer> listaOrdenada;
	private int numeroFallas;

	private boolean listaLlena = false;

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

	public ArrayList<Integer> getListaOrdenada() {
		return this.listaOrdenada;
	}

	public void setListaOrdenada(ArrayList<Integer> listaOrdenada) {
		this.listaOrdenada = listaOrdenada;
	}

	public int getNumeroFallas() {
		return this.numeroFallas;
	}

	public void setNumeroFallas(int numeroFallas) {
		this.numeroFallas = numeroFallas;
	}

	public boolean getListaLlena() {
		return this.listaLlena;
	}

	public void setListaLlena(boolean listaLlena) {
		this.listaLlena = listaLlena;
	}

	public Principal() {
		this.numeroMarcos = 0;
		this.marcoPaginas = new Hashtable<Integer, String>();
		this.registroPaginas = new Hashtable<Integer, Integer>();
		this.listaOrdenada = new ArrayList<Integer>();
		this.listaLlena = false;
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
							Scanner archivoConfiguracion = new Scanner(new File("docs\\" + nombreArchivo));
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
									buffer.listaOrdenada.add(numPagina);
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
						sn.close();

                    default:
                        System.out.println("Solo números entre 1 y 3");
				}
			} catch (InputMismatchException e) {

				System.out.println("Debes insertar un número");
                sn.next();
			}
		}
	}

	public synchronized void agregarMarco(int numPagina) {

		this.marcoPaginas.put(numPagina, "00000000");
		this.listaOrdenada.remove(0);
		this.numeroFallas += 1;
		Set<Integer> listaLlaves = this.marcoPaginas.keySet();
		
		for (Integer llave : listaLlaves) {
			if (llave == numPagina){
				this.marcoPaginas.put(llave, "1" + this.marcoPaginas.get(llave));
			}
			else {
				this.marcoPaginas.put(llave, "0" + this.marcoPaginas.get(llave));
			}
		}
	}

	public synchronized void quitarMarco() {

		int paginaVieja = 0;
		int numeroViejo = 0;
		char [] separacionCadena;
		Set<Integer> listaLlaves = this.marcoPaginas.keySet();
		
		for (Integer llave : listaLlaves) {
			separacionCadena = this.marcoPaginas.get(llave).toCharArray();
			int contador = 0;
			int cuentaCeros = 0;
			boolean unoHallado = false;
			while ((contador < separacionCadena.length) && (unoHallado == false)){
				if (separacionCadena[contador] == '0'){
					cuentaCeros += 1;
				}
				else {
					if (separacionCadena[contador] == '1'){
						unoHallado = true;
					}
				}
			}
			if (cuentaCeros >= numeroViejo){
				paginaVieja = llave;
				numeroViejo = cuentaCeros;
			}
		}
		this.marcoPaginas.remove(paginaVieja);
		this.registroPaginas.put(paginaVieja, 0);
	}
}
