package com.generation.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Nome é obrigatório e não pode ser vazio!")
	@Size(min = 2, max = 50, message = "O atributo Nome deve ter no minimo 2 e no máximo 50 caracteres.")
	private String nome;
	
	@NotNull(message = "O atributo Descrição é obrigatório!")
	@Size(max = 1000, message = "O atributo Descrição deve ter no máximo 1000 caracteres.")
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "O atributo Preço é obrigatório!")
	@Positive(message = "O atributo Preço deve ser maior do que zero!")
	private BigDecimal preco;
	
	@NotNull(message = "O atributo Foto é obrigatório!")
	@Size(max = 1000, message = "O atributo Foto deve ter no máximo 1000 caracteres")
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
