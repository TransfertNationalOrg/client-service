package ma.ensa.service;

import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.CurrentClient;


public interface CurrentClientService {
    CurrentClient save(CurrentClient currentClient) throws DuplicatedException;
    CurrentClient update(CurrentClient currentClient) throws NotFoundException;
}
