package atlantic.spprev.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private static String server = "10.32.249.10";
	private static String porta = "1521";
	private static String banco = "PDBSPPREVDSV.br1.ocm.s7071866.oraclecloudatcustomer.com";
	private static String user = "ljunior";
	private static String pass = "lrosadsv";

	private static Connection con;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":" + porta + "/" + banco, user, pass);
		System.out.println("Conectou!!");
		return con;
	}
}
