package br.com.cadastroaplicacao.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")

public class Fornecedor {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fornecedor_seq")
    @SequenceGenerator(name="fornecedor_seq", sequenceName="fornecedor_seq")
    private Long id;
    private String nome;
    private String endereco;
    private Integer numero;
    private String cidade;    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado.id")
    private Estado estado;
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dtCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dtAlteracao;
        
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

	public LocalDateTime getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(LocalDateTime dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public LocalDateTime getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(LocalDateTime dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Fornecedor(){}

    public Fornecedor(String nome, String endereco, Integer numero, String cidade, Estado estado){
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;        
        this.cidade = cidade;
        this.estado = estado;
        this.dtCriacao = LocalDateTime.now();
        this.dtAlteracao = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return String.format("fornecedor{id=%d, nome='%s', endereco='%s', numero='%s', cidade='%s', estado='%s', dtCriacao='%s', dtAlteracao='%s'}",
        id, nome, endereco, numero, cidade, estado, dtCriacao, dtAlteracao);
    }  
}
