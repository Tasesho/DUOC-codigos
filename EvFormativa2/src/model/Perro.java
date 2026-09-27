package model;

import service.Adoptable;

public class Perro extends Animal implements Adoptable{
    private String raza;
    private boolean isVacunado;
    private boolean adoptable;

    public Perro(){
        super();
    };
    
    public String getRaza(){
        return raza;
    }

    public boolean getVacunado(){
        return isVacunado;
    }

    public void setRaza(String raza){
       try{
        this.raza=raza;
       }
       catch(IllegalArgumentException ex) {
        System.out.println("Debe ingresar obligatoriamente un valor del tipo: String. No puede ser NULL o vacio");
       }
    }

    public void setVacunado(boolean isVacunado){
       try{
        this.isVacunado=isVacunado;
       }
       catch(IllegalArgumentException ex) {
        System.out.println("Debe ingresar obligatoriamente un valor del tipo: boolean.");
       }
    }

    public void setAdoptable(boolean adoptable){
       try{
        this.adoptable=adoptable;
       }
       catch(IllegalArgumentException ex) {
        System.out.println("Debe ingresar obligatoriamente un valor del tipo: boolean");
       }
    }

    @Override
    public void calcularCosto(){
        float total=0;

        if(isVacunado==false){
            total+= 15000 + 15000*0.3;
            
            System.out.println("El valor total a pagar es de: " + total);
        }
        else{
            System.out.println("El valor a pagar es de: "+ 15000);
        }
    }

    @Override
    public boolean isAdoptable() {
        return adoptable;
    }

    @Override
    public void registrarAdoptable(boolean a){
        if(a==adoptable){
            System.out.println("");
        }
        else{
            adoptable=a;
        }

    }
}
