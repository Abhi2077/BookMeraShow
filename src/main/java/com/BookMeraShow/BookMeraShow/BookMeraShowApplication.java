package com.BookMeraShow.BookMeraShow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.function.FailableRunnable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BookMeraShow.BookMeraShow.service.DbService;

import jakarta.annotation.Resource;

@SpringBootApplication
@EnableAutoConfiguration
public class BookMeraShowApplication implements CommandLineRunner {

	@Resource
	private DbService dbService;

	public static void main(String[] args) {
		SpringApplication.run(BookMeraShowApplication.class, args);
	}

	@Override
	public void run(String... args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(safeRunnable(dbService::changeShow1));
		executor.execute(safeRunnable(dbService::changeShow2));
		executor.shutdown();
	}

	private Runnable safeRunnable(FailableRunnable<Exception> runnable) {
		return () -> {
			try {
				runnable.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}
