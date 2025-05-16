package com.example.ApiRestThyleaf.Service;

import com.example.ApiRestThyleaf.Entity.Pais;
import com.example.ApiRestThyleaf.Repository.PaisRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class PaisService {

    private final PaisRepository repository;

    public PaisService(PaisRepository repository) {
        this.repository = repository;
    }

    public List<Pais> listPaises(String continente, String sortBy) {
        List<Pais> paises = (continente == null || continente.isEmpty())
                ? repository.findAll()
                : repository.findByContinente(continente);

        if (sortBy != null && !sortBy.isEmpty()) {
            paises.sort(getComparador(sortBy));
        }

        return paises;
    }

    private Comparator<Pais> getComparador(String sortBy) {
        return switch (sortBy) {
            case "nome" -> Comparator.comparing(Pais::getNome, String.CASE_INSENSITIVE_ORDER);
            case "capital" -> Comparator.comparing(Pais::getCapital, String.CASE_INSENSITIVE_ORDER);
            case "continente" -> Comparator.comparing(Pais::getContinente, String.CASE_INSENSITIVE_ORDER);
            default -> Comparator.comparing(Pais::getNome, String.CASE_INSENSITIVE_ORDER); // padrão
        };
    }

}
