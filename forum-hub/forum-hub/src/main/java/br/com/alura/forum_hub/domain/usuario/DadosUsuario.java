package br.com.alura.forum_hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosUsuario(@NotBlank String email) {
}
