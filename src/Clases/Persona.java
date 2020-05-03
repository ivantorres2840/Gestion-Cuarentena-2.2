package Clases;
/**
 * 
 * @author Ivan Torres
 * @version 1.0
 *
 */
import java.io.Serializable;

public abstract class Persona implements Serializable {
	protected String nombre;
	protected String dni;
	
	public Persona(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "nombre: "+ nombre + "dni: " + dni;
	}
	
}
