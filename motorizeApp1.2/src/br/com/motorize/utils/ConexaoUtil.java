package br.com.motorize.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Classe Util para conexão rapida com o BANCO speds
 * */
public class ConexaoUtil  {

	private static ConexaoUtil conexaoUtil ;

	/*
	 * Retorna uma nova conexão caso não haja nenhuma intancia com o banco de dados ;
	 * */
		public static ConexaoUtil getInstance(){
			if (conexaoUtil == null ){
				conexaoUtil = new ConexaoUtil();
			}
			return conexaoUtil ; 
		}

		/*
		 * Retorna conexão com o banco de dados;
		 * */
		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			//jpmysql09@
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/motorize", "root", "");		}
		//Jpmysql09
		
		public static void main(String[] args) {
			try {
				ConexaoUtil.getConnection();
				System.out.println("conexao OKá");

			} catch (ClassNotFoundException e) {
				System.out.println("DRIVE !!!");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("conexao não entrou!!!");
				e.printStackTrace();
			}
		}
}
