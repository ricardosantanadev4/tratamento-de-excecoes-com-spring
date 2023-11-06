package br.com.teste.tratamentoexcecoesspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.teste.tratamentoexcecoesspring.model.Course;
import br.com.teste.tratamentoexcecoesspring.repository.Repository;

@SpringBootApplication
public class TratamentoExcecoesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TratamentoExcecoesSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(Repository repository) {
		return args -> {
			repository.deleteAll();
			Course course = new Course();
			course.setName("Angular");
			course.setCategory("Front-End");
			repository.save(course);
		};
	}
}
