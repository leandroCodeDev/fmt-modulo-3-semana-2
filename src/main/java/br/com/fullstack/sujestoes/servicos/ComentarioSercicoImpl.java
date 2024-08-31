package br.com.fullstack.sujestoes.servicos;


import br.com.fullstack.sujestoes.entidades.Comentario;
import br.com.fullstack.sujestoes.repositorios.ComentarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioSercicoImpl implements ComentarioServico {

    private final ComentarioRepositorio repositorio;

    @Override
    public Comentario criar(Comentario comentario) {
        return repositorio.save(comentario);
    }

    @Override
    public List<Comentario> buscarPorSugestaoId(Long sugestaoId) {
        return repositorio.findBySugestaoIdOrderByDataEnvioDesc(sugestaoId);
    }
}