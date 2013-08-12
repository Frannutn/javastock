package frd.app;

import java.util.Scanner;

public class MainMovement {
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("*********** Iniciando ***********");
		System.out.println("q:salir, m:listar movimientos, m-add:agregar movimientos, m-del:borrar movimiento del-all:borrar todo el contenido de la tabla");
		
		String response = scanIn.nextLine();
		while( !"q".equalsIgnoreCase(response) ){

			if( "m".equalsIgnoreCase(response) ){
				MovementUI.showAll();
			}
			
			if( "m-add".equalsIgnoreCase(response) ){
				MovementUI.add( scanIn );
			}
			
			if( "m-del".equalsIgnoreCase(response) ){
				MovementUI.del( scanIn );
			}
			
			if( "del-all".equalsIgnoreCase(response) ){
				MovementUI.delAll();
			}
			
			System.out.println(">");
			response = scanIn.nextLine();
		}
		
        System.out.println("*********** Fin de app ***********");
	}
}
