package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProducerBenchMarkService {
    @Autowired
    private ProducerService producerService;


    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public String produce(int num, int size) {

        try {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < num; i++) {
                        producerService.produce(size);
                    }
                }
            });
        } catch (Exception e) {
            return "Couldn't execute production: " + e.getMessage();
        }

        return "Started production for " + num + " itens";
    }

}
