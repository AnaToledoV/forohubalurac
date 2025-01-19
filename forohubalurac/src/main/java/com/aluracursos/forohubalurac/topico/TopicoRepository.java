package com.aluracursos.forohubalurac.topico;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensajeAndIdNot(String titulo, String mensaje, Long id);
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
