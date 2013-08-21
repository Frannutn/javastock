package frd.db;

import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.List;

import frd.model.Movement;

public class MovementManager extends JDBCManager {
	public static void createDbMovementTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBMOVEMENT("
				+ "LOT_ID NUMERIC(5) NOT NULL, "
				+ "MOVEMENT_ID NUMERIC(5) NOT NULL, "
				+ "USERNAME VARCHAR(20) NOT NULL, "
				+ "DATE DATE NOT NULL, "
				+ "AMOUNT NUMERIC(3) NOT NULL, " + "PRIMARY KEY (MOVEMENT_ID) "
				+ ")";

		execute( createTableSQL );
	}

	public static void insertMovement(int movementId, int lotId, String username , Date date, int amount) throws SQLException{
		String insertTableSQL = "INSERT INTO DBMOVEMENT"
			+ "(LOT_ID, MOVEMENT_ID, USERNAME, DATE, AMOUNT) " + "VALUES"		
			+ "("+lotId+","+movementId+",'"+username+"', " + "to_date('"
			+ dateFormat.format(date.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'), "+amount+")" ;
		
		executeUpdate( insertTableSQL );
	}
	
	public static void updateMovement(int movementId, String user , int amount) throws SQLException{
		String updateTableSQL = "UPDATE DBMOVEMENT"
			+ " SET USERNAME = '"+user+"' "
			+ " ,AMOUNT = "+amount+" "
			+ " WHERE MOVEMENT_ID = "+movementId;
		
		execute( updateTableSQL );
	}
 	
	public static void deleteMovement(int movementId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBMOVEMENT WHERE MOVEMENT_ID = "+movementId;
		
		execute( deleteTableSQL );
	}
	public static void  delAll() throws SQLException{
		String deleteAllTableSQL = "DELETE FROM DBMOVEMENT";
		
		execute( deleteAllTableSQL );
	}
	public static List<Movement> getMovements() throws SQLException{
		List<Movement> result = new ArrayList<Movement>();
		
		String selectTableSQL = "SELECT * from DBMOVEMENT ORDER BY movement_id";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			Movement mov = new Movement();

			if( register.containsKey("movement_id") )
				mov.setId( ((BigDecimal) register.get("movement_id")).intValue() );
			
			if( register.containsKey("username") )
				mov.setUsername((String) register.get("username"));

			if( register.containsKey("lot_id") )
				mov.setLot (((BigDecimal) register.get("lot_id") ).intValue() );
			
			if( register.containsKey("amount") )
				mov.setAmount(((BigDecimal) register.get("amount")).intValue() );
			
			if( register.containsKey("date") )
				mov.setDate((Date) register.get("date") );

			result.add( mov );
		}
		
		return result;
	}
}