package com.learningspringbatch.helloworld;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(final String[] args) {
		final String[] date = { "date=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) };
		SpringApplication.run(HelloWorldApplication.class,
				Stream.of(date, args).flatMap(Stream::of).toArray(String[]::new));
	}
}