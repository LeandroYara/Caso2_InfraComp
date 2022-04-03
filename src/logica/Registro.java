package logica;

public class Registro {

	    private int numPaginaVirtual; 
	    private int tamPagina; 
	    private int tamNumEntero;
	    private int numFilasMatriz; 
	    private int numColMatriz; 
	    private int tipoRecorrido; 
	    //Constructor 2: constructor con parámetros

	    public void Parametros (int valornumPaginaVirtual, int valortamPagina, int valortamNumEntero, int valornumFilasMatriz, int valornumColMatriz, int valortipoRecorrido) {

	    numPaginaVirtual = valornumPaginaVirtual;

	    tamPagina = valortamPagina;

	    tamNumEntero = valortamNumEntero;

	    numFilasMatriz = valornumFilasMatriz;
	    
	    numColMatriz = valornumColMatriz;
	    
	    tipoRecorrido = valortipoRecorrido;

	    } 
	 
	    public void setnumPaginaVirtual (int valornumPaginaVirtual) {

	    	numPaginaVirtual = valornumPaginaVirtual;
	    }

	    public void settamPagina (int valortamPagina) {

	        tamPagina = valortamPagina;
	    }
	 

	    public void settamNumEntero (int valortamNumEntero) {

	        tamNumEntero = valortamNumEntero;
	    } 
	   
	    public void setnumFilasMatriz (int valornumFilasMatriz) {

	        numFilasMatriz = valornumFilasMatriz;  

	    } 

	    public void setnumColMatriz (int valornumColMatriz) {

	    	numColMatriz = valornumColMatriz;
	    }
	    
	    public void settipoRecorrido (int valortipoRecorrido) {

	    	tipoRecorrido = valortipoRecorrido;
	    }

	    public int getnumPaginaVirtual () { return numPaginaVirtual; } 
	    
	    
	    public int gettamPagina () { return tamPagina; } 


	    public int gettamNumEntero () { return tamNumEntero; }


	    public int getnumFilasMatriz () { return numFilasMatriz; } 
	    
	    
	    public int getnumColMatriz () { return numColMatriz; } 
	    
	    
	    public int gettipoRecorrido () { return tipoRecorrido; } 

	 


}
