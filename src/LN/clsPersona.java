package LN;

import COMUN.itfProperty;

/**
 * Clase persona que es el padre de la jerarquía de todos los objetos de tipo persona.
 * @author javier.cerro
 *
 */
public abstract class clsPersona implements itfProperty,Comparable<clsPersona>
{
	
	/**
	 * Nombre de la persona 
	 */
	private String nombre;
	private String apellido;
	private String dni;
	
	
	public clsPersona()
	{
		this.apellido="";
		this.nombre="";
		this.dni="";
	}
	public clsPersona(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getApellido() 
	{
		return apellido;
	}
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	public String getDni() 
	{
		return dni;
	}
	
	public void setDni(String dni) 
	{
		this.dni = dni;
	}
	
	@Override
	public int compareTo(clsPersona o) 
	{
		return this.nombre.compareTo(o.getNombre());
	}

	
	
	
	
	

}
