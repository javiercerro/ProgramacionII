package LP;


import java.util.ArrayList;

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
			System.out.println("4.- Salir");
			
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
					
				case 4: 
					System.out.println("Agur !!");
					break;
			
			}
			
			
		}
		
		
		
	}
	
	private static void RecogerDatosA (clsGestor objG)
	{
		int cred;
		String nombre;
		
		System.out.println("Introduzca el nombre del alumno: ");
		
		nombre = UtilidadesLP.leerCadena();
		
		System.out.println("Introduzca creditos: ");
		
		cred= UtilidadesLP.leerEntero();
		
		objG.CrearAlumno(nombre,cred);
		
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
			System.out.println(p.getProperty("Nombre"));
			System.out.println(p.getProperty("Creditos"));
		}
		
	}

}
