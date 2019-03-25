package LP;


import java.util.ArrayList;

import static COMUN.clsConstantes.PROPIEDAD_ALUMNO_NOMBRE;
import static COMUN.clsConstantes.PROPIEDAD_ALUMNO_DNI;

import COMUN.itfProperty;
import LN.clsGestor;

public class clsMenu 
{
	
	/**
	 * Recoge por pantalla datos de profesor.
	 */
	public static void Menu1 ()
	{
		int op=0;
		clsGestor objGestor;
		objGestor = new clsGestor();
		
		while (op!=4)
		{
			
			
			System.out.println("1.- Alta de alumno");
			System.out.println("2.- Alta de profesor");
			System.out.println("3.- Mostrar Datos");
			System.out.println("4.- Mostrar Datos Ordenados");
			System.out.println("5.- Salir");
			
			System.out.println("Introduzca la opción:");
			op=UtilidadesLP.leerEntero();
			
			switch(op)
			{
				case 1:RecogerDatosA(objGestor); 
					break;
				
				case 2:RecogerDatosP(objGestor); 
				break;
				
				case 3:MostrarDatos(objGestor); 
				break;
				
				case 4:MostrarDatosOrdenados(objGestor); 
				break;
					
				case 5: 
					System.out.println("Agur !!");
					break;
			
			}
			
			
		}
		
		
		
	}
	
	private static void RecogerDatosA (clsGestor objG)
	{
		
		String nombre;
		String apellido;
		String dni;
		
		System.out.println("Introduzca el nombre del alumno: ");
		nombre = UtilidadesLP.leerCadena();
		
		System.out.println("Introduzca apellido: ");
		apellido= UtilidadesLP.leerCadena();
		
		System.out.println("Introduzca dni: ");
		dni= UtilidadesLP.leerCadena();
		
		objG.CrearAlumno(nombre,apellido,dni);
		
	}
	
	private static void RecogerDatosP (clsGestor objG)
	{
		
		System.out.println("Introduzca el nombre del profesor: ");
		
		String  nombre = UtilidadesLP.leerCadena();
		
		objG.CrearProfesor(nombre);
		
		
		
	}
	
	private static void MostrarDatos (clsGestor objG)
	{
		
		ArrayList<itfProperty> personas;
		
		personas = objG.DamePersonas();
		
		for(itfProperty p:personas)
		{
			System.out.println(p.getProperty(PROPIEDAD_ALUMNO_DNI) + " - " + p.getProperty(PROPIEDAD_ALUMNO_NOMBRE));
			
		}
		
	}
	
	private static void MostrarDatosOrdenados (clsGestor objG)
	{
		
		ArrayList<itfProperty> personas;
		
		personas = objG.DamePersonasOrdenadas();
		
		for(itfProperty p:personas)
		{
			System.out.println(p.getProperty(PROPIEDAD_ALUMNO_DNI) + " - " + p.getProperty(PROPIEDAD_ALUMNO_NOMBRE));
		}
		
	}

}
