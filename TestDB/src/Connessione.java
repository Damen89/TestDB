import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connessione {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/my_shop";
		String username = "root";
		String password = "";

		try {
			Connection miaConn = DriverManager.getConnection(dbUrl, username, password);

			//Statement mioStat =	miaConn.createStatement();
			
//			String sql = "select* from prodotti where id_cat=? and prezzo < ?"; //al posto del numero metto il ?
			String sql = "delete from prodotti where id_cat=? and prezzo < ?"; //al posto del numero metto il ?
			PreparedStatement statement = miaConn.prepareStatement(sql);
			
			//setto i parametri
			statement.setInt(1, 3);
			statement.setDouble(2, 20.00);
			
			
			//ResultSet rs = statement.executeQuery(); //quando eseguo una query lascio il while
			
			statement.executeUpdate(); 	//eseguendo un update non ho necessità di fare il while
			
			
//			
//			while (rs.next()) {
//				//in questo caso devo cominciare a mappare il database con le classi Java perché in base al dato che ho mi adeguo 
//				System.out.println(rs.getInt("id_cat"));
//				System.out.println(rs.getDouble(6));  //questo è l'indice della colonna dove si trovano i prezzi nella tabella prodotti
//				
//			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		

		
		
	}

}
