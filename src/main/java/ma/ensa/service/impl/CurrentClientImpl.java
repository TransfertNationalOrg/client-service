package ma.ensa.service.impl;

import lombok.Data;
import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.CurrentClient;
import ma.ensa.repository.CurrentClientRepository;
import ma.ensa.service.CurrentClientService;
import org.springframework.stereotype.Service;

@Service
@Data
public class CurrentClientImpl implements CurrentClientService {

    final CurrentClientRepository clientRepository;

    @Override
    public CurrentClient save(CurrentClient currentClient) throws DuplicatedException {
        CurrentClient currentClientFromDB = clientRepository.findById(currentClient.getId()).orElse(null);
        if (currentClientFromDB != null)
            throw new DuplicatedException(currentClient.getId());
        return clientRepository.save(currentClient);
    }

    @Override
    public CurrentClient update(CurrentClient currentClient) throws NotFoundException {
        CurrentClient clientFromDB = clientRepository.findById(currentClient.getId()).orElse(null);
        if (clientFromDB != null)
            throw new NotFoundException(currentClient.getId());
        return clientRepository.save(currentClient);
    }
}
