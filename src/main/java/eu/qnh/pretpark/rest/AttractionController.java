package eu.qnh.pretpark.rest;

import eu.qnh.pretpark.dao.AttractionRepository;
import eu.qnh.pretpark.model.Attraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.xml.ws.Response;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("api/attraction")
public class AttractionController {

    @Autowired
    private AttractionRepository attractionRepository;

    @GetMapping
    public Iterable<Attraction> list(){

        return this.attractionRepository.findAll();
    }

    @PostMapping(consumes = "application/json",
            produces = "application/json")
    public Attraction create(@RequestBody  Attraction attraction) {
        return this.attractionRepository.save(attraction);
    }

    @GetMapping("{id}")
    public ResponseEntity<Attraction> findById(@PathVariable long id) {

        Optional<Attraction> optionalAttraction =  this.attractionRepository.findById(id);

        if(optionalAttraction.isPresent()) {
            return ResponseEntity.ok(optionalAttraction.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostConstruct
    public void addSomeStarterData() {
        for(int i = 0;i<5;i++) {
            Attraction attraction = new Attraction();
            attraction.setName("Python "+i);
            attraction.setCapacity(Double.valueOf(Math.random()*10).intValue());
            attraction.setLength(new Random(i).nextDouble());

            this.attractionRepository.save(attraction);
        }
    }
}