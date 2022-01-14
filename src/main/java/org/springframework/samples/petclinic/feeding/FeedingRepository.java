package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding, Integer>{
	@Query("SELECT f FROM Feeding f")
    List<Feeding> findAll();
    @Query("SELECT f FROM FeedingType f")
    List<FeedingType> findAllFeedingTypes();
    @Query("SELECT f FROM Feeding f WHERE(f.id=?1)")
    Optional<Feeding> findById(int id);
    @Query("SELECT f FROM FeedingType f WHERE(f.name=?1)")
    FeedingType findByName(String name);
    Feeding save(Feeding p);
}
