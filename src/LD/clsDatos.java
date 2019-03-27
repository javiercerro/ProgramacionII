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
	/**
	 * Objeto para crear la conexión a base de datos.
	 */
	Connection conn = null;
	
	/**
	 * Objeto para crear la consulta a base de datos.
	 */
	PreparedStatement ps=null;
	
	/**
	 * Objeto para devolver el resultado de la consulta.
	 */
	ResultSet rs=null;
	
	
	public clsDatos()
	{
		//
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
			ps.close(); // cerrar el statement tb cierra el resultset.
		 } 
		 catch (SQLException e) 
		 {
			
		 }
		 finally 
		 {
			 try {conn.close();} catch(Exception e){/*no hago nada*/}
			 try {ps.close();} catch(Exception e){/*no hago nada*/}
		 }
		 
		 
	 }
	 
	 public int InsertarAlumno(String dni, String nombre, String apellido)
	 {
		 
		 int regActualizados=0;
		 int retorno=0;
		 
		 try 
		 {
			ps= conn.prepareStatement(SQL_INSERT_ALUMNO,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			
			regActualizados=ps.executeUpdate();
			
			if(regActualizados ==1)
			{
				ResultSet rs = ps.getGeneratedKeys();
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
		 
		 
		 rs= sendSelect(SQL_SELECT_ALUMNO);
		 
		 return rs;
		 
	 }
	 
	 private ResultSet sendSelect(String sql)
	 {
			
			
			try 
			{
				ps = conn.prepareStatement(sql);
				rs=ps.executeQuery(sql);
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return rs; 
			
	 }
	 

}



