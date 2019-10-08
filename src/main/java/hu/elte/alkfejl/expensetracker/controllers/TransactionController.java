package hu.elte.alkfejl.expensetracker.controllers;

import hu.elte.alkfejl.expensetracker.entities.Transaction;
import hu.elte.alkfejl.expensetracker.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    protected <Transaction> Optional<Transaction> getEntity(Long id){
        return (Optional<Transaction>) transactionRepository.findById(id);
    }

    protected void deleteEntity(Long Id){
        transactionRepository.deleteById(Id);
    }

    protected Transaction saveEntity(Transaction t){
        return transactionRepository.save(t);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Transaction>> getAll() {
        return new ResponseEntity(transactionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            return ResponseEntity.ok(optionalTransaction.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Transaction> post(@RequestBody Transaction transaction) {
        Transaction newTransaction = transactionRepository.save(transaction);
        return ResponseEntity.ok(newTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            deleteEntity(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> put(@PathVariable Long id, @RequestBody Transaction transaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            transaction.setId(id);
            return ResponseEntity.ok(transactionRepository.save(transaction));
        }
        return ResponseEntity.notFound().build();
    }
}
