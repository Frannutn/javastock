package frd.app;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import frd.db.MovementManager;
import frd.model.Movement;


public class MovementUI {

	public static void showAll() {
		System.out.println( "=================================" );
		System.err.println( "ID_MOV | ID_LOT | DATE | USERNAME | AMOUNT" );
		try {
			for( Movement m : MovementManager.getMovements() ){
				System.out.println( m.getId() + " | " + m.getLot() + " | " + m.getDate()  + " | " + m.getUsername() + " | " + m.getAmount() );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println( "=================================" );
	}
//el id del movimiento lo saco con una funcion getlastid o algo asi, por ahora hice uqe lo cargue por 
//teclado, preguntar a serguei
	public static void add(Scanner scanIn) {
		System.out.println( "=>AGREGAR MOVIMIENTO" );
		System.out.println( ">Ingrese el ID del Movimiento:" );
		String idMOV = scanIn.nextLine();
		System.out.println( ">Ingrese el ID del Lote:" );
		String idLOT = scanIn.nextLine();
		System.out.println( ">Ingrese el nombre de usuario:" );
		String username = scanIn.nextLine();
		System.out.println( ">Ingrese la cantidad:" );
		String amount = scanIn.nextLine();
		try {
			MovementManager.insertMovement(Integer.parseInt(idMOV), Integer.parseInt(idLOT), username, new Date(),  Integer.parseInt(amount) );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al guardar los datos en la base.");
		}
		System.out.println( "=================================" );
	}

	public static void del(Scanner scanIn) {
		System.out.println( "=>BORRAR MOVIMIENTO" );
		System.out.println( ">Ingrese el ID:" );
		String id = scanIn.nextLine();
		try {
			MovementManager.deleteMovement( Integer.parseInt(id) );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al eliminar el usuario en la base.");
		}
		System.out.println( "=================================" );
	}
	public static void delAll() {
		try {
			MovementManager.delAll();		
		} catch (SQLException e) {
				System.err.println("Error al eliminar la tabla dbMovement");
		}
		System.out.println("=>SE HA BORRADO TODA LA TABLA DBMOVEMENT");
	}		
}
