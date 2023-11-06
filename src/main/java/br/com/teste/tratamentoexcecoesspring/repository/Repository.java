package br.com.teste.tratamentoexcecoesspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.tratamentoexcecoesspring.model.Course;

public interface Repository extends JpaRepository<Course, Long> {

}
