package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.dtos.CategoriaDto;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor // Garante a injeção de dependência via construtor para campos 'final'
public class CategoriaController {

    private final CategoriaService categoriaService; // Injeção via construtor
    private final ModelMapper modelMapper; // Injeção via construtor

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Integer id) {
        // Alterado para findById para corresponder ao método corrigido no CategoriaService
        Categoria cat = categoriaService.findById(id);
        CategoriaDto categoriaDto = modelMapper.map(cat, CategoriaDto.class);
        return ResponseEntity.ok().body(categoriaDto);
    }

    @GetMapping("/nomes/{nome}")
    public ResponseEntity<List<CategoriaDto>> buscarPorNome(@PathVariable String nome) {
        // Este método ainda não existe no CategoriaService, será um erro até ser implementado lá
        List<Categoria> list = categoriaService.buscarPorNome(nome);
        return ResponseEntity.ok().body(list.stream().map(x -> modelMapper.
                map(x, CategoriaDto.class)).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> buscarTodos() {
        // Este método ainda não existe no CategoriaService, será um erro até ser implementado lá
        List<Categoria> list = categoriaService.buscarTodos();
        return ResponseEntity.ok().body(list.stream().map(x -> modelMapper.
                map(x, CategoriaDto.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> salvar(@RequestBody CategoriaDto categoriaDto) {
        // Este método ainda não existe no CategoriaService, será um erro até ser implementado lá
        Categoria cat = categoriaService.salvar(modelMapper.map(categoriaDto, Categoria.class));
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Integer id, @RequestBody CategoriaDto categoriaDto){
        categoriaDto.setId(id);
        // Este método ainda não existe no CategoriaService, será um erro até ser implementado lá
        Categoria cat = categoriaService.salvar(modelMapper.map(categoriaDto, Categoria.class));
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        // Este método ainda não existe no CategoriaService, será um erro até ser implementado lá
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
