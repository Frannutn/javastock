package frd.test;

import java.sql.SQLException;
import java.util.Date;

import frd.db.MovementManager;
import frd.model.Movement;

public class TestDBMovement {
	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST MOVEMENT ***********");
		try{
			
			MovementManager.createDbMovementTable();
			System.out.println( "Tabla de Movimientos Creada!" );

			MovementManager.insertMovement(1, 1, "admin1", new Date(), 10);
			MovementManager.insertMovement(2, 1, "admin2",new Date(), 30);
			System.out.println( "Dos Movimientos creados!" );

			System.out.println( "Listando Movimientos:" );
			for( Movement m : MovementManager.getMovements() ){
				System.out.println( m );
			}

			MovementManager.updateMovement(2, "admin modif", 11);
			System.out.println( "Movimiento 2 modificado!" );
			
			System.out.println( "Listando Movimientos:" );
			for( Movement m : MovementManager.getMovements() ){
				System.out.println( m );
			}

			MovementManager.deleteMovement(1);
			System.out.println( "Movimiento 1 eliminado!" );
			
			System.out.println( "Listando Movimientos:" );
			for( Movement m : MovementManager.getMovements() ){
				System.out.println( m );
			}

		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBPRODUCT ***********");
	}
}
