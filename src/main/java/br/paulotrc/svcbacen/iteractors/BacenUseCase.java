package br.paulotrc.svcbacen.iteractors;

import br.paulotrc.svcbacen.entites.Bacen;
import br.paulotrc.svcbacen.repositories.BacenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacenUseCase {

    private BacenRepository bacenRepository;

    public BacenUseCase(BacenRepository bacenRepository) {
        this.bacenRepository = bacenRepository;
    }

    public Bacen gravarBacen(Bacen bacen) {
        return bacenRepository.save(bacen);
    }

    public List<Bacen> consultaTodos() {
        return bacenRepository.findAll();
    }

    public List<Bacen> consultarPorCpf(String cpf) {
        return bacenRepository.consultarPorCpf(cpf);
    }
}
