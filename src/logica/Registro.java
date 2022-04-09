package logica;

public class Registro extends Thread{

    private Principal buffer;

    public Registro(Principal b){

        this.buffer = b;
        
    }

    public void run(){

        while (buffer.getListaOrdenada().size() > 0){
            int paginaActual = buffer.getListaOrdenada().get(0);
            buffer.agregarMarco(paginaActual);

            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
