package br.paulotrc.svcbacen.repositories;

import br.paulotrc.svcbacen.entites.Bacen;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BacenRepository {

        Bacen save(Bacen bacen);
        List<Bacen> findAll();
        List<Bacen> consultarPorCpf(String cpf);

    }

