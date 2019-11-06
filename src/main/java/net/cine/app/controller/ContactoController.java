package net.cine.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cine.app.model.Contacto;
import net.cine.app.service.IPeliculasService;

@Controller
public class ContactoController {

	@Autowired
	private IPeliculasService servicePelicula;

	@GetMapping(value = "/contacto")
	public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model) {
		model.addAttribute("generos", servicePelicula.buscarGeneros());
		model.addAttribute("notificaciones", this.tipoNotificaciones());
		return "formContacto";

	}

	@PostMapping(value = "/contacto")
	public String guardar(@ModelAttribute Contacto contacto, Model model, RedirectAttributes attribute) {
		attribute.addFlashAttribute("msg", "El formulario ha sido enviado exitosamente! Gracias por participar.");
		model.addAttribute("generos", servicePelicula.buscarGeneros());

		return "redirect:/contacto";
	}


	
	private List<String> tipoNotificaciones() {

		List<String> tipos = new LinkedList<>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
		tipos.add("Concursos");

		return tipos;
	}
}
