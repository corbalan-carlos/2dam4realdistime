package main;

import java.lang.reflect.Field;
/*
 * En un principio me gustaría haberlo hecho "bien" pero la verdad es que la escabilidad
 * y medio legibilidad es un lujo que ni me puedo permitir o que valga la pena en un 
 * proyecto de no mas de 5 horas
 * 
 * El objetivo principal era crear una interfaz DAO con la cual comunican las clase de tipo repo
 *  
 * Cualquier clase que haga de intermediario con el programa y datos externos seria DAO e implementaria 
 * una interfaz llamada DAO, la cual podria ser tanto por SQL como por ficheros asi que para las clases 
 * de tipo repo le pasas un DAO y esta se comunica con este DAO utilizando los metodos declarados en DAO
 * haciendolo agnostico al tipo de DAO que es. El DAO solo se tiene que encargar de cumplir la API declarada 
 * por la interfaz y la clase repo se lo debería tragar
 * 
 * Alguna cosa buena tiene que tener ponerle tanto overhead al proceso pero weno
 *  
 */
public class Main {
	public static void main(String[] args) throws IllegalAccessException, FieldNotValidException {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
>>>>>>> refs/remotes/origin/main
	}

}
