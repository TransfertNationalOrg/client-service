package ma.ensa.repository;

import ma.ensa.model.CurrentClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CurrentClientRepository extends JpaRepository<CurrentClient, Long> {
}
