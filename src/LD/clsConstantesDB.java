package LD;

public class clsConstantesDB 
{
	
	//CONSTANTES PARA LA CREACIÓN DEL ACCESO A BASE DE DATOS.
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "academia_bd";
	public static final String TIME="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "root";
	
	
	
	
	
	public static final String SQL_INSERT_ALUMNO = "INSERT INTO `academia_bd`.`alumno`\r\n" + 
													"(`DNI`,\r\n" + "`NOMBRE`,\r\n" + "`APELLIDO`)\r\n" + 
													"VALUES\r\n" +"(?,\r\n" + "?,\r\n" + "?);\r\n";
	
	public static final String SQL_SELECT_ALUMNO ="SELECT * FROM academia_bd.alumno";
	
	
	
	
	

}
