package br.com.fuctura.biblioteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //indica que essa é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera um is automatico
    private Integer id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria") //uma categoria para nenhum ou muitos livros
    private List<Livro> livros = new ArrayList<>(); //se não inicializar, seria uma lista nula (pointexception)

    ;

    public Categoria(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao; //
    }

    public Integer getId() {
        return id; }

    public void setId(Integer id) {
        this.id = id; }

    public String getNome() {
        return nome; }

    public void setNome(String nome) {
        this.nome = nome; }

    public String getDescricao() {
        return descricao; }

    public void setDescricao(String descricao) {
        this.descricao = descricao; }

    public List<Livro> getLivros() {
        return livros;}

    public void setLivros(List<Livro> livros) {
        this.livros = livros; }
}
