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

import viaVemMvc.model.Aeroportos;
import viaVemMvc.model.Passagens;
import viaVemMvc.repository.AeroportosRepository;
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
    @GetMapping("/{id}/atualizar")
    public ModelAndView atualizarForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("views/passagens/update.html");
        Passagens passagem = passagensRepository.findById(id).orElse(null);
        
        modelAndView.addObject("passagem", passagem);

        return modelAndView;
    }

    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable int id, @ModelAttribute("passagem") Passagens passagem) {
        passagem.setId(id); // Set ID to ensure the correct entity is updated
        passagensRepository.save(passagem);

        return "redirect:/passagens";
    }
}