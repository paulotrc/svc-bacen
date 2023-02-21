package br.paulotrc.svcbacen.transportlayers.mappers;

import br.paulotrc.svcbacen.entites.Bacen;
import br.paulotrc.svcbacen.transportlayers.dto.request.BacenRequest;
import br.paulotrc.svcbacen.transportlayers.dto.response.BacenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface BacenMapper {

    BacenMapper INSTANCE = Mappers.getMapper(BacenMapper.class);

    Bacen map(BacenRequest bacenRequest);

    BacenResponse mapResponse(Bacen bacen);

    default List<BacenResponse> mapListResponse(List<Bacen> bacens){
        final List<BacenResponse> bacenResponseList = new ArrayList<>();
        for (Bacen bacen:bacens) {
            BacenResponse bacenResp = BacenMapper.INSTANCE.mapResponse(bacen);
            bacenResponseList.add(bacenResp);
        }
        return bacenResponseList;
    }
}

