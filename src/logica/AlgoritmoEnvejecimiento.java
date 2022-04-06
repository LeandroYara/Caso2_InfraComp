package logica;

public class AlgoritmoEnvejecimiento extends Thread {

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
