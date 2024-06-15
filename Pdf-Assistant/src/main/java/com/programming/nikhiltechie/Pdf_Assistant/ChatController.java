package com.programming.nikhiltechie.Pdf_Assistant;
import dev.langchain4j.chain.ConversationalRetrievalChain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ChatController {
    private final ConversationalRetrievalChain conversationalRetrievalChain;

    @PostMapping
    public String chatWithPdf(@RequestBody String text) {
        var answer = conversationalRetrievalChain.execute(text);
        log.debug("Answer is - {}", answer);
        return answer;
    }
}
