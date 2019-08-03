package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Entity;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Entity
public class SessaoForm {
	@NotNull
	private Integer id;
	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horario;
	@NotNull
	private Sala sala;
	@NotNull
	private Filme filme;

	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {

		Sessao sessao = new Sessao();

		sessao.setFilme(filmeDao.findOne(filme.getId()));
		sessao.setSala(salaDao.findOne(sala.getId()));
		sessao.setHorario(this.horario);

		return sessao;
	}

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
