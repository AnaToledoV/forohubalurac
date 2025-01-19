package com.aluracursos.forohubalurac.topico;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TopicoResponseDTO(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String curso,
        String estado
) {}

