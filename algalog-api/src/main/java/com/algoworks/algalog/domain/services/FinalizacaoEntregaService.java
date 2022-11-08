package com.algoworks.algalog.domain.services;

import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.model.StatusEntrega;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();
        entregaRepository.save(entrega);
    }
}
