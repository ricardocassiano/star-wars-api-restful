package br.com.api.starwars.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.starwars.datasource.model.Planet;
import br.com.api.starwars.exception.PlanetNotFoundException;
import br.com.api.starwars.external.api.API;
import br.com.api.starwars.external.api.GetRequestRepository;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import br.com.api.starwars.repository.PlanetRepository;
import br.com.api.starwars.service.PlanetService;


@Service
public class PlanetServiceImpl implements PlanetService{

	private static final API apiCalls = new API();
    private GetRequestRepository requestRepository = new GetRequestRepository(apiCalls);
    
	@Autowired
	private PlanetRepository planetRepository;
	
	@Override
	public List<Planet> listarTodos() {
		List<Planet> lstPlanets = planetRepository.findAll();
		
		for(int i=0;i<lstPlanets.size();i++)
		{
			lstPlanets.get(i).setFilms(buscarAparicoes(lstPlanets.get(i).getName()));
		}		
		return lstPlanets;
	}

	@Override
	public Planet listarPorId(String id) throws PlanetNotFoundException {
		
		Optional<Planet> optionalPlanet = getOptional(id);

		Planet planet = null;
		if(!optionalPlanet.isPresent())
		{
			throw new PlanetNotFoundException("Planeta não encontrado através do ID: "+id);
		}
		else
		{
			planet = optionalPlanet.get();
			planet.setFilms(buscarAparicoes(planet.getName()));
		}
		return planet;
	}

	@Override
	public Planet cadastrar(Planet planet) {
			return this.planetRepository.save(planet);
		
	}

	@Override
	public void remover(String id) {
		this.planetRepository.deleteById(id);
	}
	
	private Optional<Planet> getOptional(String id) {
		Optional<Planet> optionalPlanet = planetRepository.findById(id);
		return optionalPlanet;
	}
	
	public int buscarAparicoes(String namePlanet) {
		
		JsonObject jsonObject;
		jsonObject = requestRepository.getAll("planets", namePlanet);
		JsonArray results = jsonObject.getAsJsonArray("results");
		
		if(results.size()>=1)
		{
			JsonObject planetObject = results.get(0).getAsJsonObject();
	        JsonArray filmsResults = planetObject.getAsJsonArray("films");
	        return filmsResults.size();
		}
        return 0;
	}

}
