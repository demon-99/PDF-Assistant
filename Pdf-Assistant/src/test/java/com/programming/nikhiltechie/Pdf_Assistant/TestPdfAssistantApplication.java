package com.programming.nikhiltechie.Pdf_Assistant;

import org.springframework.boot.SpringApplication;

public class TestPdfAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.from(PdfAssistantApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
