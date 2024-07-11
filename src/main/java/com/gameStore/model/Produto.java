package com.gameStore.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	
	//Criando o ID de produtos com auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//Declarando o titulo, não podendo deixar o campo em branco e colocando minimo e maximo 
	@NotBlank(message = "O atributo titulo é obrigatório!")
	@Size(min = 3, max = 50, message = "O titulo tem que ter no minino 3 letras, e no máximo 50")
	private String titulo;
	
	
	//Declarando a idade minima, não podendo deixar o campo em branco e colocando minimo e maximo 
	@NotBlank(message = "A classificação de idade é obrigatória!")
	@Size(min = 2, max = 25, message = "Insira no minimo 2 caracteres e no maximo 25")
	private String idade;
	
	
	//Declarando a descrição, não podendo deixar o campo em branco e colocando minimo e maximo 
	@NotBlank(message = "Insira uma descrição!")
	@Size(min = 2, max = 100, message = "no minimo 2 caracteres e no maximo 100")
	private String descricao;
	
	
	//Declarando chave estrangeira do tipo (Muitos para Um) e ignorando a propriedade "Categoria", criando um atributo
	// do tipo Categoria
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	
	//Getters e Setters 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
