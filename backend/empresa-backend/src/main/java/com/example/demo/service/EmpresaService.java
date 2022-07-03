package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Empresa;

public interface EmpresaService {
	
	Empresa  guardarEmpresa(Empresa empresa);
	List<Empresa> getAllEmpresas();
	Empresa findById(long id);
	Empresa actualizarEmpresa(Empresa empresa,long id);
	void eliminarEmpresa(long id);
	


}
