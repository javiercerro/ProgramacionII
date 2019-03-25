package LN;


import static COMUN.clsConstantes.PROPIEDAD_ALUMNO_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_ALUMNO_DNI;
import static COMUN.clsConstantes.PROPIEDAD_ALUMNO_APELLIDO;
import static COMUN.clsConstantes.PROPIEDAD_ALUMNO_ID;

public class clsAlumno extends clsPersona 
{
	
	private int id;
	

	public clsAlumno(String nombre, String apellido, String dni, int id) 
	{
		super(nombre, apellido, dni);
		this.id = id;
	}
	
	public clsAlumno(String nombre, String apellido, String dni) 
	{
		super(nombre, apellido, dni);
		this.id = -1;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}


	@Override
	public Object getProperty(String propiedad) 
	{
		
		switch(propiedad)
		{
			case PROPIEDAD_ALUMNO_NOMBRE: return 	this.getNombre();
			case PROPIEDAD_ALUMNO_DNI: return this.getDni();
			case PROPIEDAD_ALUMNO_APELLIDO: return this.getApellido();
			case PROPIEDAD_ALUMNO_ID: return this.id;
		
		}
		
		
		
		return null;
	}

	
}
