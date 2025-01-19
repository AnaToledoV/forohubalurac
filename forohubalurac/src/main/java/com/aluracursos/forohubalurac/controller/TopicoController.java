package com.aluracursos.forohubalurac.controller;

import com.aluracursos.forohubalurac.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid TopicoRequestDTO datos) {
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.badRequest().body("El tópico ya existe con el mismo título y mensaje.");
        }

        Topico nuevoTopico = new Topico(datos.titulo(), datos.mensaje(), datos.autor(), datos.curso());
        topicoRepository.save(nuevoTopico);

        return ResponseEntity.ok("Tópico registrado exitosamente.");
    }


    @GetMapping
    public ResponseEntity<List<TopicoResponseDTO>> listar() {
        List<TopicoResponseDTO> topicos = topicoService.listarTodos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalleTopico(@PathVariable Long id) {
        TopicoResponseDTO topico = topicoService.detallePorId(id);
        return ResponseEntity.ok(topico);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoRequestDTO datos) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isEmpty()) {
            return ResponseEntity.notFound().build(); // Si no existe, devolver 404 Not Found
        }

        if (topicoRepository.existsByTituloAndMensajeAndIdNot(datos.titulo(), datos.mensaje(), id)) {
            return ResponseEntity.badRequest().body("Ya existe un tópico con el mismo título y mensaje.");
        }

        Topico topico = topicoExistente.get();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(datos.autor());
        topico.setCurso(datos.curso());

        topicoRepository.save(topico);

        return ResponseEntity.ok("Tópico actualizado exitosamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isEmpty()) {
            return ResponseEntity.notFound().build(); // Respuesta 404 Not Found
        }

        topicoRepository.deleteById(id);

        return ResponseEntity.ok("Tópico eliminado exitosamente.");
    }


}
