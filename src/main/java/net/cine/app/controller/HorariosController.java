package net.cine.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cine.app.model.Horario;
import net.cine.app.model.Pelicula;
import net.cine.app.service.IHorariosService;
import net.cine.app.service.IPeliculasService;

@Controller
@RequestMapping(value = "/horarios")
public class HorariosController {

	@Autowired
	private IPeliculasService peliculasService;

	@Autowired
	private IHorariosService serviceHorarios;

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Horario> listaHorarios = serviceHorarios.buscarTodos();
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario) {
		return "horarios/formHorario";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			List<Pelicula> listaPeliculas = peliculasService.buscarActivas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}

		serviceHorarios.insertar(horario);
		attributes.addFlashAttribute("msg", "El horario fue guardado!");
		return "redirect:/horarios/indexPaginate?page=0";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model,
			@PageableDefault(sort = { "fecha", "hora" }, direction = Sort.Direction.ASC, page = 1) Pageable page) {
		Page<Horario> listaHorarios = serviceHorarios.buscarTodos(page);

		System.out.println("elementos: " + listaHorarios.getTotalElements());
		System.out.println("previo " + listaHorarios.isFirst());

		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}

	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idHorario, Model model) {
		Horario horario = serviceHorarios.buscarPorId(idHorario);
		model.addAttribute("horario", horario);
		return "horarios/formHorario";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario, RedirectAttributes attributes) {
		serviceHorarios.eliminar(idHorario);
		attributes.addFlashAttribute("msg", "El horario fue eliminado!");
		// return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate?page=0";
	}

	@ModelAttribute("peliculas")
	public List<Pelicula> getPeliculas() {
		return peliculasService.buscarActivas();
	}

	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
