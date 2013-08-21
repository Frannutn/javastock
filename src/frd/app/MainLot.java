package frd.app;

import java.text.ParseException;
import java.util.Scanner;

public class MainLot {
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args) throws ParseException{
		System.out.println("*********** Iniciando ***********");
		System.out.println("q:salir, l:listar lotes, l-add:agregar lote, l-del:borrar lote del-all:borrar todo el contenido de la tabla");
		
		String response = scanIn.nextLine();
		while( !"q".equalsIgnoreCase(response) ){

			if( "l".equalsIgnoreCase(response) ){
				LotUI.showAll();
			}
			
			if( "l-add".equalsIgnoreCase(response) ){
				LotUI.add( scanIn );
			}
			
			if( "l-del".equalsIgnoreCase(response) ){
				LotUI.del( scanIn );
			}
			
			if( "del-all".equalsIgnoreCase(response) ){
				LotUI.delAll();
			}
			
			System.out.println(">");
			response = scanIn.nextLine();
		}
		
        System.out.println("*********** Fin de app ***********");
	}
}
