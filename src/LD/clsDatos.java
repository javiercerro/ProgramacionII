package LD;

import java.sql.*;

import static LD.clsConstantesDB.DRIVER;
import static LD.clsConstantesDB.PASS;
import static LD.clsConstantesDB.SCHEMA;
import static LD.clsConstantesDB.URL;
import static LD.clsConstantesDB.USER;
import static LD.clsConstantesDB.TIME;

import static LD.clsConstantesDB.SQL_INSERT_ALUMNO;
import static LD.clsConstantesDB.SQL_SELECT_ALUMNO;



/**
 * Clase para el acceso a datos.
 * @author javier.cerro
 *
 */
public class clsDatos 
{
	Connection conn = null;
	
	
	public clsDatos()
	{
		this.Connect();
	}
	
	/**
	 * Método para la conexión a la base de datos.
	 * 
	 */
	 public void Connect()
	 {
		 
		 
		 try 
		 {
		   Class.forName(DRIVER).newInstance();
		   conn = DriverManager.getConnection(URL+SCHEMA+TIME,USER,PASS);
		   System.out.println("Connected to the database");
		   
		   
		 }
		 catch (Exception e) 
		 {
		     System.out.println("NO CONNECTION ");
		 }
	 }
	 
	 
	 public void Disconnect()
	 {
		 
		 try 
		 {
			conn.close();
		 } 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } 
		 
	 }
	 
	 public int InsertarAlumno(String dni, String nombre, String apellido)
	 {
		 PreparedStatement psInsertar = null;
		 int regActualizados=0;
		 int retorno=0;
		 
		 try 
		 {
			psInsertar = conn.prepareStatement(SQL_INSERT_ALUMNO,PreparedStatement.RETURN_GENERATED_KEYS);
			psInsertar.setString(1, dni);
			psInsertar.setString(2, nombre);
			psInsertar.setString(3, apellido);
			
			regActualizados=psInsertar.executeUpdate();
			
			if(regActualizados ==1)
			{
				ResultSet rs = psInsertar.getGeneratedKeys();
	            if(rs.next())
	            {
	                retorno= rs.getInt(1);
	            }
			}
			
			
		 } 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return retorno;
		 
	 }
	 
	 public ResultSet DameAlumnos() 
	 {
		 ResultSet retorno = null;
		 
		 retorno = sendSelect(SQL_SELECT_ALUMNO);
		 
		 return retorno;
		 
	 }
	 
	 private ResultSet sendSelect(String sql)
	 {
		 

			Statement stmt=null;
			ResultSet rs=null;
			
			try 
			{
				stmt = conn.createStatement();
				rs=stmt.executeQuery(sql);
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return rs; 
			
	 }
	 

}



