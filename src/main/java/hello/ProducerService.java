package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class ProducerService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.destinaton-name}")
    String destinationName;



    private final Map<Integer, Integer[]> cache = new LRUCache<>(10);

    public void produce(int payloadSize) {


        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending Data to JMS");

        final Integer[] payload = getPayload(payloadSize);
        jmsTemplate.convertAndSend(destinationName, new Data(UUID.randomUUID().toString().substring(8), payload));
    }

    private Integer[] getPayload(int payloadSize) {
        if (!cache.containsKey(payloadSize)) {
            cache.put(payloadSize, makePayload(payloadSize));
        }
        return cache.get(payloadSize);
    }

    private Integer[] makePayload(int payloadSize) {
        final Integer[] data = new Integer[payloadSize];
        for (int i = 0;i < data.length; i++) {
            data[i] = 1;
        }
        return data;
    }

}
