package br.com.boaentrega.repository;

import br.com.boaentrega.domain.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends IJpaRepository<Route, Long> {

    Route findByCityFromAndCityTo(String cityFrom, String cityTo);
}
