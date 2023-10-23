
package ejer04;

import java.util.ArrayList;


public class Consumidor extends Thread{
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }   
    
    
    @Override
    public void run(){
        System.out.println("Consumidor extrayendo datos.");
        ArrayList<Integer> enteros = buffer.cogerDatos();
        System.out.println("Mostrando datos extraídos: ");
        enteros.forEach(System.out::println);        
    }
    
}
