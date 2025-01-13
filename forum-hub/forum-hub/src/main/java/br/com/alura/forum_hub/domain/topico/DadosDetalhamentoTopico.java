package br.com.alura.forum_hub.domain.topico;

import br.com.alura.forum_hub.domain.curso.Curso;
import br.com.alura.forum_hub.domain.resposta.Resposta;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoTopico(
        Long id,
        Boolean status,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Curso curso,
        String nomeAutor,
        List<Resposta> respostas
) {
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(),
                topico.isStatus(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getCurso(),
                topico.getAutor().getNome(),
                topico.getRespostas());
    }
}
