package com.example.ApiRestThyleaf.Controller;

import com.example.ApiRestThyleaf.Service.PaisService;
import com.example.ApiRestThyleaf.Entity.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaisController {

    private final PaisService service;

    public PaisController(PaisService service) {
        this.service = service;
    }

    @GetMapping("/paises")
    public String listCountries(@RequestParam(required = false) String continente,
                                @RequestParam(required = false) String sortBy,
                                Model model) {
        List<Pais> ListaPaises = service.listPaises(continente, sortBy);
        model.addAttribute("paises", ListaPaises);
        model.addAttribute("continente", continente);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("pais", new Pais()); // Objeto para o formulário de adição
        return "paises";
    }

    @PostMapping("/paises/adicionar")
    public String addCountry(Pais pais) {
        service.save(pais);
        return "redirect:/paises";
    }

    @GetMapping("/paises/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Pais pais = service.findById(id).orElseThrow(() -> new IllegalArgumentException("País inválido com Id:" + id));
        model.addAttribute("pais", pais);
        return "editar-pais";
    }

    @PostMapping("/paises/editar/{id}")
    public String updateCountry(@PathVariable Long id, Pais pais) {
        pais.setId(id);
        service.save(pais);
        return "redirect:/paises";
    }

    @GetMapping("/paises/excluir/{id}")
    public String deleteCountry(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/paises";
    }
}
