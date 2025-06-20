package com.numeriquepro.h2inmemorydatase;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class H2inmemorydataseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(H2inmemorydataseApplication.class, args);
	}

	private final DataSource dataSource;

	public H2inmemorydataseApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}



	@Override
	public void run(final String... args) {
		System.out.println("dfghjk boly");
		log.info("Datasource: " + dataSource.toString());

		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("SELECT 1");
	}
}