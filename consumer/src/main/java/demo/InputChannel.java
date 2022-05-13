package demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannel {

    String INPUT_CHANNEL = "inboundRequests";

    @Input(InputChannel.INPUT_CHANNEL)
    SubscribableChannel inputChannel();
}
