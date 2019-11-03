package hu.elte.alkfejl.expensetracker.repositories;

import hu.elte.alkfejl.expensetracker.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
