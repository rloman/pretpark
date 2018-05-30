package eu.qnh.pretpark.rest;

import eu.qnh.pretpark.dao.AttractionRepository;
import eu.qnh.pretpark.model.Attraction;
import eu.qnh.pretpark.service.AttractionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("api/attraction")
public class AttractionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttractionController.class);

    @Autowired
    private AttractionService attractionService;


    @Value("${application.controllerName}")
    private String controllerName;


    /* Rocking example for setter injection
    @Autowired
    public void setAttractionRepository(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }
    */

    /* Rocking example for constructor injection
    @Autowired
    public AttractionController(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }
    */

    @GetMapping
    public Iterable<Attraction> list(){

        return this.attractionService.findAll();
    }

    @PostMapping(consumes = "application/json",
            produces = "application/json")
    public Attraction create(@RequestBody  Attraction attraction) {
        return this.attractionService.save(attraction);
    }

    @GetMapping("{id}")
    public ResponseEntity<Attraction> findById(@PathVariable long id) {

        Optional<Attraction> optionalAttraction =  this.attractionService.findById(id);

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

            this.attractionService.save(attraction);

            LOGGER.info("Saved attraction [{}] in controller with name [{}]", attraction, this.controllerName);
        }
    }
}
