package net.cine.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cine.app.model.Perfil;
import net.cine.app.model.Usuario;
import net.cine.app.service.IPerfilesService;
import net.cine.app.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private IUsuariosService serviceUsuarios;

	@Autowired
	private IPerfilesService servicePerfiles;


	@GetMapping(value = "/index")
	public String index(Model model) {

		model.addAttribute("usuarios", serviceUsuarios.buscarTodos());
		model.addAttribute("perfiles", servicePerfiles.buscarTodos());

		return "usuarios/listUsuarios";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Usuario usuario) {
		return "usuarios/formUsuario";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil, Model model) {


		  
		  String encriptado = encoder.encode(usuario.getPwd()); 
		  Perfil perfilTmp = new Perfil();
		  
		  if(usuario.getId()==0) {
		  
		  usuario.setPwd(encriptado); 
		  serviceUsuarios.guardar(usuario);
	
		  
          perfilTmp.setCuenta(usuario.getCuenta()); 
		  perfilTmp.setPerfil(perfil);
		  perfilTmp.setIdUsuario(usuario.getId());
		  servicePerfiles.guardar(perfilTmp);
		  
		  return "redirect:/usuarios/index";

		  }
		  
		  usuario.setPwd(encriptado);
		  serviceUsuarios.guardar(usuario);
          servicePerfiles.Actualizar(usuario.getId(), usuario.getCuenta(), perfil);
		  
		  

		return "redirect:/usuarios/index";

	}

	@GetMapping(value = "/edit/{idUsuario}/{idPerfil}")
	public String editar(@PathVariable("idUsuario") int idUsuario,@PathVariable("idPerfil") int idPerfil, Model model) {

		model.addAttribute("usuario", serviceUsuarios.buscarPorId(idUsuario));
		model.addAttribute("perfil", servicePerfiles.buscarPorId(idPerfil));
		return "usuarios/formUsuario";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id, RedirectAttributes attribute) {

		serviceUsuarios.eliminar(id);

		attribute.addFlashAttribute("msg", "El usuario ha sido eliminado exitosamente!");
		return "redirect:/usuarios/index";
	}

}
