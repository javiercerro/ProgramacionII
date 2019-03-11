package LN;

import COMUN.itfProperty;

/**
 * Clase persona que es el padre de la jerarquía de todos los objetos de tipo persona.
 * @author javier.cerro
 *
 */
public abstract class clsPersona implements itfProperty
{
	
	/**
	 * Nombre de la persona 
	 */
	private String nombre;
	
	public clsPersona()
	{
		this.nombre="";
	}
	
	public clsPersona (String nombre)
	{
		this.nombre=nombre;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	

}
