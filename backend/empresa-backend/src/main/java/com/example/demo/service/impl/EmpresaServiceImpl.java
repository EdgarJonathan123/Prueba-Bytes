package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Empresa;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	private EmpresaRepository empresaRepository;
	
	public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
		super();
		this.empresaRepository = empresaRepository;
	}

	@Override
	public Empresa guardarEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public List<Empresa> getAllEmpresas() {
		return empresaRepository.findAll();
	}


	@Override
	public Empresa findById(long id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		if(empresa.isPresent()) {
			return empresa.get();
		}else {
			throw new ResourceNotFoundException("Empresa", "Id", id);
		}
	}
	
	@Override
	public Empresa actualizarEmpresa(Empresa empresa,long id) {

		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		if(optionalEmpresa.isPresent()) {
			Empresa empresaExistente =  optionalEmpresa.get();
			empresaExistente.setDireccion(empresa.getDireccion());
			empresaExistente.setFechaFundacion(empresa.getFechaFundacion());
			empresaExistente.setNombre(empresa.getNombre());
			empresaExistente.setNumeroNit(empresa.getNumeroNit());
			empresaRepository.save(empresaExistente);
			return empresaExistente;
		}else {
			throw new ResourceNotFoundException("Empresa", "Id", id);
		}
	}

	@Override
	public void eliminarEmpresa(long id) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		if(!optionalEmpresa.isPresent()) {
			throw new ResourceNotFoundException("Empresa", "Id", id);
		}

		empresaRepository.deleteById(id);
	}
	
	
}

