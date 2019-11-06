package net.cine.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cine.app.model.Noticia;
import net.cine.app.service.INoticiasService;

@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {

	@Autowired
	private INoticiasService serviceNoticias;

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Noticia> listaNoticias = serviceNoticias.buscarTodas();
		model.addAttribute("noticias", listaNoticias);
		return "noticias/listNoticias";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Noticia noticia) {
		return "noticias/formNoticia";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Noticia noticia, RedirectAttributes attribute, BindingResult result) {

		if (result.hasErrors()) {
			attribute.addFlashAttribute("msg", "Ha habido errores.");
			return "noticias/formNoticia";

		}
		attribute.addFlashAttribute("msg", "La noticia fue guardada exitosamente");
		serviceNoticias.insertar(noticia);

		return "redirect:/noticias/index";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attribute) {
		serviceNoticias.eliminar(idNoticia);
		attribute.addFlashAttribute("msg", "La noticia fue eliminada exitosamente");

		return "redirect:/noticias/index";
	}

	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idNoticia, Model model) {
		Noticia noticia = serviceNoticias.buscarPorId(idNoticia);
		model.addAttribute("noticia", noticia);
		return "noticias/formNoticia";
	}

}
