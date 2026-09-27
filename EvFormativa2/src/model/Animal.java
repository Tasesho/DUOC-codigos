package model;

import java.util.ArrayList;
import java.util.List;

import service.GestorClinica;

public abstract class Animal implements GestorClinica{
    private String nombre;
    private int edad;
    private float peso;
    private static List<Animal> ListaAnimales = new ArrayList<>();
    
    public Animal(){};
    
    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public float getPeso(){
        return peso;
    }

    public void setNombre(String nombre){
       try{
        this.nombre=nombre;
       }
       catch(IllegalArgumentException ex) {
        System.out.println("Debe ingresar obligatoriamente un valor del tipo: String");
       }
    }

    public void setEdad(int edad){
       try{
        if(edad>=0 && peso<=30){
        this.edad=edad;
        }
       }
       catch(IllegalArgumentException ex) {
        System.out.println("Debe encontrarse en el rango entre 0 y 30 anios");
       }
    }

    public void setPeso(float peso){
       try{
        if(peso>0){
        this.peso=peso;
        }
       }
        catch(IllegalArgumentException ex) {
            System.out.println("Debe ser mayor a 0");
            }    
        }


    public abstract void calcularCosto();

    
    @Override
    public final void registrarEnColeccion(Animal a){
        ListaAnimales.add(a);
        System.out.println("EL animal: " + a.getNombre() + " Fue agregado corretamente.");
    }

    @Override
    public final void BuscarAnimal(String buscar){
        System.out.println("******** BUSQUEDA POR NOMBRE ********");
        for (Animal a : ListaAnimales) {
            if(a.getNombre().equalsIgnoreCase(buscar)){
                System.out.println(a);
            }
        }
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ": " + nombre + "| Edad: " + edad;
    }
}
