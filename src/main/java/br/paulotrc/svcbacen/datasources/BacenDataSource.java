package br.paulotrc.svcbacen.datasources;

import br.paulotrc.svcbacen.entites.Bacen;
import br.paulotrc.svcbacen.repositories.BacenRepository;
import br.paulotrc.svcbacen.repositories.MongoBacenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacenDataSource implements BacenRepository {

    private final Logger log = LoggerFactory.getLogger(BacenDataSource.class);
    private MongoBacenRepository mongoBacenRepository;

    public BacenDataSource(MongoBacenRepository mongoBacenRepository) {
        this.mongoBacenRepository = mongoBacenRepository;
    }

    public Bacen save(Bacen bacen){
        return this.mongoBacenRepository.save(bacen);
    }

    public List<Bacen> findAll(){
        return this.mongoBacenRepository.findAll();
    }

    @Override
    public List<Bacen> consultarPorCpf(String cpf) {
        return mongoBacenRepository.consultarPorCpf(cpf);
    }
}
