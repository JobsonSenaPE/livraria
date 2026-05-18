package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Importação adicionada

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired // Manter @Autowired por enquanto, mas idealmente usar injeção via construtor com final e @RequiredArgsConstructor
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.orElseThrow(() -> new RuntimeException("Categoria não encontrada! Id: " + id)); // Tratamento seguro
    }

    public List<Categoria> buscarPorNome(String nome) {
        // Este método requer que CategoriaRepository tenha findByNomeContainingIgnoreCase
        return categoriaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    @Transactional // Adicionado para operações de escrita
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional // Adicionado para operações de escrita
    public Categoria atualizar(Categoria categoria) {
        // Antes de atualizar, é uma boa prática verificar se a categoria existe
        buscarPorId(categoria.getId()); // Garante que a categoria existe antes de salvar
        return categoriaRepository.save(categoria);
    }

    @Transactional // Adicionado para operações de escrita
    public void deletar(Integer id) {
        buscarPorId(id); // Garante que a categoria existe antes de deletar
        categoriaRepository.deleteById(id); // Correção: chamar deleteById
    }

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada! Id: " + id));
    }
}
