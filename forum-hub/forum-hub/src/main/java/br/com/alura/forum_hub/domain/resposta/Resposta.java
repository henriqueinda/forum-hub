package br.com.alura.forum_hub.domain.resposta;

import br.com.alura.forum_hub.domain.topico.Topico;
import br.com.alura.forum_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mensagem;

    @NotNull
    private LocalDateTime dataCriacao;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario autor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Topico topico;

}
