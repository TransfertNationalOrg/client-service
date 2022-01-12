package ma.ensa.Transfert;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="transfert-service")
public interface TransfertFeign {
    @GetMapping("/transfert/client/{idClient}")
    List<TransfertDTO> getTransfertsByClient(@PathVariable("idClient") Long idClient);

    @GetMapping("/transfert/compte/{idCompte}")
    List<TransfertDTO> getTransfertsByCompte(@PathVariable("idCompte") Long idCompte);
}
