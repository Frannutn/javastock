package frd.app;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import frd.db.LotManager;
import frd.model.Lot;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;

public class LotUI {

	public static void showAll() {
		System.out.println( "=================================" );
		System.err.println( "IDLOT | IDPRODUCT | CREATEDATE | DUEDATE | INITIALAMOUNT | CURRENTAMOUNT" );
		try {
			for( Lot l : LotManager.getLots() ){
				System.out.println(l.getidLot() + " | " + l.getidProduct() + " | " + l.getCreateDate() + " | " + l.getDueDate() + " | " + l.getInitialAmount() + " | " + l.getCurrentAmount());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println( "=================================" );
	}

	public static void add(Scanner scanIn)  {
//	public static void add(Scanner scanIn) throws ParseException {		
		//SimpleDateFormat formateador=new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println( "=>AGREGAR LOTE" );
		System.out.println( ">Ingrese el id del lote:" );
		String idlote = scanIn.nextLine();
		System.out.println( ">Ingrese el id del producto:" );
		String idprod = scanIn.nextLine();
		//System.out.println( ">Ingrese el la fecha de vencimiento del lote (ej: 20/08/2013):" );
		//String duedate = scanIn.nextLine();
		System.out.println( ">Ingrese la cantidad inicial:" );
		String initamount = scanIn.nextLine();
		try {
			LotManager.insertLot( Integer.parseInt(idlote), Integer.parseInt(idprod), new Date(), new Date(), Integer.parseInt(initamount), Integer.parseInt(initamount) );
//			LotManager.insertLot( Integer.parseInt(idlote), Integer.parseInt(idprod), new Date(), formateador.parse(duedate), Integer.parseInt(initamount), Integer.parseInt(initamount) );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al guardar los datos en la base.");
		} //catch (ParseException e) {
		//System.err.println("La cadena de texto no se puede convertir en fecha.");
		//}
		System.out.println( "=================================" );
	}
	
	public static void del(Scanner scanIn) {
		System.out.println( "=>BORRAR LOTE" );
		System.out.println( ">Ingrese el ID:" );
		String idLot = scanIn.nextLine();
		try {
			LotManager.deleteLot( Integer.parseInt(idLot) );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al eliminar el lote en la base.");
		}
		System.out.println( "=================================" );
	}
	public static void delAll() {
		try {
			LotManager.delAll();		
		} catch (SQLException e) {
				System.err.println("Error al eliminar la tabla dbMovement");
		}
		System.out.println("=>SE HA BORRADO TODA LA TABLA DBMOVEMENT");
	}	
}
