
package ejer04;

import java.util.ArrayList;
import java.util.Random;

public class Productor extends Thread{
    private Buffer buffer;
    private int capacidad;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
        this.capacidad = 5;
    }
    
    
    @Override
    public void run(){
        Random random = new Random();
        ArrayList<Integer> enteros = new ArrayList<>(); 
        for (int i = 0; i < capacidad; i++) {
            int randomNumber = random.ints(1, 101).findFirst().getAsInt();
            System.out.println("Productor generando valor " + randomNumber);
            enteros.add(randomNumber);
        }
        System.out.println("Introduciendo datos en buffer.");
        buffer.ponerDatos(enteros);        
    }
    
}
