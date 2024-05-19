package pl.isa.javaers.repository;

import org.springframework.stereotype.Repository;
import pl.isa.javaers.Rate;

import java.util.List;

@Repository
public interface RateRepository {

    List<Rate> readRatesFromJSON();
}
