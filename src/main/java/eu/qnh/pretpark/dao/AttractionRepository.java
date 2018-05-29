package eu.qnh.pretpark.dao;

import eu.qnh.pretpark.model.Attraction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttractionRepository extends CrudRepository<Attraction, Long> {

    Optional<Attraction> findByName(String name);

    List<Attraction> findAllByNameOrCapacityOrderByNameAsc(String name, int capacity);
}
