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
        return "paises";
    }
}
