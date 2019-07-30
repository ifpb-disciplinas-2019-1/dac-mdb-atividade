package edu.ifpb.dac;

import javax.annotation.Resource;
import javax.jms.JMSContext;
import javax.jms.Topic;

public class ConsumidorDeEmail {

    @Resource(lookup = "jms/email");
    private Topic topic;

    private JMSContext jmsContext;

}
