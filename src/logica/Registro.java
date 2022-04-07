package logica;

public class Registro extends Thread{

    private Principal buffer;

    public Registro(Principal b){
        this.buffer = b;
    }

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
