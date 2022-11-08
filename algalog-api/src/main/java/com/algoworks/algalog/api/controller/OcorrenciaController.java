package com.algoworks.algalog.api.controller;

import com.algoworks.algalog.api.assembler.OcorrenciaAssembler;
import com.algoworks.algalog.api.modelo.OcorrenciaModel;
import com.algoworks.algalog.api.modelo.imput.OcorrenciaInput;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.model.Ocorrencia;
import com.algoworks.algalog.domain.services.BuscaEntregaService;
import com.algoworks.algalog.domain.services.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;

    private OcorrenciaAssembler ocorrenciaAssembler;

    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
       Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
               .registrar(entregaId, ocorrenciaInput.getDescricao());

       return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
