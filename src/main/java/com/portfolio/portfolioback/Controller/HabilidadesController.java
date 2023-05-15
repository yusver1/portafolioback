package com.portfolio.portfolioback.Controller;



import com.portfolio.portfolioback.Entity.Habilidades;
import com.portfolio.portfolioback.Repository.HabilidadesRepository;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:8080")
//@RequestMapping("/api")
public class HabilidadesController {

    private final HabilidadesRepository habilidadesRepository;

    public HabilidadesController(final HabilidadesRepository habilidadesRepository) {
        this.habilidadesRepository = habilidadesRepository;

    }

    @GetMapping("/api/habilidades")
    public Iterable<Habilidades> getAllHabilidades() {
        return this.habilidadesRepository.findAll();
    }

    @GetMapping("/api/habilidades/{id}")
    public Optional<Habilidades> getHabilidadesById(@PathVariable("id") Integer id) {
        return this.habilidadesRepository.findById(id);
    }

    @PostMapping("/editor/habilidades")
    @PreAuthorize("hasRole('ADMIN')")
    public Habilidades createNewHabilidades(@RequestBody Habilidades habilidades) {
        Habilidades newHabilidades = this.habilidadesRepository.save(habilidades);
        return newHabilidades;
    }

    @PutMapping("/editor/habilidades/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Habilidades updateHabilidades(
            @PathVariable("id") Integer id,
            @RequestBody Habilidades hab
    ) {
        Optional<Habilidades> habilidadesToUpdateOptional = this.habilidadesRepository.findById(id);
        if (!habilidadesToUpdateOptional.isPresent()) {
            return null;
        }
        Habilidades habilidadesToUpdate = habilidadesToUpdateOptional.get();
        if (hab.getTitulo() != null) {
            habilidadesToUpdate.setTitulo(hab.getTitulo());
        }
        if (hab.getAvance() != null) {
            habilidadesToUpdate.setAvance(hab.getAvance());
        }

        if (hab.getOrden() != null) {
            habilidadesToUpdate.setOrden(hab.getOrden());
        }

        Habilidades updatedHabilidades = this.habilidadesRepository.save(habilidadesToUpdate);
        return updatedHabilidades;
    }

    @DeleteMapping("/editor/habilidades/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Habilidades deleteHabilidades(@PathVariable("id") Integer id){
        Optional<Habilidades> habilidadesToDeleteOptional = this.habilidadesRepository.findById(id);

        if(!habilidadesToDeleteOptional.isPresent()){
            return null;
        }

        Habilidades habilidadesToDelete = habilidadesToDeleteOptional.get();

        this.habilidadesRepository.delete(habilidadesToDelete);
        return habilidadesToDelete;
    }
}

