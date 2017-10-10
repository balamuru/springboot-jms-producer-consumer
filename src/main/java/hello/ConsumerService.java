package hello;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@ConditionalOnBean(ConsumerConfiguration.class)
@Service
public class ConsumerService {
Log log = LogFactory.getLog(this.getClass());
    @JmsListener(destination = "${jms.destinaton-name}", containerFactory = "myFactory")
    public void consumer(ActiveMQObjectMessage object) throws JMSException {
        System.out.println("Received <" + object.getObject() + ">");
        log.info("Got " + object.getObject());
    }

}
