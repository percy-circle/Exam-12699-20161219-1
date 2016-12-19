package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Film;
import entity.FilmExtend;
import entity.Language;
import service.CustomerService;
import service.FilmService;
import service.impl.CustomerServiceImpl;
import service.impl.FilmServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerService customerService = new CustomerServiceImpl();
	FilmService filmService = new FilmServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("login")) {
			login(request, response);
		} else if (method.equals("add")) {
			add(request, response);
		} else if (method.equals("toAdd")) {
			toAdd(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
		} else if (method.equals("update")) {
			update(request, response);
		} else if (method.equals("toupdate")) {
			toupdate(request, response);
		} else if (method.equals("findAllFilm")) {
			findAllFilm(request, response);
		}
	}

	private void toupdate(HttpServletRequest request, HttpServletResponse response) {
		Film film = new Film();
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));
		film.setFilm_id(Integer.parseInt(request.getParameter("film_id")));
		film.setLanguage_id(Integer.parseInt(request.getParameter("language")));
		if (filmService.update(film) == 1) {
			findAllFilm(request, response);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<FilmExtend> list = filmService.findAllFilm(Integer.parseInt(request.getParameter("id")));
		List<Language> languages = filmService.findAllLanguage();
		for (FilmExtend filmExtend : list) {
			request.setAttribute("film", filmExtend);
			request.setAttribute("languages", languages);
		}
		try {
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
	
			filmService.deleteFilm(id);
			findAllFilm(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {

		String first_name = request.getParameter("first_name");
		if (customerService.findCustomerByFirst_name(first_name) != 0) {
			request.getSession().setAttribute("customer", first_name);
			findAllFilm(request, response);
		} else {

				request.setAttribute("message", "登陆失败！");
				try {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	//}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		List<Language> list = filmService.findAllLanguage();
		request.setAttribute("languages", list);
		try {
			request.getRequestDispatcher("/add.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void toAdd(HttpServletRequest request, HttpServletResponse response) {
		Film film = new Film();
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));
		film.setLanguage_id(Integer.parseInt(request.getParameter("language")));
		if (filmService.addFilm(film) == 1) {
			findAllFilm(request, response);
		}
	}

	private void findAllFilm(HttpServletRequest request, HttpServletResponse response) {
		List<FilmExtend> list = filmService.findAllFilm(0);
		request.setAttribute("films", list);
		try {
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
