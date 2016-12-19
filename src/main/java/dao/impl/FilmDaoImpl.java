package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FilmDao;
import entity.Film;
import entity.FilmExtend;
import entity.Language;
import util.JdbcUtil;

public class FilmDaoImpl implements FilmDao {

	public List<FilmExtend> findAllFilm(int id) {
		List<FilmExtend> list = new ArrayList<FilmExtend>();
		Connection connection = JdbcUtil.getConnection();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"select film.film_id,film.title,film.description,l.name from language as l,film where l.language_id=film.language_id");
		if (id != 0) {
			stringBuilder.append(" and film.film_id=?");
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString());
			if (id != 0) {
				preparedStatement.setInt(1, id);
			}
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				FilmExtend film = new FilmExtend();
				film.setFilm_id(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setDescription(rs.getString(3));
				film.setLanguage(rs.getString(4));
				list.add(film);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Language> findAllLanguage() {
		List<Language> list = new ArrayList<Language>();
		Connection connection = JdbcUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from language");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Language language = new Language();
				language.setLanguage_id(rs.getInt(1));
				language.setName(rs.getString(2));
				language.setLast_update(rs.getDate(3));
				list.add(language);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int addFilm(Film film) {
		Connection connection = JdbcUtil.getConnection();
		int result = 0;
		String sql = "insert into film (title,description,language_id) values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.setString(2, film.getDescription());
			preparedStatement.setInt(3, film.getLanguage_id());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteFilm(int id) {

		Connection connection = JdbcUtil.getConnection();
		int result = 0;
		// 没写级联删除
		String sql4 = "delete from film where film_id=?";
		try {
			PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
			result = preparedStatement4.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

	public int update(Film film) {
		Connection connection = JdbcUtil.getConnection();
		int result = 0;
		String sql = "update film set title=?,description=?,language_id=? where film_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.setString(2, film.getDescription());
			preparedStatement.setInt(3, film.getLanguage_id());
			preparedStatement.setInt(4, film.getFilm_id());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}
}
