package com.example.Lembretes;

import com.example.Lembretes.Controller.PessoaController;
import com.example.Lembretes.Entity.Pessoa;
import com.example.Lembretes.Repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LembretesApplicationTests {
	@MockBean
	PessoaRepository pessoaRepository;
	@Autowired
	PessoaController pessoaController;

	@BeforeEach
	void injectData(){
		Long id = 1L;
		String nome = "Andre";
		Pessoa pessoa = new Pessoa(id, nome);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa(1L, "Andre"));
		pessoas.add(new Pessoa(2L, "Joao"));
		pessoas.add(new Pessoa(3L, "Maria"));
		pessoas.add(new Pessoa(4L, "Julia"));
		pessoas.add(new Pessoa(5L, "Paulo"));
		Mockito.when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));
		Mockito.when(pessoaRepository.findByNome(nome)).thenReturn(pessoa);
		Mockito.when(pessoaRepository.findAll()).thenReturn(pessoas);
	}

	@Test
	void TestControllerFindById(){
		var pessoa = pessoaController.findById(1L);
		Long id = pessoa.getBody().getId();
		Assertions.assertEquals(1L, id);
	}

	@Test
	void TestControllerFindByName(){
		var pessoa = pessoaController.findByName("Andre");
		String nome = pessoa.getBody().getNome();
		Assertions.assertEquals("Andre", nome);
	}

	@Test
	void TestControllerFindAll(){
		var pessoas = pessoaController.findAll().getBody();
		List<Pessoa> pessoasComp = new ArrayList<Pessoa>();
		pessoasComp.add(new Pessoa(1L, "Andre"));
		pessoasComp.add(new Pessoa(2L, "Joao"));
		pessoasComp.add(new Pessoa(3L, "Maria"));
		pessoasComp.add(new Pessoa(4L, "Julia"));
		pessoasComp.add(new Pessoa(5L, "Paulo"));
		Assertions.assertEquals(pessoasComp, pessoas);
	}
}
