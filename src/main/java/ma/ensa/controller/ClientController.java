package ma.ensa.controller;

import lombok.Data;
import ma.ensa.Transfert.TransfertDTO;
import ma.ensa.Transfert.TransfertFeign;
import ma.ensa.converter.ClientConverter;
import ma.ensa.dto.ClientDTO;
import ma.ensa.repository.ClientRepository;
import ma.ensa.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@Data
public class ClientController {
    final ClientService clientService;
    final ClientConverter clientConverter;
    final TransfertFeign transfertFeign;

    final ClientRepository clientRepository;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ClientDTO clientDTO) throws Exception {
        if (clientDTO == null)
            return ResponseEntity.badRequest().body("The provided client is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientConverter.convertToDTO(clientService.save(clientConverter.convertToDM(clientDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody ClientDTO clientDTO) throws Exception {
        if (clientDTO == null)
            return ResponseEntity.badRequest().body("The provided client is not valid");
        return ResponseEntity
                .ok().body(clientConverter.convertToDTO(clientService.update(clientConverter.convertToDM(clientDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if(id == null)
            return ResponseEntity.badRequest().body("The provided client's id is not valid");
        return ResponseEntity.ok().body("Client [" + clientService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok().body(clientConverter.convertToDTOs(clientService.findAll()));
    }

    //Get all transferts by client from transfert-service
    @GetMapping("/allTransferts/{idClient}")
    public List<TransfertDTO> getAllTransfertsByClient(@PathVariable("idClient") Long idClient){
        return transfertFeign.getTransfertsByClient(idClient);
    }

    //Get client by id
    @GetMapping("{id}")
    public ClientDTO getClientById(@PathVariable("id") Long id){
        return clientConverter.convertToDTO(clientRepository.getById(id));
    }
}
