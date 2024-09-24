package br.com.cadastroaplicacao.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "produto")

public class Produto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_seq")
    @SequenceGenerator(name="produto_seq", sequenceName="produto_seq")
    private Long id;
    private String nome;    
    private Instant dtCriacao;
    private Instant dtAlteracao;
        
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

	public Instant getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Instant dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Instant getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Instant dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public Produto(){}

    public Produto(String nome){
        this.nome = nome;
        this.dtCriacao = Instant.now();
        this.dtAlteracao = Instant.now();
    }

    @Override
    public String toString(){
        return String.format("produto{id=%d, nome='%s', dtCriacao='%s', dtAlteracao='%s'}",
        id, nome, dtCriacao, dtAlteracao);
    }    
}
