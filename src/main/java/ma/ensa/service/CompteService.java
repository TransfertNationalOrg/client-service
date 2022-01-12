package ma.ensa.service;

import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Compte;

import java.util.List;

public interface CompteService {
    Compte save(Compte compte) throws DuplicatedException;
    Compte update(Compte compte) throws NotFoundException;
    Long delete(Long id) throws NotFoundException;
    List<Compte> findAll();
}
