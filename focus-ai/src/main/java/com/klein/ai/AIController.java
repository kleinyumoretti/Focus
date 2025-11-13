package com.klein.ai;


import com.klein.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping
public class AIController {
    private final ChatClient chatClient;

    public AIController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("你的名字是Focus，你是一个老中医，专治各种疑难杂症，你会根据用户的问题，提供专业的建议和解决方案")
                .build();
    }

    @GetMapping("/chat")
    public Result<String> chat(@RequestParam("message") String message) {
        String response = chatClient.prompt()
                .user(message)
                .call()
                .content();
        log.info("response:{}", response);
        return Result.success(response);
    }
}
