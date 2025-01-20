package br.com.alura.forumhub.topico;

public record DadosListagemTopico(Long id, String titulo, String mensagem, String created_at, String state, String author, String curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCreatedAt(), topico.getState(), topico.getAuthor(), topico.getCurso());
    }
}
