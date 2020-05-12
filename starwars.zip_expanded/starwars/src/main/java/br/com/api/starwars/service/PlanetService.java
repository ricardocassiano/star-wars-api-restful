package br.com.api.starwars.service;

import java.util.List;

import br.com.api.starwars.datasource.model.Planet;
import br.com.api.starwars.exception.PlanetNotFoundException;

public interface PlanetService {
	
	List<Planet> listarTodos();
	
	Planet listarPorId(String id) throws PlanetNotFoundException;
	
	Planet cadastrar(Planet planet);
	
	void remover(String id);
	

}
