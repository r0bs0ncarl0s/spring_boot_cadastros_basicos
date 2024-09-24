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
@Table(name = "estado")

public class Estado {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estado_seq")
    @SequenceGenerator(name="estado_seq", sequenceName="estado_seq")
    private Long id;
    private String nome;
    private String sigla;    
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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

	public Estado(){}

    public Estado(String nome, String sigla){
        this.nome = nome;
        this.sigla = sigla;
        this.dtCriacao = Instant.now();
        this.dtAlteracao = Instant.now();
    }

    @Override
    public String toString(){
        return String.format("estado{id=%d, nome='%s', sigla='%s', dtCriacao='%s', dtAlteracao='%s'}",
        id, nome, sigla, dtCriacao, dtAlteracao);
    }    
}
