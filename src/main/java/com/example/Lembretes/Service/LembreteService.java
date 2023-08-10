package com.example.Lembretes.Service;

import com.example.Lembretes.DTO.LembreteDTO;
import com.example.Lembretes.Entity.Lembrete;
import com.example.Lembretes.Repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;

    @Autowired
    private PessoaService pessoaService;

    public Lembrete findById(final Long id) {
        return this.lembreteRepository.findById(id).orElseThrow();
    }

    public List<Lembrete> findAll() {
        return this.lembreteRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(LembreteDTO lembreteDTO) {
        Assert.isTrue(!lembreteDTO.getMensagem().isBlank(), "Mensagem não pode ser nula!");

        lembreteRepository.save(this.toLembrete(lembreteDTO));
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, LembreteDTO lembreteDTO) {
        LembreteDTO lembreteDatabase = toLembreteDTO(findById(id));
        Assert.notNull(lembreteDatabase, "Lembrete não encontrado!");
        Assert.isTrue(lembreteDatabase.getId().equals(lembreteDTO.getId()), "Lembretes não conferem!");
        Assert.isTrue(!lembreteDTO.getMensagem().isBlank(), "Mensagem não pode ser nula!");

        lembreteRepository.save(toLembrete(lembreteDTO));
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        LembreteDTO lembreteDTO = toLembreteDTO(findById(id));
        Assert.notNull(lembreteDTO, "Lembrete não encontrado!");

        lembreteRepository.delete(toLembrete(lembreteDTO));
    }

    public Lembrete toLembrete(LembreteDTO lembreteDTO) {
        return new Lembrete(lembreteDTO.getId(), lembreteDTO.getMensagem(), pessoaService.toPessoa(lembreteDTO.getPessoa()));
    }

    public LembreteDTO toLembreteDTO(Lembrete lembrete) {
        return new LembreteDTO(lembrete.getId(), lembrete.getMensagem(), pessoaService.toPessoaDTO(lembrete.getPessoa()));
    }
}
