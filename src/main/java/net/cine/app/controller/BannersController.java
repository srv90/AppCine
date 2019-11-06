package net.cine.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cine.app.model.Banner;
import net.cine.app.service.IBannersService;
import net.cine.app.util.Metodos;

@Controller
@RequestMapping("/banners/")
public class BannersController {

	@Autowired
	private IBannersService serviceBanner;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		model.addAttribute("banners", serviceBanner.buscarTodos());
		return "banners/listBanners";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Banner banner) {
		return "banners/formBanner";
	}

	@PostMapping("/save")
	public String guardar(Banner banner, BindingResult result, @RequestParam("archivoImagen") MultipartFile multiPart,
			HttpServletRequest request, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return "banners/formBanner";

		}
		if (!multiPart.isEmpty()) {
			String nombreImagen = Metodos.guardarImagen(multiPart, request);
			banner.setArchivo(nombreImagen);

		}
		attributes.addFlashAttribute("mensaje", "El banner ha sido guardado exitosamente!");
		serviceBanner.insertar(banner);
		return "redirect:/banners/index";
	}

	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idBanner, Model model) {
		Banner banner = serviceBanner.buscarPorId(idBanner);
		model.addAttribute("banner", banner);
		return "banners/formBanner";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
		serviceBanner.eliminar(idBanner);
		attributes.addFlashAttribute("msg", "El banner fue eliminado!");
		return "redirect:/banners/index";
	}
}
