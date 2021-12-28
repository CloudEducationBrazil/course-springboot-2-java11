package com.educandoweb.coursejava.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.coursejava.entities.Order;
import com.educandoweb.coursejava.entities.User;
import com.educandoweb.coursejava.repositories.OrderRepository;
import com.educandoweb.coursejava.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		// Padrão de data UTC - Time Zone GMT getTimeZone("GMT"));
		// GMT ou Greenwich Mean Time (Hora Média em Greenwich) é a hora no meridiano 
		// que atravessa o laboratório astronómico da cidade de Greenwich no Reino Unido. 
		// UTC ou Coordinate Universal Time (Tempo Universal Coordenado) é um padrão internacional de tempo 
		// equivalente à GMT.
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); // Padrão UTC horário GMT
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 		
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
