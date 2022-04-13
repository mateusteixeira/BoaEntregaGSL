package br.com.boaentrega.repository;

import br.com.boaentrega.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findByCityFromAndCityTo(String cityFrom, String cityTo);
}
