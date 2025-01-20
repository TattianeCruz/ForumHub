package br.com.alura.forumhub.topico;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {


    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @CreationTimestamp
    private String createdAt;
    private String state;
    private String author;
    private String curso;

    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.state = dados.state();
        this.author = dados.author();
        this.curso = dados.curso();
    }

    public Topico(){}

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getState() {
        return state;
    }

    public String getAuthor() {
        return author;
    }

    public String getCurso() {
        return curso;
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.state() != null) {
            this.state = dados.state();
        }
        if (dados.author() != null) {
            this.author = dados.author();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
    }
}
