package br.com.alura.forumhub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String state,
        @NotBlank
        String author,
        @NotBlank
        String curso) {
}
