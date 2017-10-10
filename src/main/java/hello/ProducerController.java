package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/produce")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ProducerBenchMarkService producerBenchMarkService;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();


    @RequestMapping(value = "/data/{num}/{size}", method = RequestMethod.GET)
    @ResponseBody
    public String produce(@PathVariable int num, @PathVariable int size) {
//        executor.submit(() -> {
//            for (int i = 0; i < num; i++) {
//                producerService.produce(size);
//            }
//        });
//        return "started production batch of " + num + "items";

        return producerBenchMarkService.produce(num, size);
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @ResponseBody
    public String hi() {
        return "hi";
    }

    //TODO: add shutdown hook for executor

}
