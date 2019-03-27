package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import COMUN.itfProperty;
import LD.clsDatos;


import static COMUN.clsConstantes.CAMPO_ALUMNO_APELLIDO;
import static COMUN.clsConstantes.CAMPO_ALUMNO_DNI;
import static COMUN.clsConstantes.CAMPO_ALUMNO_ID;
import static COMUN.clsConstantes.CAMPO_ALUMNO_NOMBRE;

public class clsGestor 
{
	
	private ArrayList<clsPersona>miLista;
	private clsDatos objDatos;
	
	public clsGestor ()
	{
		miLista = new ArrayList<clsPersona>();
		objDatos=new clsDatos();
		this.CargarAlumnos();
		
	}
	
	
	public void CargarAlumnos()
	{
		//Conecto a la base de datos.
		objDatos.Connect();
		//Leo la información y la uso.
		ResultSet alumnos=objDatos.DameAlumnos();
		try 
		{
			while(alumnos.next())
			{
				String nombre=alumnos.getString(CAMPO_ALUMNO_NOMBRE);
				String apellido=alumnos.getString(CAMPO_ALUMNO_APELLIDO);
				String dni=alumnos.getString(CAMPO_ALUMNO_DNI);
				int id=alumnos.getInt(CAMPO_ALUMNO_ID);
				
				miLista.add(new clsAlumno(nombre,apellido,dni,id));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Libero los recursos.
		objDatos.Disconnect();
	}
	
	public void CrearAlumno (String _nombre, String _apellido, String _dni)
	{
		clsAlumno objAlumno;
		
		objAlumno = new clsAlumno(_nombre, _apellido, _dni);
		miLista.add(objAlumno);
		//Lo guardo en base de datos.
		objDatos.Connect();
		objDatos.InsertarAlumno(_dni, _nombre, _apellido);
		objDatos.Disconnect();
		
		
		
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
	
	public ArrayList<itfProperty> DamePersonasOrdenadas()
	{
		ArrayList<itfProperty> retorno;
		
		retorno=new ArrayList<itfProperty>();
		
		Collections.sort(miLista);
		
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
