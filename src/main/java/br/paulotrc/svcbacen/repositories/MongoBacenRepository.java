package br.paulotrc.svcbacen.repositories;

import br.paulotrc.svcbacen.entites.Bacen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoBacenRepository extends MongoRepository<Bacen, UUID> {

    @Query("{cpf: { $regex: ?0 } })")
    List<Bacen> consultarPorCpf(String cpf);
}
