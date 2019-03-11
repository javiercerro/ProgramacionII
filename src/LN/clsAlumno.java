package LN;

import static COMUN.clsConstantes.PROPIEDAD_CREDITOS;
import static COMUN.clsConstantes.PROPIEDAD_NOMBRE;

public class clsAlumno extends clsPersona 
{
	private int num_Creditos;
	
	
	public clsAlumno()
	{
		num_Creditos=0;
	}
	
	public clsAlumno (String nombre, int creditos)
	{
		super(nombre);
		this.num_Creditos=creditos;
	}
	
	
	@Override
	public Object getProperty(String propiedad) 
	{
		
		switch(propiedad)
		{
			case PROPIEDAD_NOMBRE: return 	this.getNombre();
			case PROPIEDAD_CREDITOS: return this.num_Creditos;
		
		
		}
		
		
		
		return null;
	}

}
