package viaVemMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import viaVemMvc.model.Aeroportos;
import viaVemMvc.repository.AeroportosRepository;

@Controller
@RequestMapping("/aeroportos")
public class AeroportosController {

    @Autowired
    private AeroportosRepository aeroportosRepository;

    @GetMapping
    public ModelAndView aeroportos() {
        ModelAndView modelAndView = new ModelAndView("views/aeroportos/index.html");
        
        modelAndView.addObject("aeroportos", aeroportosRepository.findAll());
        modelAndView.addObject("aeroporto", new Aeroportos());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("aeroporto") Aeroportos aeroporto) {
        aeroportosRepository.save(aeroporto);

        return "redirect:/aeroportos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable int id) {
        aeroportosRepository.deleteById(id);

        return "redirect:/aeroportos";
    }

@GetMapping("/{id}/atualizar")
public ModelAndView mostrarAtualizarForm(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("views/aeroportos/atualizar.html");
    Aeroportos aeroporto = aeroportosRepository.findById(id).orElse(null);

    modelAndView.addObject("aeroporto", aeroporto);

    return modelAndView;
}

@PostMapping("/{id}/atualizar")
public String atualizarAeroporto(@PathVariable int id, @ModelAttribute("aeroporto") Aeroportos aeroporto) {
    Aeroportos existingAeroporto = aeroportosRepository.findById(id).orElse(null);

    if (existingAeroporto != null) {
        existingAeroporto.setNome(aeroporto.getNome());
        existingAeroporto.setCidade(aeroporto.getCidade());
        existingAeroporto.setPais(aeroporto.getPais());

        aeroportosRepository.save(existingAeroporto);
    }

    return "redirect:/aeroportos";
}
    
}