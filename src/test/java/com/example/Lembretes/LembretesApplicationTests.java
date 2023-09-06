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
		Optional<Pessoa> pessoa = Optional.of(new Pessoa(id, "Andre"));
		Mockito.when(pessoaRepository.findById(id)).thenReturn(pessoa);
	}

	@Test
	void TestControllerFindById(){
		var pessoa = pessoaController.findById(1L);
		Long id = pessoa.getBody().getId();
		Assertions.assertEquals(1L, id);
	}

}
