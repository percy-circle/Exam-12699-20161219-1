package service;

import java.util.List;

import entity.Film;
import entity.FilmExtend;
import entity.Language;

public interface FilmService {
	// 查询所有的Film
	public List<FilmExtend> findAllFilm(int id);

	// 查询所有的语言
	public List<Language> findAllLanguage();

	// 添加film
	public int addFilm(Film film);
	//删除film
	public int deleteFilm(int id);
	//更新film
	public int update(Film film);
	
}
