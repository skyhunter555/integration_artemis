package ru.syntez.integration.artemis;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class IntegrationArtemisTest {

    /*
    @Configuration
    public static class Config {

        @Value("${camel.component.rabbitmq.host}")
        private String brokerHost = "localhost";

        @Value("${camel.component.rabbitmq.port}")
        private Integer brokerPort = 5672;

        @Value("${camel.component.rabbitmq.username}")
        private String username = "user";

        @Value("${camel.component.rabbitmq.password}")
        private String password = "user";

        @Bean
        public ConnectionFactory connectionFactory() {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost");
            connectionFactory.setPort(brokerPort);
            connectionFactory.setUsername(username);
            connectionFactory.setPassword(password);
            connectionFactory.setVirtualHost(username);
            connectionFactory.setRequestedChannelMax(1);
            return connectionFactory;
        }
    }

    private String queueInputEndpoint = "inputqueue";

    @Autowired
    ConnectionFactory connectionFactory;

    @Test
    public void sendMessageToInputQueueTest() {


        ConfigurableApplicationContext context = SpringApplication.run(IntegrationRabbitMain.class, args);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        try {
            List<File> xmlFileList = Arrays.asList(
                ResourceUtils.getFile(IntegrationRabbitMain.class.getResource("/xmls/router_doc_1.xml"))
            );
            long startTime = System.currentTimeMillis();
            LOG.info("Starting send: " + startTime);
            for (int i = 0; i < 100; i++) {
                xmlFileList.forEach(xmlFile ->
                    rabbitTemplate.convertAndSend("inputqueue", xmlFile)
                );
            }
            long finishTime = System.currentTimeMillis();
            LOG.info("Send all: " + finishTime);
            LOG.info("Total time: " + (finishTime - startTime) + " ms.");
        } catch (Exception e) {
            LOG.error(String.format("Error send files %s", e.getMessage()));
        }

    }*/

}
