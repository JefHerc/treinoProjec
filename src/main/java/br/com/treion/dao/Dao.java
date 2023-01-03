package br.com.treion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private Connection conexao = null;
	private static boolean bancoNaoInicializado = true;

	public Dao() {
		conectar();
	}

	public void conectar() {
		StringBuilder url = new StringBuilder("jdbc:h2:mem:treino;").append("DB_CLOSE_DELAY=-1;")
				.append("DATABASE_TO_UPPER=false;");

		if (bancoNaoInicializado) {
			url.append("INIT=runscript from 'classpath:Inicializar-H2.sql';");
			bancoNaoInicializado = false;
		}

		try {
			Class.forName("org.h2.Driver");
			conexao = DriverManager.getConnection(url.toString());
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() throws SQLException {
		if (conexao == null || conexao.isClosed()) {
			conectar();
		}
		return conexao;
	}
}
