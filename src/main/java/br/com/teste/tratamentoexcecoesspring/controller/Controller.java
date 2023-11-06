package br.com.teste.tratamentoexcecoesspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.tratamentoexcecoesspring.model.Course;
import br.com.teste.tratamentoexcecoesspring.service.Service;

@RestController
@RequestMapping("/api/courses")
public class Controller {

	private final Service service;

	public Controller(Service service) {
		this.service = service;
	}

	@GetMapping
	public List<Course> list() {
		return service.list();
	}
	
	@GetMapping("/{id}")
	public Course findByid(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Course create(@RequestBody Course record) {
		return service.create(record);
	}
	
	@PutMapping("/{id}")
	public Course update(@PathVariable Long id, @RequestBody Course record) {
		return service.update(id, record);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
