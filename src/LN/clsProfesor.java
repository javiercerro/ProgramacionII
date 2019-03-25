package LN;

public class clsProfesor extends clsPersona 
{
	
	private int id;
	
	public clsProfesor()
	{
		this.id=-1;
	}
	
	public clsProfesor(String nombre, String apellido, String dni) 
	{
		super(nombre, apellido, dni);
		this.id=-1;
		
	}

	@Override
	public Object getProperty(String propiedad) 
	{
	
		return null;
	}
	

}
