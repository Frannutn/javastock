package frd.test;

import java.sql.SQLException;
//import java.util.Date;

import frd.db.ProductManager;
import frd.model.Product;

public class TestDBProduct {
	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST DBPRODUCT ***********");
		try{
			//creo la tabla dbProduct
			ProductManager.createDbProductTable();
			System.out.println( "Tabla Product Creada!" );
			
			//cargo dos productos
			ProductManager.insertProduct(1, "Product 1", "admin");
			ProductManager.insertProduct(2, "Product 2", "admin");
			System.out.println( "Dos productos creados!" );

			//obtengo los productos de la bd
			System.out.println( "Listando productos:" );
			for( Product prd : ProductManager.getProduct() ){
				System.out.println( prd );
			}

			//modificando productos
			ProductManager.updateProduct(2, "Product 2 Modificado", "admin");
			System.out.println( "Producto 2 modificado!" );
			
			//obtengo los Productos de la bd
			System.out.println( "Listando Productos:" );
			for( Product prd : ProductManager.getProduct() ){
				System.out.println( prd );
			}

			//borrar Producto
			ProductManager.deleteProduct(1);
			System.out.println( "Producto 1 eliminado!" );
			
			//obtengo los Productos de la bd
			System.out.println( "Listando Productos:" );
			for( Product prd : ProductManager.getProduct() ){
				System.out.println( prd );
			}

		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBPRODUCT ***********");
	}
}
