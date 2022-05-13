package com.example.demo.producer;

import com.example.demo.OutputChannel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j

@RestController
public class ProducerController {

    @Autowired
    private OutputChannel outputChannel;

    @RequestMapping(path="/")
    public void producer() {
        String payload = "Hello " + RandomStringUtils.random(200) + ".";

        log.info("Sending message: '" + payload + "'.");
        boolean send = outputChannel.outputChannel().send(
                MessageBuilder.withPayload(payload).build()
        );
        if (!send) {
            log.error("==== Message failed to sent ===");
        }

    }

}
