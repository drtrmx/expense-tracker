package hu.elte.alkfejl.expensetracker.repositories;

import hu.elte.alkfejl.expensetracker.entities.Category;
import hu.elte.alkfejl.expensetracker.entities.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {
}
