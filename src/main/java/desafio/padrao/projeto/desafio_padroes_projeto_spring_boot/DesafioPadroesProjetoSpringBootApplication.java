package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioPadroesProjetoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPadroesProjetoSpringBootApplication.class, args);
	}

}
