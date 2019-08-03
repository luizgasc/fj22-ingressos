package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class Sessao {
	@Id
	private Integer id;
	@Column(name="HorarioSessao")
	private LocalTime horario;
	@ManyToOne
	private Sala sala;
	@ManyToOne
	private Filme filme;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	
}
