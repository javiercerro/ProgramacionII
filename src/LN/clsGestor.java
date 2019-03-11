package LN;

import java.util.ArrayList;

import COMUN.itfProperty;

public class clsGestor 
{
	
	private ArrayList<clsPersona>miLista;
	
	public clsGestor ()
	{
		miLista = new ArrayList<clsPersona>();
	}
	
	
	public void CrearAlumno (String _nombre, int _numCreditos)
	{
		clsAlumno objAlumno;
		
		objAlumno = new clsAlumno(_nombre,_numCreditos);
		miLista.add(objAlumno);
		
		
	}
	
	public ArrayList<itfProperty> DamePersonas()
	{
		ArrayList<itfProperty> retorno;
		
		retorno=new ArrayList<itfProperty>();
		
		for(clsPersona a:miLista)
		{
			retorno.add(a);
		}
		
		
		return retorno;
	}
	
	public void CrearProfesor (String _nombre)
	{
		clsProfesor objP;
		
		objP = new clsProfesor();
		objP.setNombre(_nombre);
		miLista.add(objP);
		
		
	}
	
	

}
