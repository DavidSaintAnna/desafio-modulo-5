package viaVemMvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import viaVemMvc.model.Passagens;
import viaVemMvc.model.Usuarios;
import viaVemMvc.repository.PassagensRepository;
import viaVemMvc.repository.UsuariosRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	 @Autowired
	    private UsuariosRepository usuariosRepository;

	   @Autowired
	    private PassagensRepository passagensRepository;

	    @GetMapping
	    public ModelAndView usuarios() {
	        ModelAndView modelAndView = new ModelAndView("views/usuarios/index.html");
	        
	        modelAndView.addObject("usuarios", usuariosRepository.findAll());
	        modelAndView.addObject("usuario", new Usuarios());
	        modelAndView.addObject("passagensList", passagensRepository.findAll());

	        return modelAndView;
	    }

	    @PostMapping("/cadastrar")
	    public String cadastrar(@ModelAttribute("usuario") Usuarios usuario, @RequestParam("passagem_id") int passagemId) {
	        Passagens selectedPassagem = passagensRepository.findById(passagemId).orElse(null);
	        usuario.setPassagens(selectedPassagem);
	        usuariosRepository.save(usuario);

	        return "redirect:/usuarios";
	    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        usuariosRepository.deleteById(id);

        return "redirect:/usuarios";
    }
    @GetMapping("/{id}/atualizar")
    public ModelAndView atualizarForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("views/usuarios/update.html");
        Usuarios usuario = usuariosRepository.findById(id).orElse(null);
        
        modelAndView.addObject("usuario", usuario);

        return modelAndView;
    }

    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable int id, @ModelAttribute("usuario") Usuarios usuario) {
        usuario.setId(id); // Set ID to ensure the correct entity is updated
        usuariosRepository.save(usuario);

        return "redirect:/usuarios";
    }
    
}