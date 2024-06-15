package com.programming.nikhiltechie.Pdf_Assistant;

import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.swing.text.Document;

@SpringBootApplication
public class PdfAssistantApplication {
	private final EmbeddingStoreIngestor embeddingStoreIngestor;
	public PdfAssistantApplication(EmbeddingStoreIngestor embeddingStoreIngestor){
		this.embeddingStoreIngestor = embeddingStoreIngestor;
	}
	@PostConstruct
	public void init(){
		Document document = loadDocument(toPath("cassandra.pdf"), new ApachePdfBoxDocumentParser());
		embeddingStoreIngestor.ingest(document);
	}
	private static Path toPath(String fileName) {
		try {
			URL fileUrl = PdfAssistantApplication.class.getClassLoader().getResource(fileName);
			return Paths.get(fileUrl.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(PdfAssistantApplication.class, args);
	}

}
