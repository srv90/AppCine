package net.cine.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cine.app.model.Pelicula;
import net.cine.app.service.IPeliculasService;
import net.cine.app.util.Metodos;

@Controller
@RequestMapping(value = "/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService servicePelicula;

	@ModelAttribute(value = "generos")
	public List<String> getGeneros() {

		return servicePelicula.buscarGeneros();

	}

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {

		model.addAttribute("peliculas", servicePelicula.buscarTodas());
		return "peliculas/listPeliculas";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Pelicula pelicula) {
		return "peliculas/formPelicula";
	}

	@PostMapping(value = "/save")
	public String guardar(Model model, @ModelAttribute Pelicula pelicula, BindingResult result,
			RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "peliculas/formPelicula";

		}
		if (!multiPart.isEmpty()) {
			String nombreImagen = Metodos.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}

		servicePelicula.insertar(pelicula);
		attributes.addFlashAttribute("msg", "Registro guardado exitosamente");
		return "redirect:/peliculas/indexPaginate?page=0";

	}

	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model) {

		Pelicula pelicula = servicePelicula.buscarPorId(idPelicula);
		model.addAttribute("pelicula", pelicula);
		return "peliculas/formPelicula";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula, Model model, RedirectAttributes attribute) {

		servicePelicula.eliminar(idPelicula);
		attribute.addFlashAttribute("msg", "El registro fue eliminado exitosamente");
		return "redirect:/peliculas/indexPaginate?page=0";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = servicePelicula.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
