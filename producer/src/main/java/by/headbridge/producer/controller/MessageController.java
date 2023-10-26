package by.headbridge.producer.controller;

import by.headbridge.producer.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MessageController {

    private final SenderService service;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        service.sendMessage(message);
        return ResponseEntity.ok(message);
    }

}
