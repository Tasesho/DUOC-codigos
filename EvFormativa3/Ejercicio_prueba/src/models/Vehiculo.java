package models;

public abstract class Vehiculo {
    
    //declarar atributos

    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;

    public Vehiculo(String marca, String modelo, int anio, double kilometraje){
        this.marca=marca;
        this.modelo=modelo;
        this.anio=anio;
        this.kilometraje=kilometraje;
    }

    public Vehiculo(){}

    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }

    public int getAnio(){
        return anio;
    }

    public double getKm(){
        return kilometraje;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    public void setAnio(int anio){
        this.anio=anio;
    }

    public void setKm(double kilometraje){
        this.kilometraje=kilometraje;
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", kilometraje=" + kilometraje
                + "]";
    }

    
}
