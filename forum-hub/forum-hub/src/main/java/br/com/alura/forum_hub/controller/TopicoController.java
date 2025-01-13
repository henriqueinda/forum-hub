package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.domain.ValidacaoException;
import br.com.alura.forum_hub.domain.topico.*;
import br.com.alura.forum_hub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    //CREATE -> 'C'
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico, UriComponentsBuilder uriComponentsBuilder) {
        var usuarioExistente = usuarioRepository.findByEmail(dadosCadastroTopico.usuario().email());
        if (usuarioExistente.isPresent()) {
            var usuario = usuarioExistente.get();
            var topico = new Topico(dadosCadastroTopico, usuario);
            topicoRepository.save(topico);

            var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
        } else {
            throw new ValidacaoException("Tópico não pode ser criado. Usuário (autor) não cadastrado no ForumHUB®.");
        }
    }

    //READ -> 'R'
    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = topicoRepository.findAllByStatusTrue(paginacao).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(page);
    }

    //UPDATE -> 'U'
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody DadosAtualizacaoTopico dadosAtualizacaoTopico) {
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarTopico(dadosAtualizacaoTopico);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    //DELETE -> 'D'
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.excluir();

        return ResponseEntity.noContent().build();
    }

    //DETALHAR -> 'LISTAR TÓPICO ESPECÍFICO'
    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

}
