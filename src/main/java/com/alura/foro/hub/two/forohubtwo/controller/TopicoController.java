package com.alura.foro.hub.two.forohubtwo.controller;



import com.alura.foro.hub.two.forohubtwo.domain.Topico;
import com.alura.foro.hub.two.forohubtwo.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody Topico topico) {
        Topico nuevoTopico = topicoService.crearTopico(topico);
        return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> obtenerTodosLosTopicos() {
        List<Topico> topicos = topicoService.obtenerTodosLosTopicos();
        return new ResponseEntity<>(topicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoService.obtenerTopicoPorId(id);
        return new ResponseEntity<>(topico, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topicoActualizado) {
        Topico topico = topicoService.actualizarTopico(id, topicoActualizado);
        return new ResponseEntity<>(topico, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
