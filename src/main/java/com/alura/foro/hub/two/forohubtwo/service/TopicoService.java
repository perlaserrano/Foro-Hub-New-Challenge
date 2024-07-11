package com.alura.foro.hub.two.forohubtwo.service;

import com.alura.foro.hub.two.forohubtwo.domain.Topico;
import com.alura.foro.hub.two.forohubtwo.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico crearTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public List<Topico> obtenerTodosLosTopicos() {
        return topicoRepository.findAll();
    }

    public Topico obtenerTopicoPorId(Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        return optionalTopico.orElse(null);
    }

    public Topico actualizarTopico(Long id, Topico topicoActualizado) {
        if (topicoRepository.existsById(id)) {
            topicoActualizado.setId(id);
            return topicoRepository.save(topicoActualizado);
        }
        return null; // Manejar caso de no existencia
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}
