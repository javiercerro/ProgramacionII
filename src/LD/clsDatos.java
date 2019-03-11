package LD;

import java.sql.*;

import static COMUN.clsConstantes.DRIVER;
import static COMUN.clsConstantes.PASS;
import static COMUN.clsConstantes.SCHEMA;
import static COMUN.clsConstantes.URL;
import static COMUN.clsConstantes.USER;


/**
 * Clase para el acceso a datos.
 * @author javier.cerro
 *
 */
public class clsDatos 
{
	Connection conn = null;
	
	
	
	 private void startConnection()
	 {
		 
		 
		 try 
		 {
		   Class.forName(DRIVER).newInstance();
		   conn = DriverManager.getConnection(URL+SCHEMA,USER,PASS);
		   System.out.println("Connected to the database");
		   conn.close();
		   System.out.println("Disconnected from database");
		 }
		 catch (Exception e) 
		 {
		     System.out.println("NO CONNECTION ");
		 }
	 }
	 
	 public ResultSet sendSelect(String sql)
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



