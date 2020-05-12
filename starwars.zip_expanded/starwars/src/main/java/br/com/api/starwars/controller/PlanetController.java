package br.com.api.starwars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.starwars.datasource.model.Planet;
import br.com.api.starwars.exception.PlanetNotFoundException;
import br.com.api.starwars.service.PlanetService;
import br.com.api.starwars.response.Response;

@RestController
@RequestMapping(value = "/api/planets")
public class PlanetController {

	@Autowired
	private PlanetService planetService;

	@GetMapping
	public ResponseEntity<Response<List<Planet>>> listarTodos()
	{
		List<Planet> lstPlanets = this.planetService.listarTodos();
		return ResponseEntity.ok(new Response<List<Planet>>(lstPlanets, lstPlanets.size()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Planet>> listarPorId(@PathVariable(name = "id") String id) throws PlanetNotFoundException
	{
		return ResponseEntity.ok(new Response<Planet>(this.planetService.listarPorId(id)));
	}

	@PostMapping
	public ResponseEntity<Response<Planet>> cadastrar(@Valid @RequestBody Planet planet, BindingResult result)
	{
		if(result.hasErrors())
		{
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planet>(erros));
		}
		else
		{
			return ResponseEntity.ok(new Response<Planet>(this.planetService.cadastrar(planet)));
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id)
	{
		this.planetService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
}
