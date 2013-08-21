package frd.test;

import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;

import frd.db.LotManager;
import frd.model.Lot;

public class TestDBLot {
//	public static void main(String[] args) throws ParseException{
	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST LOT ***********");
		//SimpleDateFormat formateador = new SimpleDateFormat("yyyy/mm/dd");
		try{
			
			LotManager.createDbLotTable();
			System.out.println( "Tabla de Lotes Creada!" );

			//LotManager.insertLot(1, 1, new Date(), formateador.parse("01/08/2013"), 10, 10);
			//LotManager.insertLot(2, 2, new Date(), formateador.parse("10/08/2013"),10,10);
			LotManager.insertLot(1, 1, new Date(), new Date(), 10, 10);
			LotManager.insertLot(2, 2, new Date(), new Date(),10,10);
			System.out.println( "Dos Lotes creados!" );
			//System.out.println(formateador.parse("10/08/2013")); 

			System.out.println( "Listando Lotes:" );
			for( Lot l : LotManager.getLots() ){
				System.out.println( l );
			}
			
			//LotManager.updateLot(2, 1, new Date(), formateador.parse("01/05/2014"), 20, 10);
			LotManager.updateLot(2, 1, new Date(), new Date(), 20, 10);
			System.out.println( "Lote 2 modificado!" );
			
			System.out.println( "Listando Lotes:" );
			for( Lot l : LotManager.getLots() ){
				System.out.println( l );
			}

			LotManager.deleteLot(1);
			System.out.println( "Lote 1 eliminado!" );
			
			System.out.println( "Listando Lotes:" );
			for( Lot l : LotManager.getLots() ){
				System.out.println( l );
			}

		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBLOT ***********");
	}
}
