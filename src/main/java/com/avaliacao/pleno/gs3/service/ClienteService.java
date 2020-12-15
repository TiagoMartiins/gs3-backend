package com.avaliacao.pleno.gs3.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.pleno.gs3.dto.ClienteDTO;
import com.avaliacao.pleno.gs3.entity.ClienteEntity;
import com.avaliacao.pleno.gs3.entity.EnderecoEntity;
import com.avaliacao.pleno.gs3.entity.TelefoneEntity;
import com.avaliacao.pleno.gs3.exception.NegocioException;
import com.avaliacao.pleno.gs3.filter.ClienteFilter;
import com.avaliacao.pleno.gs3.filter.EnderecoFilter;
import com.avaliacao.pleno.gs3.filter.TelefoneFilter;
import com.avaliacao.pleno.gs3.mapper.ClienteMapper;
import com.avaliacao.pleno.gs3.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteMapper mapper;
	
	public List<ClienteEntity> getAll() {
		return repository.findAll();
	}
	
	public ClienteDTO createOrUpdate(ClienteFilter clt) throws NegocioException {
		ClienteEntity clienteEntity = mapper.clienteFilterToClienteEntity(clt);
		
		//Transforma cep String to cep Int
		clienteEntity.getEndereco().setCep(transformCepStringtoCepInteger(clt.getEndereco().getCep()));
		
		addTelefoneCliente(clt.getTelefones(), clienteEntity);
		
		return mapper.clienteEntityToClienteDTO(repository.save(clienteEntity));
	}
	
	public String delete(Integer idCliente) {
		
		Optional<ClienteEntity> clt = null;
		
		try {
		clt = repository.findNomeAndCpfByIdCliente(idCliente);
		repository.deleteById(idCliente);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return getMessageDeleteCliente(clt.get());
		
	}
	
	public String getMessageDeleteCliente(ClienteEntity clt) {
		return new String("O cliente : "+clt.getNome().toUpperCase()+
				" com o cpf : "+clt.getCpf()+ " foi deletado da base de dados.");
	}
	
	public ClienteDTO getClienteById(Integer id) throws NegocioException {
		Optional<ClienteEntity> clt = repository.findById(id);
		
		if(clt.isPresent())
			return mapper.clienteEntityToClienteDTO(clt.get());
		else
			throw new NegocioException("Id : " +id+ " não encontrado");
	}
	
	public void addTelefoneCliente(List<TelefoneFilter> telefones, ClienteEntity clt) {
		
		 List<TelefoneEntity> listTelefone = telefones.stream().map(x ->{
			return new TelefoneEntity(x.getTipoTelefone(), x.getNumeroTelefone(), x.getDdd());
		}).collect(Collectors.toList());
		
		clt.setTelefones(listTelefone);
	}
	
	public Integer transformCepStringtoCepInteger(String cep) throws NegocioException {
		Integer cepInt;
		cep = cep.replaceAll("-", "");
		try {
			cepInt = Integer.parseInt(cep);
		}catch (Exception e) {
			throw new NegocioException("Erro de formataçao");
		}
		
		return cepInt;
		
	}

}
