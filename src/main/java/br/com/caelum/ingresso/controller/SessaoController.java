package br.com.caelum.ingresso.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.form.SessaoForm;

@Controller
public class SessaoController {

	@Autowired
	private SalaDao salaDao;
	@Autowired
	private SessaoDao sessaoDao;
	@Autowired
	private FilmeDao filmeDao;

	@GetMapping("/admin/sessao")
	public ModelAndView form(@RequestParam("id") Integer id, SessaoForm form) {

		ModelAndView mv = new ModelAndView("sessao/sessao");
		mv.addObject("sala", salaDao.findOne(id));
		mv.addObject("filmes", filmeDao.findAll());
		mv.addObject("form", form);

		return mv;

	}

	@PostMapping("admin/sessao/adiciona")
	public void SalvaSessao(@Valid SessaoForm form, BindingResult result) {
		if (result.hasErrors()) {

		}
		Sessao sessao = form.toSessao(salaDao, filmeDao);
		sessaoDao.save(sessao);
	}

	@GetMapping("/admin/sala/{id}/sessoes")
	public ModelAndView listaSessoes(@PathVariable("id") Integer id) {
		
		ModelAndView mv = new ModelAndView("sessao/sessao");
		mv.addObject("sessoes", sessaoDao.buscaSessoesDaSala(salaDao.findOne(id)));
		return mv;
	}

}
