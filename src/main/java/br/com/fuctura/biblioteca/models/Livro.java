package br.com.fuctura.biblioteca.models;

import br.com.fuctura.biblioteca.enuns.Edicao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor //cria um construtor sem parâmentros
@AllArgsConstructor // cria um construtor com todos os parâmetros
@Entity  //indica que essa classe é uma tabela no banco de dados
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //mostra que o id será a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera um id aleatório para cada livro, na ordem de cadastro
    private Integer id;

    private String titulo;
    private String autor;
    private String texto; // Adicionado de volta conforme o diagrama
    private String descricao; // Mantido, se for um campo adicional

    @Enumerated(EnumType.STRING)
    private Edicao edicao;

    @JsonIgnore //impede que essa parte seja serializada, esconde o atributo quando envia ou recebe dados via API
    @ManyToOne  //muitos livros ou nenhum para uma categoria
    @JoinColumn(name = "categoria_id") //coluna que servirá como chave estrangeira, para conectar tabelas.
    private Categoria categoria;

    // Getters e Setters são gerados automaticamente pelo Lombok (@Data)
    // O construtor com todos os parâmetros é gerado pelo Lombok (@AllArgsConstructor)
    // O construtor sem parâmetros é gerado pelo Lombok (@NoArgsConstructor)


    public Livro(Integer id, String titulo, String autor, String texto, String descricao, Edicao edicao, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.descricao = descricao;
        this.edicao = edicao;
        this.categoria = categoria;
    }


}


