package logica;

public class Registro extends Thread{

    public void run(){

        while (true){

            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
