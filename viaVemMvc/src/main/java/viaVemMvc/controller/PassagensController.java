package viaVemMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import viaVemMvc.model.Passagens;
import viaVemMvc.repository.PassagensRepository;

@Controller
@RequestMapping("/passagens")
public class PassagensController {

    @Autowired
    private PassagensRepository passagensRepository;

    @GetMapping
    public ModelAndView passagens() {
        ModelAndView modelAndView = new ModelAndView("views/passagens/index.html");
        
        modelAndView.addObject("passagens", passagensRepository.findAll());
        modelAndView.addObject("passagem", new Passagens());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("passagem") Passagens passagem) {
        passagensRepository.save(passagem);

        return "redirect:/passagens";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        passagensRepository.deleteById(id);

        return "redirect:/passagens";
    }
}