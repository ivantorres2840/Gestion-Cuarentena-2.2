package Clases;
/**
 * 
 * @author Ivan Torres
 * @version 1.0
 *
 */
public final class Ciudadano extends Persona{
	private String nCiudadano;

	public Ciudadano(String nombre, String dni, String nCiudadano) {
		super(nombre, dni);
		this.nCiudadano = nCiudadano;
	}

	public String getnCiudadano() {
		int x;
		return nCiudadano;
	}

	public String getNombre(){
		return nombre;
	}

	@Override
	public String toString() {
		return super.toString()+ " nCiudadano: " + nCiudadano;
	}
	
	
	
}
