package com.ttma.eventBlog;

import com.ttma.eventBlog.enums.RoleEnum;
import com.ttma.eventBlog.model.Role;
import com.ttma.eventBlog.model.User;
import com.ttma.eventBlog.repository.RoleRepository;
import com.ttma.eventBlog.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class EventBlogApplication implements CommandLineRunner {
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(EventBlogApplication.class, args);
	}
	@Override
//	@PostConstruct
	public void run(String... args) throws Exception {
//		Role roleAdmin = Role.builder()
//				.name(RoleEnum.valueOf("ADMIN"))
//				.description("admin")
//				.build();
//		roleRepository.save(roleAdmin);
//
//		Role roleUser = Role.builder()
//				.name(RoleEnum.valueOf("USER"))
//				.description("user")
//				.build();
//		roleRepository.save(roleUser);
//
//		User user = User.builder()
//				.firstName("an")
//				.lastName("minh")
//				.email("an@gmail.com")
//				.active(true)
//				.password("$2a$12$KiC3pE0nyBUP/DzVTDnAiuv21H8umnDzTQoA8P1CIsH0N6YGMd2pa")
//				.username("minhan1111")
//				.role(roleRepository.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException("Role not found")))
//				.build();
//		userRepository.save(user);
	}
}
