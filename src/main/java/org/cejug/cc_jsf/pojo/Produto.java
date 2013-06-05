package org.cejug.cc_jsf.pojo;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

//Importações necessárias para uso das anotações
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa um produto
 *
 */
@Entity //define que esta classe será uma tabela em um base de dados
@Table(name = "produtos") //define o nome da tabela na base de dados
public class Produto implements Serializable{

	//Propriedades

	private static final long serialVersionUID = 8114001930137970115L;

	@Id //diz que a propriedade id deve ser o identificador desta tabela no banco 
	@GeneratedValue(strategy = GenerationType.AUTO) //forma como será gerado este identificador
	private Integer id; //código único identificador 
	
	@Column(length = 50) //tamanho do campo nome 
	private String nome; //uma descrição para o produto
	
	@Column(precision=25, scale=10) //definindo precisão e escala
	private BigDecimal preco; //preço para a venda
	
	@Column(length=1) //tamanho do campo
	private Byte situacao; //Guardara o estado do produnto sendo estes: novo, bom estado, mais ou menos e quebrado
	
	private Boolean inativo; //não é mais usado no sistema
	
	@Lob //equivale ao blob, como um varchar de tamanho indefinido
	private String observacoes; //dados adicionais	
	
	@Temporal(TemporalType.DATE) //diz que esta propriedade será uma data
	@Column(name = "data_de_cadastro", nullable = false, updatable = false) // define o nome da coluna; que não pode ser nula; e a propriedade não pode ser alterada
	private Date dataDeCadastro; //data em que o produto foi registrado no banco de dados
	
	//Construtores
	
	/**
	 * Construtor padrão, ele é necessário (obrigatório) para o correto funcionamento do JPA
	 */
	public Produto(){}
	
	//Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Byte getSituacao() {
		return situacao;
	}

	public void setSituacao(Byte situacao) {
		this.situacao = situacao;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
	//Métodos Sobrescritos
	
	/**
	 * Sobrescreve hashCode e equals, não é obrigatório
	 * Mais a respeito em: http://stackoverflow.com/questions/5031614/the-jpa-hashcode-equals-dilemma
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() { 
		return "Id: " + this.id + " Nome: " + this.nome;
	}
	
}
