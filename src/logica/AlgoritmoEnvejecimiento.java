package logica;

public class AlgoritmoEnvejecimiento extends Thread {

    private Principal buffer;

    public AlgoritmoEnvejecimiento(Principal b){

        this.buffer = b;
        
    }

    public void run(){

        while (buffer.getListaOrdenada().size() > 0){
            if (buffer.getListaLlena() == true) {
                buffer.quitarMarco();
                buffer.setListaLlena(false);
            }

            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}
