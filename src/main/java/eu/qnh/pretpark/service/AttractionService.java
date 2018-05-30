package eu.qnh.pretpark.service;

import eu.qnh.pretpark.dao.AttractionRepository;
import eu.qnh.pretpark.model.Attraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;



    public Iterable<Attraction> findAll() {

        return this.attractionRepository.findAll();

    }


    @Transactional
    public Attraction save(Attraction a) {
        return this.attractionRepository.save(a);
    }
}
