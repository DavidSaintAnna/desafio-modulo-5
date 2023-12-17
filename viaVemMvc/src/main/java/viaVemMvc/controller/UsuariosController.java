package viaVemMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import viaVemMvc.model.Usuarios;
import viaVemMvc.repository.UsuariosRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public ModelAndView usuarios() {
        ModelAndView modelAndView = new ModelAndView("views/usuarios/index.html");
        
        modelAndView.addObject("usuarios", usuariosRepository.findAll());
        modelAndView.addObject("usuario", new Usuarios());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("usuario") Usuarios usuario) {
        usuariosRepository.save(usuario);

        return "redirect:/usuarios";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        usuariosRepository.deleteById(id);

        return "redirect:/usuarios";
    }
}