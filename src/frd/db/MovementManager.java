package frd.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import frd.model.Movement;

public class MovementManager extends JDBCManager {
	public static void createDbMovementTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBMOVEMENT("
				+ "USER_ID NUMERIC(5) NOT NULL, "
				+ "LOT_ID NUMERIC(5) NOT NULL"
				+ "MOVEMENT_ID NUMERIC(5) NOT NULL"
				+ "DESCRIPTION VARCHAR(200)"
				+ "DATE DATE NOT NULL, "
				+ "AMOUNT NUMERIC(3) NOT NULL" + "PRIMARY KEY (USER_ID) "
				+ ")";

		execute( createTableSQL );
	}
	
	public static void insertMovement(int userId,int lotId, int movementId, String description, Date date, int amount) throws SQLException{
		String insertTableSQL = "INSERT INTO DBMOVEMENT"
			+ "(USER_ID, DESCRIPTION, DATE) " + "VALUES"
			+ "("+userId+",'"+lotId+"','"+movementId+"', '"+description+"', " + "to_date('"
			+ dateFormat.format(date.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'), '"+amount+"')" ;
		
		executeUpdate( insertTableSQL );
	}
 	public static void deleteMovement(int movementId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBMOVEMENT WHERE MOVEMENT_ID = "+movementId;
		
		execute( deleteTableSQL );
	}
	
	public static List<Movement> getMovements() throws SQLException{
		List<Movement> result = new ArrayList<Movement>();
		
		String selectTableSQL = "SELECT * from DBMOVEMENT";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			//Creo el usuario a partir de los datos obtenidos de la base
			Movement mov = new Movement();

			if( register.containsKey("movement_id") )
				mov.setId( ((BigDecimal) register.get("movement_id")).intValue() );
			
			if( register.containsKey("user_id") )
				mov.setUser( ((BigDecimal) register.get("user_id")).intValue() );
			
			if( register.containsKey("lot_id") )
				mov.setLot (((BigDecimal) register.get("lot_id") ).intValue() );
			
			if( register.containsKey("description") )
				mov.setDescription((String) register.get("description") );
			
			//if( register.containsKey("amount") )
			//	mov.setAmount((int) register.get("amount") );
			
			if( register.containsKey("date") )
				mov.setDate((Date) register.get("date") );

			result.add( mov );
		}
		
		return result;
	}
}