//import model.Animal;
import model.Gato;
import model.Perro;

public class App{
public static void main(String[] args) {

Perro perro1 = new Perro();
Perro perro2 = new Perro();

Gato gato1 = new Gato();
Gato gato2 = new Gato();

perro1.setNombre("Max");
perro1.setEdad(3);
perro1.setPeso(15.5f);
perro1.setRaza("Labrador");
perro1.setVacunado(true);
perro1.setAdoptable(false);
perro1.registrarEnColeccion(perro1); //registrar en la coleccion

//--------------------------------------

perro2.setNombre("rex");
perro2.setEdad(5);
perro2.setPeso(8.0f);
perro2.setRaza("Beagle");
perro2.setVacunado(false);
perro2.registrarEnColeccion(perro2); //registrar en la coleccion

//---------------------------------------

gato1.setNombre("Max");
gato1.setEdad(2);
gato1.setPeso(4.2f);
gato1.setExterior(false);
gato1.registrarEnColeccion(gato1); //registrar en la coleccion

//---------------------------------------

gato2.setNombre("Luna");
gato2.setEdad(4);
gato2.setPeso(5.1f);
gato2.setExterior(true);
gato2.registrarEnColeccion(gato2);  //registrar en la coleccion


//---------OPERACIONES DE METODOS------------

perro1.registrarAdoptable(true); //marcar a max como adoptable una vez creado

perro1.BuscarAnimal("Max");

System.out.println("******** LISTA DE ANIMALES ********");
System.out.println(perro1.toString());
System.out.println(perro2.toString());
System.out.println(gato1.toString());
System.out.println(gato2.toString());



}

}
