package br.com.teste.tratamentoexcecoesspring.service;

import java.util.List;

import br.com.teste.tratamentoexcecoesspring.exception.RecordoNotFoundException;
import br.com.teste.tratamentoexcecoesspring.model.Course;
import br.com.teste.tratamentoexcecoesspring.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	private final Repository repository;

	public Service(Repository repository) {
		this.repository = repository;
	}

	public List<Course> list() {
		return repository.findAll();
	}

	public Course findById(Long id) {
//		.orElseThrow(() -> new RecordoNotFoundException(id) chama o Construtor da classe RecordoNotFoundException
		return repository.findById(id).orElseThrow(() -> new RecordoNotFoundException(id));
	}

	public Course create(Course record) {
		return repository.save(record);
	}

	public Course update(Long id, Course record) {
		return repository.findById(id).map(recordFound -> {
			recordFound.setId(recordFound.getId());
			recordFound.setName(record.getName());
			recordFound.setCategory(record.getCategory());
			return repository.save(recordFound);
		}).orElseThrow(() -> new RecordoNotFoundException(id));
	}

	public void delete(Long id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new RecordoNotFoundException(id)));
	}
}