package br.com.treion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private Connection conexao = null;
	
	public Dao() {
		conectar();
	}
	
	public void conectar() {
		try {
			conexao =  DriverManager.getConnection("jdbc:mysql://localhost/avaliacao?useTimezone=true&serverTimezone=UTC", 
					"root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() throws SQLException {
		if (conexao == null || conexao.isClosed()) {
			conectar();
		}
		return conexao;
	}
	
//	public static void main(String[] args) {
//		try {
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/avaliacao?useTimezone=true&serverTimezone=UTC", 
//					"root", "root");
//			System.out.println("funciona");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}


