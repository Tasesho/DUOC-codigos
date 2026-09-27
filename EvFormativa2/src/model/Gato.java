package model;

public class Gato extends Animal{
    
    private boolean isExterior;
    
    public Gato(){
        super();
    }

    public boolean getExterior(){
        return isExterior;
    }

    public void setExterior(boolean isExterior){
        try{
            this.isExterior= isExterior;
    }
    catch(IllegalArgumentException ex) {
        System.out.println("Debe ingresar obligatoriamente un valor Booleano (true or false)");
    }
    }

    @Override
    public void calcularCosto(){
        float total=0;

        if(isExterior==false){
            total+= 12000 + 12000*0.15;
            
            System.out.println("El valor total a pagar es de: " + total);
        }
        else{
            System.out.println("El valor a pagar es de: "+ 12000);
        }
    }
}
