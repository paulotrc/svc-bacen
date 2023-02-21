package br.paulotrc.svcbacen.transportlayers.impl;

import br.paulotrc.svcbacen.entites.Bacen;
import br.paulotrc.svcbacen.exceptions.ExceptionUtil;
import br.paulotrc.svcbacen.exceptions.ResourceException;
import br.paulotrc.svcbacen.iteractors.BacenUseCase;
import br.paulotrc.svcbacen.transportlayers.BacenResourceI;
import br.paulotrc.svcbacen.transportlayers.dto.request.BacenRequest;
import br.paulotrc.svcbacen.transportlayers.dto.response.BacenResponse;
import br.paulotrc.svcbacen.transportlayers.mappers.BacenMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class BacenResource implements BacenResourceI {

    private BacenUseCase bacenUseCase;

    public BacenResource(BacenUseCase bacenUseCase) {
        this.bacenUseCase = bacenUseCase;
    }

    @Override
    public ResponseEntity<List<BacenResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    ) {
        List<Bacen> bacens = null;
        try {
            bacens = bacenUseCase.consultarPorCpf(cpf);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(BacenMapper.INSTANCE.mapListResponse(bacens));
    }

    @Override
    public ResponseEntity<List<BacenResponse>> getAll() {
        List<Bacen> bacens = null;
        try {
            bacens = bacenUseCase.consultaTodos();
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(BacenMapper.INSTANCE.mapListResponse(bacens));
    }

    @Override
    public ResponseEntity<BacenResponse> post(@Valid @RequestBody BacenRequest bacenRequest) {
        Bacen bacen = null;
        try {
            bacen = bacenUseCase.gravarBacen(BacenMapper.INSTANCE.map(bacenRequest));
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(BacenMapper.INSTANCE.mapResponse(bacen));
    }
}
