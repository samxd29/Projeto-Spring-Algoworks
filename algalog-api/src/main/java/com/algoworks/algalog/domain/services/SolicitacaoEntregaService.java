package com.algoworks.algalog.domain.services;

import com.algoworks.algalog.domain.exception.NegocioException;
import com.algoworks.algalog.domain.model.Cliente;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.model.StatusEntrega;
import com.algoworks.algalog.domain.repository.ClienteRepository;
import com.algoworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;

    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(@RequestBody Entrega entrega) {
        Cliente cliente  = catalogoClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now().now());

        return entregaRepository.save(entrega);
    }
}
