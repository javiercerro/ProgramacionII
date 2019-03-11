package LN;

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
			case "Nombre": return 	this.getNombre();
			case "Creditos": return this.num_Creditos;
		
		
		}
		
		
		
		return null;
	}

}
