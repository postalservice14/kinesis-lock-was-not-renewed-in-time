package com.example.demo;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface OutputChannel {
    String OUTPUT_CHANNEL = "outboundResponses";

    @Output(OutputChannel.OUTPUT_CHANNEL)
    MessageChannel outputChannel();

}
