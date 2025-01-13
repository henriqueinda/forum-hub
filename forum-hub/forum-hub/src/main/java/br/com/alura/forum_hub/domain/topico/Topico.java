package br.com.alura.forum_hub.domain.topico;

import br.com.alura.forum_hub.domain.curso.Curso;
import br.com.alura.forum_hub.domain.resposta.Resposta;
import br.com.alura.forum_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Column(unique = true)
    private String mensagem;

    @NotNull
    private LocalDateTime dataCriacao;

    @NotNull
    private boolean status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Curso curso;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario autor;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Resposta> respostas;

    public Topico() {}

    public Topico(@Valid DadosCadastroTopico topicoDTO, Usuario usuario) {
        this.status = true;
        this.titulo = topicoDTO.titulo();
        this.mensagem = topicoDTO.mensagem();
        this.dataCriacao = topicoDTO.dataCriacao();
        this.curso = topicoDTO.curso();
        this.autor = usuario;
        this.respostas = null;
    }
// GETTERS
    public Long getId() {
        return id;
    }

    @NotNull
    public boolean isStatus() {
        return status;
    }

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public @NotBlank String getMensagem() {
        return mensagem;
    }

    public @NotNull LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public @NotNull Curso getCurso() {
        return curso;
    }

    public @NotNull Usuario getAutor() {
        return autor;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }
// MÉTODOS
    public void excluir() {
        this.status = false;
    }

    public void atualizarTopico(@Valid DadosAtualizacaoTopico dadosAtualizados) {
        if (dadosAtualizados.titulo() != null) {
            this.titulo = dadosAtualizados.titulo();
        }

        if (dadosAtualizados.mensagem() != null) {
            this.mensagem = dadosAtualizados.mensagem();
        }
    }
}
