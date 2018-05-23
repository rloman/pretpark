package eu.qnh.pretpark.dao;

import eu.qnh.pretpark.model.Attraction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PretparkRepository extends CrudRepository<Attraction, Long> {
}
