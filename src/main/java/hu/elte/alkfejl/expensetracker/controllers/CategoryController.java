package hu.elte.alkfejl.expensetracker.controllers;

import hu.elte.alkfejl.expensetracker.entities.Category;
import hu.elte.alkfejl.expensetracker.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    protected <Category> Optional<Category> getEntity(Long id){
        return (Optional<Category>) categoryRepository.findById(id);
    }

    protected void deleteEntity(Long Id){
        categoryRepository.deleteById(Id);
    }

    protected Category saveEntity(Category t){
        return categoryRepository.save(t);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> getAll() {
        return new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return ResponseEntity.ok(optionalCategory.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Category> post(@RequestBody Category category) {
        Category newCategory = categoryRepository.save(category);
        return ResponseEntity.ok(newCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            deleteEntity(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> put(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            category.setId(id);
            return ResponseEntity.ok(categoryRepository.save(category));
        }
        return ResponseEntity.notFound().build();
    }
}
