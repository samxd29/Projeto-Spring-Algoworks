package com.algoworks.algalog.api.assembler;

import com.algoworks.algalog.api.modelo.EntregaModel;
import com.algoworks.algalog.api.modelo.imput.EntregaInput;
import com.algoworks.algalog.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {
    //vai ser responsável por fazer a montagem de objetos ou mapeamento
    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream().map(this::toModel).collect(Collectors.toList()); //converter um stream em uma lista;
        //colocando collect(Collectors.toList());
    }

    //Converter um objeto EntregaImput em uma entidade entrega;
    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
