package ma.ensa.controller;


import lombok.Data;
import ma.ensa.Transfert.TransfertDTO;
import ma.ensa.Transfert.TransfertFeign;
import ma.ensa.converter.CompteConverter;
import ma.ensa.dto.CompteDTO;
import ma.ensa.repository.CompteRepository;
import ma.ensa.service.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compte")
@Data
public class CompteController {
    private final CompteService compteService;
    private final CompteConverter compteConverter;
    private final TransfertFeign transfertFeign;

    final CompteRepository compteRepository;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody CompteDTO compteDTO) throws Exception {
        if (compteDTO == null)
            return ResponseEntity.badRequest().body("The provided compte is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(compteConverter.convertToDTO(compteService.save(compteConverter.convertToDM(compteDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody CompteDTO compteDTO) throws Exception {
        if (compteDTO == null)
            return ResponseEntity.badRequest().body("The provided compte is not valid");
        return ResponseEntity
                .ok().body(compteConverter.convertToDTO(compteService.update(compteConverter.convertToDM(compteDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if(id == null)
            return ResponseEntity.badRequest().body("The provided compte's id is not valid");
        return ResponseEntity.ok().body("Compte [" + compteService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<CompteDTO>> findAll() {
        return ResponseEntity.ok().body(compteConverter.convertToDTOs(compteService.findAll()));
    }

    //Get all transferts by compte from transfert-service
    @GetMapping("/allTransferts/{idCompte}")
    public List<TransfertDTO> getAllTransfertsByCompte(@PathVariable("idCompte") Long idCompte){
        return transfertFeign.getTransfertsByCompte(idCompte);
    }

    //Get compte by id
    @GetMapping("{id}")
    public CompteDTO getCompteById(@PathVariable("id") Long id){
        return compteConverter.convertToDTO(compteRepository.getById(id));
    }
}