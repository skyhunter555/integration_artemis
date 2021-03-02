# Service for testing Spring Integration with ActiveMQ Artemis 
Library name: integration-artemis

  В примере создается одна входящая очередь inputToOutputQueue и исходящая очередь outputQueue.</br>
Опционально между очередями настроен маршрутизатор который отправляет сообщение из входящей очереди в исходящую.</br>
Для проверки транзакционного режима, создан компонент слушатель на входящую очередь.</br>

Тестирование в помощью jmeter:</br>
1. Для работы jmeter с брокером Artemis необходима библиотека artemis-jms-client-all-2.16.0.jar.
Перед запуском jmeter необходимо поместить эту библиотке в директорию {JMETER}\lib.</br>  

2. Файл настройки сценария работы jmeter с брокером Artemis содержиться в файле Artemis_Integration.jmx.
Этот файл необходимо поместить в дикерторию {JMETER}\bin и открыть после запуска jmeter.</br>

После обработки сообщений в логе выводиться информация:</br>
[INFO ] 2021-03-02 12:04:13.342 [DefaultMessageListenerContainer-490] InputMessageConsumer - CONSUMED MESSAGE, docId: 1 docType: order. Total consumed: 1 seconds 39

Ссылки на использованную документацию:</br>
https://activemq.apache.org/components/artemis/documentation/1.0.0/spring-integration.html</br>
https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/boot-features-messaging.html

## Example
java -jar integration-artemis-1.0.0.jar

## Build
mvn clean install
