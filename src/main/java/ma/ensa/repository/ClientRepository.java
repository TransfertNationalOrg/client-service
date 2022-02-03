package ma.ensa.repository;
import ma.ensa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select client from Client client where client.email = :x")
    Client findByEmail(@Param("x") String email);
}
