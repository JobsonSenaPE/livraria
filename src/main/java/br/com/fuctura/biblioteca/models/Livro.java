package br.com.fuctura.biblioteca.models;

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
    private String texto;

    @JsonIgnore //impede que essa parte seja serializada, esconde o atributo quando envia ou recebe dados via API
    @ManyToOne  //muitos livros ou nenhum para uma categoria
    @JoinColumn(name = "categoria_id") //coluna que servirá como chave estrangeira, para conectar tabelas.
    private Categoria categoria;

}
