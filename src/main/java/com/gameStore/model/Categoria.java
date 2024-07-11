package com.gameStore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	
	//Declarando o ID como chave primária e com auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//Declarando o atributo nome, não podendo deixar em branco e com tamanho min e max já definidos!
	@NotBlank(message = "Insira um valor no nome da categoria!")
	@Size(min = 3, max = 55, message = "Insira no minimo  caracteres e no maximo 55!")
	private String nome;
	
	
	//Declarando descricao da categoria, podendo ter min e max se for declarado!
	@Size(min = 3, max = 100, message = "Insira no minimo 3 caracteres e no maximo 100!")
	private String descricao;
	
	
	//Declarando uma relação de Um para Muitos, e ignorando a propriedade "Produto" para evitar repetir na Lista,
	//Criando também uma Lista do Tipo Produto, que irá armazenar todos os produtos ligados a categoria.
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE )
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;


	//Getters e Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
