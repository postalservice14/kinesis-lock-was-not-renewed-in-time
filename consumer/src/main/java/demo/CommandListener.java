package demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommandListener {


    @StreamListener(InputChannel.INPUT_CHANNEL)
    public void processEvent(String event) {

      log.info("Read event : " + event);
    }

}
