package edu.ifpb.dac;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

public class ConsumidorDeEmail {

    @Resource(lookup = "jms/email")
    private Topic topic;

    @Inject
    private JMSContext jmsContext;



}
