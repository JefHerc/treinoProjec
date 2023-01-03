package br.com.treion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.treino.model.Exame;

public class ExameDao extends Dao {

	public void salvarExame(Exame exame) {
		String sql = "INSERT INTO exame (paciente, exame, obersevacao_resultado, data_exame) VALUES (?, ?, ?, ?)";

		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, exame.getPaciente());
			pstm.setString(2, exame.getExame());
			pstm.setString(3, exame.getObservacaoResultado());
			pstm.setDate(4, convertToSQLDate(exame.getDataExame()));

			pstm.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Exame> listarExames() {
		List<Exame> exames = new ArrayList<>();
		String sql = "SELECT * FROM exame";

		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				exames.add(new Exame(rst.getInt(1), rst.getString(2), rst.getString(3),
						convertSQLDateToJavaDate(rst.getDate(4)), rst.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exames;
	}

	public Exame carregarDadosExame(int codExame) {
		String sql = "SELECT * FROM exame WHERE cod_agendamento = ?";
		Dao dao = new Dao();
		Exame exame = null;
		try(Connection con = dao.getConexao(); PreparedStatement pstm = con.prepareStatement(sql)){
			pstm.setInt(1, codExame);
			ResultSet rst = pstm.executeQuery();
			if(rst.next()) {
				int cod = rst.getInt("cod_agendamento");
				String paciente = rst.getString("paciente");
				String nomeExame = rst.getString("exame");
				Date exameData = convertSQLDateToJavaDate(rst.getDate("data_exame"));
				String obs = rst.getString("obersevacao_resultado");
				exame = new Exame(cod, paciente, nomeExame, exameData, obs);

			}
	
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return exame;
	}

	public void excluirExame(int codExame) {
		String sql = "DELETE FROM exame WHERE cod_agendamento = ?";
		Dao dao = new Dao();
		try(Connection con = dao.getConexao(); PreparedStatement pstm = con.prepareStatement(sql)){
			pstm.setInt(1, codExame);
			pstm.execute();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		List<Exame> exames = new ArrayList<>();
		String sql = "SELECT * FROM exame";
		Dao dao = new Dao();
		try (Connection con = dao.getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				exames.add(
						new Exame(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(exames);

	}

	public java.sql.Date convertToSQLDate(Date date) {
		java.sql.Date mySQLDate = new java.sql.Date(date.getTime());
		return mySQLDate;
	}

	public java.util.Date convertSQLDateToJavaDate(java.sql.Date date) {
		java.util.Date myJavaDate = null;
		if (date != null) {
			myJavaDate = new java.util.Date(date.getTime());
		}
		return myJavaDate;
	}

	public void alterarExame(Exame exame) {
		String sql = "UPDATE exame SET paciente = ?, exame = ?, data_exame = ?, obersevacao_resultado = ? WHERE cod_agendamento = ?";
		Dao dao = new Dao();
		try (Connection con = dao.getConexao(); PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, exame.getPaciente());
			pstm.setString(2, exame.getExame());
			pstm.setDate(3, convertToSQLDate(exame.getDataExame()));
			pstm.setString(4, exame.getObservacaoResultado());
			pstm.setInt(5, exame.getCodAgendamento());
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	public List<Exame> pesqisarExames(String parametro) {
		List<Exame> exames = new ArrayList<>();
		String query = "SELECT * FROM exame WHERE paciente LIKE ? ORDER BY paciente";
		Dao dao = new Dao();
		try (Connection con = getConexao(); PreparedStatement pstm = con.prepareStatement(query)) {
			pstm.setString(1, "%"+parametro+"%");
			pstm.execute();
			ResultSet rst = pstm.getResultSet();

			while (rst.next()) {
				exames.add(new Exame(rst.getInt(1), rst.getString(2), rst.getString(3),
						convertSQLDateToJavaDate(rst.getDate(4)), rst.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exames;


	}
}
