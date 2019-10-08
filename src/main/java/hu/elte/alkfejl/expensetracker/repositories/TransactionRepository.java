package hu.elte.alkfejl.expensetracker.repositories;

import hu.elte.alkfejl.expensetracker.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
