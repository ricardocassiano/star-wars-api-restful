package br.com.api.starwars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.api.starwars.datasource.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String> {

}
