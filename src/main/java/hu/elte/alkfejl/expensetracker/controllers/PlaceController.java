package hu.elte.alkfejl.expensetracker.controllers;

import hu.elte.alkfejl.expensetracker.entities.Place;
import hu.elte.alkfejl.expensetracker.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("places")
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

    protected <Place> Optional<Place> getEntity(Long id){
        return (Optional<Place>) placeRepository.findById(id);
    }

    protected void deleteEntity(Long Id){
        placeRepository.deleteById(Id);
    }

    protected Place saveEntity(Place t){
        return placeRepository.save(t);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Place>> getAll() {
        return new ResponseEntity(placeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> get(@PathVariable Long id) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (optionalPlace.isPresent()) {
            return ResponseEntity.ok(optionalPlace.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Place> post(@RequestBody Place place) {
        Place newPlace = placeRepository.save(place);
        return ResponseEntity.ok(newPlace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (optionalPlace.isPresent()) {
            deleteEntity(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> put(@PathVariable Long id, @RequestBody Place place) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (optionalPlace.isPresent()) {
            place.setId(id);
            return ResponseEntity.ok(placeRepository.save(place));
        }
        return ResponseEntity.notFound().build();
    }
}
