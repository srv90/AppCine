package net.cine.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.cine.app.model.Banner;
import net.cine.app.model.Contacto;
import net.cine.app.model.Horario;
import net.cine.app.model.Noticia;
import net.cine.app.model.Pelicula;
import net.cine.app.service.IBannersService;
import net.cine.app.service.IHorariosService;
import net.cine.app.service.INoticiasService;
import net.cine.app.service.IPeliculasService;
import net.cine.app.util.Metodos;

@Controller
public class HomeController {

	@Autowired
	private IPeliculasService servicePelicula;

	@Autowired
	private IBannersService serviceBanner;

	@Autowired
	private IHorariosService serviceHorario;

	@Autowired
	private INoticiasService serviceNoticia;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");

	private boolean primerAcceso = true;

	@RequestMapping(value = "/formLogin")
	public String mostrarLogin() {
		return "formLogin";
	}

	
	@RequestMapping(value = "/contacto")
	public String mostrarContacto(@ModelAttribute Contacto contacto) {
		return "formContacto";
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		if (primerAcceso) {
			serviceHorario.insertarHorarios();// Metodo para ingresar horarios cada vez que se corra el proyecto
			primerAcceso = false;
			System.out.println(primerAcceso);
		}
		try {
			Date fechaSinHora = dateFormat.parse(dateFormat.format(new Date()));
			List<String> listaFechas = Metodos.getNextDays(4);
			List<Pelicula> peliculas = servicePelicula.buscarPorFecha(fechaSinHora);
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
			model.addAttribute("peliculas", peliculas);
			System.out.println(primerAcceso);

		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {

		try {
			Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));
			List<String> listaFechas = Metodos.getNextDays(4);
			List<Pelicula> peliculas = servicePelicula.buscarPorFecha(fechaSinHora);
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
			model.addAttribute("peliculas", peliculas);
			return "home";
		} catch (ParseException e) {
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		return "home";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("id") int idPelicula, @RequestParam("fecha") Date fecha) {

		List<Horario> horarios = serviceHorario.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", servicePelicula.buscarPorId(idPelicula));

		return "detail";
	}

	@ModelAttribute("noticias")
	public List<Noticia> buscarUltimas3Noticias() {

		return serviceNoticia.buscarPrimeras3Activas();
	}

	@ModelAttribute("banners")
	public List<Banner> buscarBanners() {

		return serviceBanner.buscarActivos();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
