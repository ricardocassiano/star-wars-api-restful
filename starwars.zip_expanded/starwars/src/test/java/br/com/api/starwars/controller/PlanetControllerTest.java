package br.com.api.starwars.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlanetControllerTest {
	
	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup()
	{
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testaRequisicaoIdSucesso() throws Exception {
		String url = "/api/planets/5eb7dfe26ef89806c4f74247";
		this.mvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("name", equalTo("Tatooine")));
	}
	
	@Test
	public void testaRequisicaoIdFalha() throws Exception {
		String url = "/api/planets/1";
		this.mvc.perform(get(url))
		.andExpect(status().is5xxServerError());
	}
	
	@Test
	public void testaCadastroComBodyVazio() throws Exception
	{
		String url = "/api/planets/";
		this.mvc.perform(post(url))
		.andExpect(status().isBadRequest());
	}
	
	/*Tentei bastante, mas infelizmente, não consegui realizar os testes unitários, somente manuais. 
	 * É algo que ainda tenho que estudar muito e estou disposto a aprender.*/

}
