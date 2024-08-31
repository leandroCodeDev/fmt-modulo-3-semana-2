package br.com.fullstack.sujestoes.servicos;

import br.com.fullstack.sujestoes.configs.excecoes.NaoEncontradoExcecao;
import br.com.fullstack.sujestoes.entidades.Sugestao;
import br.com.fullstack.sujestoes.repositorios.SugestaoRepositorio;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SugestaoSercicoImpl implements SugestaoServico {

    private final SugestaoRepositorio repositorio;

    @Override
    public Sugestao salvar(Sugestao sugestao) {
        return repositorio.save(sugestao);
    }

    @Override
    public List<Sugestao> buscarTodos(String titulo) {
        if (StringUtils.isBlank(titulo)) {
            titulo = "";
        }
        return repositorio.findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(titulo);
    }

    @Override
    public Sugestao buscarPorId(Long id) {
        return repositorio.findById(id).orElseThrow(
                () -> new NaoEncontradoExcecao("Sugestão não encontrada com ID: " + id)
        );
    }
}