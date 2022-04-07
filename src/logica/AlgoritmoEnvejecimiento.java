package logica;

public class AlgoritmoEnvejecimiento extends Thread {

    private Principal buffer;

    public AlgoritmoEnvejecimiento(Principal b){

        this.buffer = b;
    }

    public void run(){

        while (true){

            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}
