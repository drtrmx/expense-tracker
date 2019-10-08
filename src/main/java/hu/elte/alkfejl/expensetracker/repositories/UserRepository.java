package hu.elte.alkfejl.expensetracker.repositories;

import hu.elte.alkfejl.expensetracker.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByTransactionsId(Long transactionId);
    Optional<User> findById(Long id);
}
