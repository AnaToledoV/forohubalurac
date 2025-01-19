package com.aluracursos.forohubalurac.topico;


import com.aluracursos.forohubalurac.excepciones.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    private final TopicoRepository topicoRepository;

    public List<TopicoResponseDTO> listarTodos() {
        return topicoRepository.findAll().stream()
                .map(topico -> new TopicoResponseDTO(
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion(),
                        topico.getAutor(),
                        topico.getCurso(),
                        topico.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public TopicoResponseDTO detallePorId(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado"));
        return new TopicoResponseDTO(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getStatus()
        );
    }

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

}
