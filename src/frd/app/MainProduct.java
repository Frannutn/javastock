package frd.app;

import java.util.Scanner;

public class MainProduct {
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("*********** Iniciando ***********");
		System.out.println("q:salir, p:listar productos, p-add:agregar productos, p-del:borrar producto");
		
		String response = scanIn.nextLine();
		while( !"q".equalsIgnoreCase(response) ){

			if( "p".equalsIgnoreCase(response) ){
				ProductUI.showAll();
			}
			
			if( "p-add".equalsIgnoreCase(response) ){
				ProductUI.add( scanIn );
			}
			
			if( "p-del".equalsIgnoreCase(response) ){
				ProductUI.del( scanIn );
			}
			
			System.out.println(">");
			response = scanIn.nextLine();
		}
		
        System.out.println("*********** Fin de app ***********");
	}
}
