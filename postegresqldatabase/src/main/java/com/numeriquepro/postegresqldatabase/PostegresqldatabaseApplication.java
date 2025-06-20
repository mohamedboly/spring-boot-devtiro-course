package com.numeriquepro.postegresqldatabase;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class PostegresqldatabaseApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PostegresqldatabaseApplication.class, args);
	}

	private final DataSource dataSource;

	public PostegresqldatabaseApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void run(final String... args) {

		log.info("Datasource: " + dataSource.toString());

		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("SELECT 1");
	}

}
