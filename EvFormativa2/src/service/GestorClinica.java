package service;
import model.Animal;

public interface GestorClinica {
    public void registrarEnColeccion(Animal a);
    public void BuscarAnimal(String buscar);
}
