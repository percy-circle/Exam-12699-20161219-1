package service.impl;

import java.util.List;

import dao.FilmDao;
import dao.impl.FilmDaoImpl;
import entity.Film;
import entity.FilmExtend;
import entity.Language;
import service.FilmService;

public class FilmServiceImpl implements FilmService {
     FilmDao filmDao=new FilmDaoImpl();
	public List<FilmExtend> findAllFilm(int id) {
		// TODO Auto-generated method stub
		return filmDao.findAllFilm(id);
	}
	public List<Language> findAllLanguage() {
		// TODO Auto-generated method stub
		return filmDao.findAllLanguage();
	}
	public int addFilm(Film film) {
		return filmDao.addFilm(film);
	}
	public int deleteFilm(int id) {
		// TODO Auto-generated method stub
		return filmDao.deleteFilm(id);
	}
	public int update(Film film) {
		// TODO Auto-generated method stub
		return filmDao.update(film);
	}

}
