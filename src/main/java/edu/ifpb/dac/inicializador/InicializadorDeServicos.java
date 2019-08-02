package edu.ifpb.dac.inicializador;

import javax.jms.*;


@JMSDestinationDefinitions({
	@JMSDestinationDefinition(
			name="java:global/jms/pedido",
			interfaceName="javax.jms.Topic",
			resourceAdapter="jmsra",
			destinationName="topic"
	),
	@JMSDestinationDefinition(
			name="java:global/jms/email",
			interfaceName="javax.jms.Queue",
			resourceAdapter="jmsra",
			destinationName="queue"
	)
})

public class InicializadorDeServicos {

}
