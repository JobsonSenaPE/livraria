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
    private String descricao;
    private String edicao;

    @JsonIgnore //impede que essa parte seja serializada, esconde o atributo quando envia ou recebe dados via API
    @ManyToOne  //muitos livros ou nenhum para uma categoria
    @JoinColumn(name = "categoria_id") //coluna que servirá como chave estrangeira, para conectar tabelas.
    private Categoria categoria;

    //get - retorna o dado , set- edita o dado

    public Integer getId() {
        return id;}

    public void setId(Integer id) {
        this.id = id;}

    public String getTitulo() {
        return titulo; }

    public void setTitulo(String titulo) {
        this.titulo = titulo; }

    public String getAutor() {
        return autor; }

    public void setAutor(String autor) {
        this.autor = autor; }

    public String getDescricao() {
        return descricao;    }

    public void setDescricao(String descricao) {
        this.descricao = descricao; }

    public String getEdicao() {
        return edicao; }

    public void setEdicao(String edicao) {
        this.edicao = edicao; }

    public Categoria getCategoria() {
        return categoria; }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria; }
}
