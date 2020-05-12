package br.com.api.starwars.datasource.model;


import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planet {
	
	@Id
	private String id;
	
	private String name;
	private String climate;
	private String terrain;
	private int films;
	
	public Planet()
	{
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Nome não pode ser vazio")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public int getFilms() {
		return films;
	}
	public void setFilms(int films) {
		this.films = films;
	}

	
}
