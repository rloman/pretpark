package eu.qnh.pretpark.service;

import eu.qnh.pretpark.dao.AttractionRepository;
import eu.qnh.pretpark.model.Attraction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AttractionServiceTest {


    @InjectMocks
    private AttractionService attractionService;

    @Mock
    private AttractionRepository attractionRepository;

    @Test
    public void testFindAll() {

        // Mock the repo
        List<Attraction> list = Arrays.asList(new Attraction(),
                new Attraction(),
                new Attraction());
        Mockito.when(this.attractionRepository.findAll()).thenReturn(list);
        int counter = 0;
        Iterable<Attraction> attractionsIterable = this.attractionService.findAll();

        for(Attraction a : attractionsIterable) {
            counter++;
        }

        Assert.assertEquals(3, counter);

        Mockito.verify(this.attractionRepository, Mockito.times(1)).findAll();  // 1 is default
    }
}
