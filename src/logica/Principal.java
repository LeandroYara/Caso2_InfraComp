package logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
		this.numeroFallas = 0;
		this.listaLlena = false;
	}
	
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

                        String nombreFile = "";
                        int tamañoPagina = 0;
                        int tamañoEntero = 0;
                        int filasMatrices = 0;
                        int columnasMatrices = 0;
                        int tipoRecorrido = 0;
                        int numberPaginas = 0;
                        int numeroReferencias = 0;
                        boolean resultadoCreacion;

                        Scanner scanParametros = new Scanner(System.in);
                        System.out.println("Escriba el nombre del archivo de configuración (sin .txt): ");
						nombreFile = scanParametros.nextLine();

                        System.out.println("Escriba el tamaño de una pagina: ");
						tamañoPagina = Integer.parseInt(scanParametros.nextLine());

                        System.out.println("Escriba el tamaño de un entero: ");
						tamañoEntero = Integer.parseInt(scanParametros.nextLine());

                        System.out.println("Escriba el numero de filas de las matrices: ");
						filasMatrices = Integer.parseInt(scanParametros.nextLine());

                        System.out.println("Escriba el numero de columnas de las matrices: ");
						columnasMatrices = Integer.parseInt(scanParametros.nextLine());

                        System.out.println("Escriba el tipo de recorrido (1 o 2): ");
						tipoRecorrido = Integer.parseInt(scanParametros.nextLine());

                        numberPaginas = tamañoPagina/tamañoEntero * 3;

                        numeroReferencias = filasMatrices * columnasMatrices * 3;

                        File archivo = new File("docs\\" + nombreFile + ".txt");
                        try {
                            resultadoCreacion = archivo.createNewFile();
                            if (resultadoCreacion){
                                System.out.println("Se creo el archivo de referencias");
                                FileWriter fileStream = new FileWriter("docs\\" + nombreFile + ".txt");
                                BufferedWriter info = new BufferedWriter(fileStream);

                                info.write("TP=" + Integer.toString(tamañoPagina));
                                System.out.println("TP=" + Integer.toString(tamañoPagina) + "\\n");
                                info.newLine();
                                info.write("TE=" + Integer.toString(tamañoEntero));
                                System.out.println("TE=" + Integer.toString(tamañoEntero) + "\n");
                                info.newLine();
                                info.write("NF=" + Integer.toString(filasMatrices));
                                System.out.println("NF=" + Integer.toString(filasMatrices) + "\n");
                                info.newLine();
                                info.write("NC=" + Integer.toString(columnasMatrices));
                                System.out.println("NC=" + Integer.toString(columnasMatrices) + "\n");
                                info.newLine();
                                info.write("TR=" + Integer.toString(tipoRecorrido));
                                System.out.println("TR=" + Integer.toString(tipoRecorrido) + "\n");
                                info.newLine();
                                info.write("NP=" + Integer.toString(numberPaginas));
                                System.out.println("NP=" + Integer.toString(numberPaginas) + "\n");
                                info.newLine();
                                info.write("NR=" + Integer.toString(numeroReferencias));
                                System.out.println("NR=" + Integer.toString(numeroReferencias) + "\n");

                                int valorA = 0;
                                int valorB = tamañoPagina/tamañoEntero;
                                int valorC = (tamañoPagina/tamañoEntero) * 2;

                                if (tipoRecorrido == 1){
                                    for (int i = 0; i < filasMatrices; i++){
                                        for (int j = 0; j < columnasMatrices; j++){
                                            info.newLine();
                                            info.write("A:[" + Integer.toString(i) + "-" + Integer.toString(j) + "]," + Integer.toString(valorA + i) + "," + Integer.toString(tamañoEntero * j));
                                            info.newLine();
                                            info.write("B:[" + Integer.toString(i) + "-" + Integer.toString(j) + "]," + Integer.toString(valorB + i) + "," + Integer.toString(tamañoEntero * j));
                                            info.newLine();
                                            info.write("C:[" + Integer.toString(i) + "-" + Integer.toString(j) + "]," + Integer.toString(valorC + i) + "," + Integer.toString(tamañoEntero * j));
                                        }
                                    }
                                }
                                else {
                                    if (tipoRecorrido == 2) {
                                        for (int j = 0; j < columnasMatrices; j++){
                                            for (int i = 0; i < filasMatrices; i++){
                                                info.newLine();
                                                info.write("A:[" + Integer.toString(i) + "-" + Integer.toString(j) + "]," + Integer.toString(valorA + i) + "," + Integer.toString(tamañoEntero * j));
                                                info.newLine();
                                                info.write("B:[" + Integer.toString(i) + "-" + Integer.toString(j) + "]," + Integer.toString(valorB + i) + "," + Integer.toString(tamañoEntero * j));
                                                info.newLine();
                                                info.write("C:[" + Integer.toString(i) + "-" + Integer.toString(j) + "]," + Integer.toString(valorC + i) + "," + Integer.toString(tamañoEntero * j));
                                            }
                                        }
                                    }
                                }
                                info.close();
                            }
                            else {
                                System.out.println("El archivo ya existe");
                            }
                        } catch(IOException e) {
                            e.printStackTrace();
                            scanParametros.close();
                        }

						break;

                    case 2:
					
						Scanner scanConfiguracion = new Scanner(System.in);
						System.out.println("Escriba el nombre del archivo de referencias: ");
						String nombreArchivo = scanConfiguracion.nextLine();

						System.out.println("Escriba el numero de marcos de pagina: ");
						buffer.numeroMarcos = Integer.parseInt(scanConfiguracion.nextLine());

						int numeroPaginas = 0;

						try {
							Scanner archivoConfiguracion = new Scanner(new File("docs\\" + nombreArchivo));
							int numeroLinea = 1;
                            System.out.println("Configuracion del archivo: ");

							while (archivoConfiguracion.hasNextLine()){
								String linea = archivoConfiguracion.nextLine();
                                System.out.println(linea);
								char[] cadenaSeparada = linea.toCharArray();
								if (numeroLinea <= 7){
									if (numeroLinea == 6){
										int cuentaDigitos = 3;
										String numeroString = "";
										while (cuentaDigitos < linea.length()){
											numeroString = numeroString + String.valueOf(cadenaSeparada[cuentaDigitos]);
											cuentaDigitos += 1;
										}
										numeroPaginas = Integer.parseInt(numeroString);
										for (int i = 0; i < numeroPaginas; i++) {
											buffer.registroPaginas.put(i,0);
										}
									}
								}
								else {
									String numeroParcial = "";
									int cuentaPagina = 8;
									int numeroFinal = 0;
									while (cadenaSeparada[cuentaPagina] != ','){
										numeroParcial = numeroParcial + String.valueOf(cadenaSeparada[cuentaPagina]);
										cuentaPagina += 1;
									}
									numeroFinal = Integer.parseInt(numeroParcial);
									buffer.listaOrdenada.add(numeroFinal);
								}
								numeroLinea += 1;
							}
							archivoConfiguracion.close();
						} catch (FileNotFoundException e){

							System.out.println("No se encontró el archivo");
						}

						AlgoritmoEnvejecimiento analizador = new AlgoritmoEnvejecimiento(buffer);
						Registro manejador = new Registro(buffer);
			
						analizador.start();
						manejador.start();

						break;

                    case 3:

                        salir = true;
						sn.close();
						
						break;
				}

			} catch (InputMismatchException e) {

				System.out.println("Debes insertar un número");
                sn.next();
			}
		}
	}

	public synchronized void agregarMarco(int numPagina) {

		if (this.registroPaginas.get(numPagina) == 0) {
			this.marcoPaginas.put(numPagina, "");
			this.numeroFallas += 1;
			this.registroPaginas.put(numPagina, 1);
		}

		this.listaOrdenada.remove(0);
		Set<Integer> listaLlaves = this.marcoPaginas.keySet();
		
		for (Integer llave : listaLlaves) {
			if (llave == numPagina){
				this.marcoPaginas.put(llave, "1" + this.marcoPaginas.get(llave));
			}
			else {
				this.marcoPaginas.put(llave, "0" + this.marcoPaginas.get(llave));
			}
		}

		if (this.marcoPaginas.size() == this.numeroMarcos){
			this.listaLlena = true;
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
				if (separacionCadena[contador] == '1'){
					unoHallado = true;
				}
				else {
					cuentaCeros += 1;
				}
				contador += 1;
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
