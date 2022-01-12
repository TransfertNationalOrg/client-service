package ma.ensa.service.impl;

import lombok.Data;
import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Compte;
import ma.ensa.repository.CompteRepository;
import ma.ensa.service.CompteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CompteServiceImpl implements CompteService {
    final CompteRepository compteRepository;

    @Override
    public Compte save(Compte compte) throws DuplicatedException {
        Compte compteFromDB = compteRepository.findById(compte.getId()).orElse(null);
        if (compteFromDB != null)
            throw new DuplicatedException(compte.getId());
        return compteRepository.save(compte);
    }

    @Override
    public Compte update(Compte compte) throws NotFoundException {
        Compte compteFromDB = compteRepository.findById(compte.getId()).orElse(null);
        if (compteFromDB == null)
            throw new NotFoundException(compte.getId());
        compte.setId(compteFromDB.getId());
        return compteRepository.save(compte);
    }

    @Override
    public Long delete(Long id) throws NotFoundException {
        Compte compteFromDB = compteRepository.findById(id).orElse(null);
        if (compteFromDB == null)
            throw new NotFoundException(id);
        compteRepository.delete(compteFromDB);
        return id;
    }

    @Override
    public List<Compte> findAll() {
        return compteRepository.findAll();
    }
}
