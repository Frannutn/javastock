package frd.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import frd.model.Product;

public class ProductManager extends JDBCManager {
	public static void createDbUserTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBPRODUCT("
				+ "PRODUCT_ID NUMERIC(5) NOT NULL, "
				+ "PRODUCTNAME VARCHAR(20) NOT NULL, "
				+ "PRODUCTDESCRIPTION VARCHAR(200) NOT NULL, "
				+ ")";

		execute( createTableSQL );
	}
	
	public static void insertProduct(int productId, String productname, String productdescription) throws SQLException{
		String insertTableSQL = "INSERT INTO DBPRODUCT"
			+ "(PRODUCT_ID, PRODUCTNAME, PRODUCTDESCRIPTION) " + "VALUES"
			+ "("+productId+", '"+productname+"', '"+productdescription+"')";
		
		executeUpdate( insertTableSQL );
	}
 
	public static void updateProduct(int productId, String productname, String productdescription) throws SQLException{
		String updateTableSQL = "UPDATE DBPRODUCT"
			+ " SET PRODUCTNAME = '"+productname+"' "
			+ " SET PRODUCTDESCRIPTION = '"+productdescription+"' "
			+ " WHERE PRODUCT_ID = "+productId;
		
		execute( updateTableSQL );

	}
	
	public static void deleteProduct(int productId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBPRODUCT WHERE PRODUCT_ID = "+productId;
		
		execute( deleteTableSQL );
	}

	
	public static List<Product> getProduct() throws SQLException{
		List<Product> result = new ArrayList<Product>();
		
		String selectTableSQL = "SELECT * from DBPRODUCT";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			//Creo el producto a partir de los datos obtenidos de la base
			Product prd = new Product();

			if( register.containsKey("product_id") )
				prd .setId( ((BigDecimal) register.get("product_id")).intValue() );
			
			if( register.containsKey("productname") )
				prd .setProductname((String) register.get("productname") );

			if( register.containsKey("productdescription") )
				prd .setProductname((String) register.get("productdescription") );

			result.add( prd  );
		}
		
		return result;
	}
}
