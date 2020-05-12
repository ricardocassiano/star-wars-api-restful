package br.com.api.starwars.response;

import java.util.List;

public class Response<T> {
	
	private T data;
	private List<String> erros;
	private Integer quantidade;
	
	public Response(T data)
	{
		this.data = data;
	}
	
	public Response(T data, int quantidade)
	{
		this.data = data;
		this.quantidade = quantidade;
	}

	public Response(List<String> erros)
	{
		this.erros = erros;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}	
	
}
