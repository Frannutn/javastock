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
import frd.model.Lot;

public class LotManager extends JDBCManager {
	public static void createDbLotTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBLOT("
				+ "LOTID NUMERIC(5) NOT NULL, "
				+ "PRODID NUMERIC(5) NOT NULL, "
				+ "CREATEDATE DATE NOT NULL, "
				+ "DUEDATE DATE NOT NULL, "
				+ "INITIALAMOUNT NUMERIC(10) NOT NULL, "
				+ "CURRENTAMOUNT NUMERIC(10) NOT NULL, " + "PRIMARY KEY (LOTID) "
				+ ")";
		execute( createTableSQL );
	}
	public static void insertLot(int lotid, int prodid, Date createdate, Date duedate, int initamount, int currentamount) throws SQLException{
//		String insertTableSQL = "INSERT INTO DBLOT"
//			+ "(LOTID, PRODID, CREATEDATE, DUEDATE, INITIALAMOUNT, CURRENTAMOUNT) " + "VALUES"
//			+ "("+lotid+", "+prodid+", " + "to_date('"
//			+ dateFormat.format(createdate.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'),"
//			+ ""+duedate+","+initamount+", "+currentamount+")";	
		String insertTableSQL = "INSERT INTO DBLOT"
				+ "(LOTID, PRODID, CREATEDATE, DUEDATE, INITIALAMOUNT, CURRENTAMOUNT) " + "VALUES"
				+ "("+lotid+", "+prodid+", " + "to_date('"
				+ dateFormat.format(createdate.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'),"
				+ "to_date('"
				+ dateFormat.format(createdate.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'), "+initamount+", "+currentamount+")";	
		executeUpdate( insertTableSQL );
	}
	public static void updateLot(int idlot, int idprod,Date createdate, Date duedate, int initamount, int currentamount) throws SQLException{
		String updateTableSQL = "UPDATE DBLOT"
			+ " SET CREATEDATE = "+createdate+" " 
			//+ ",DUEDATE="+duedate+" " 
			//+ ",INITIALAMOUNT="+initamount+" "
			+ ",CURRENTALAMOUNT="+currentamount+" "
			+ " WHERE LOTID = "+idlot+" AND PRODID="+idprod;
		execute( updateTableSQL );
	}
	public static void deleteLot(int lotId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBLOT WHERE LOTID = "+lotId;
		
		execute( deleteTableSQL );
	}
	public static void  delAll() throws SQLException{
		String deleteAllTableSQL = "DELETE FROM DBLOT";
		
		execute( deleteAllTableSQL );
	}
	public static List<Lot> getLots() throws SQLException{
		List<Lot> result = new ArrayList<Lot>();
		String selectTableSQL = "SELECT * FROM DBLOT ORDER BY LOTID";
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			Lot l = new Lot();
			if( register.containsKey("lotid") )
				l.setidLot( ((BigDecimal) register.get("lotid")).intValue() );
			
			if( register.containsKey("prodid") )
				l.setidProduct( ((BigDecimal) register.get("prodid")).intValue() );
			
			if( register.containsKey("createdate") )
				l.setCreateDate((Date) register.get("createdate") );
			
			if( register.containsKey("duedate") )
				l.setDueDate((Date) register.get("duedate") );

			if( register.containsKey("initialamount") )
				l.setInitialAmount( ((BigDecimal) register.get("initialamount")).intValue() );
			
			if( register.containsKey("currentamount") )
				l.setCurrentAmount( ((BigDecimal) register.get("currentamount")).intValue() );
			
			result.add( l );
		}
		return result;
	}
}