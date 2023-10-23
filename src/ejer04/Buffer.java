package ejer04;

import java.util.ArrayList;

public class Buffer {

    private ArrayList<Integer> listaEnteros;
    private boolean hayDatos;

    public Buffer() {
        this.listaEnteros = new ArrayList();
        this.hayDatos = false;
    }

    public synchronized ArrayList<Integer> cogerDatos() {        
        
        if(listaEnteros.size() > 0){
            hayDatos = true;    
        }
        
        while (hayDatos == false) {
            try {
                // Espera a que el productor coloque datos en la lista.
                System.out.println("Esperando a que se coloquen los datos.");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        hayDatos = false;
        // Notificar que no hay datos.
        System.out.println("No hay datos.");
        notifyAll();
        return listaEnteros;
    }
    
    public synchronized void ponerDatos(ArrayList<Integer> datos){
        while(hayDatos == true){
            try {
                // Espera a que se consuma el dato
                System.out.println("Esperando a que se consuman los datos.");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        for(int dato : datos){
            listaEnteros.add(dato);
        }
        
        hayDatos = true;
        // Notificar que hay dato.
        System.out.println("Hay datos");
        notifyAll();
    }
}
