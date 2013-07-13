package frd.app;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import frd.db.ProductManager;
import frd.model.Product;

public class ProductUI {

	public static void showAll() {
		System.out.println( "=================================" );
		System.err.println( "ID | NAME | DESCRIPTION" );
		try {
			for( Product p : ProductManager.getProduct() ){
				System.out.println( p.getId() + " | " + p.getProductname() + " | " + p.getProductdescription() );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println( "=================================" );
	}

	public static void add(Scanner scanIn) {
		System.out.println( "=>AGREGAR PRODUCTO" );
		System.out.println( ">Ingrese el ID:" );
		String id = scanIn.nextLine();
		System.out.println( ">Ingrese el NOMBRE:" );
		String name = scanIn.nextLine();
		System.out.println( ">Ingrese el DESCRIPCION:" );
		String description = scanIn.nextLine();
		try {
			ProductManager.insertProduct( Integer.parseInt(id), name, description );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al guardar los datos en la base.");
		}
		System.out.println( "=================================" );
	}

	public static void del(Scanner scanIn) {
		System.out.println( "=>BORRAR PRODUCT" );
		System.out.println( ">Ingrese el ID:" );
		String id = scanIn.nextLine();
		try {
			ProductManager.deleteProduct( Integer.parseInt(id) );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al eliminar el usuario en la base.");
		}
		System.out.println( "=================================" );
	}

}
