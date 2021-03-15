# Service for testing Spring Integration with ActiveMQ Artemis 
Library name: integration-artemis

  В примере создается одна входящая очередь inputToOutputQueue и исходящая очередь outputQueue.</br>
Опционально между очередями настроен маршрутизатор который отправляет сообщение из входящей очереди в исходящую.</br>
Для проверки транзакционного режима, создан компонент слушатель на входящую очередь.</br>

Для работы в безопасном режиме с шифрованием SSL, были созданы самоподписанные сертификаты и настроена конфигурация</br>
в брокере и клиенте. Так же добавлен сертификат и настройки для использования web-консоли через SSL.</br>
Настройка конфигурации брокера находится в папке artemis-tls-config: broker.xml.</br>
Для подключения режима ssl необходимо скопировать сертификаты из security в указанную в конфиге папку.</br>  

Для генерации самоподписанных сертификатов необходимо запустить</br>
security\artemis_create_server1_create_ssl.bat
 

После обработки сообщений в логе выводиться информация:</br>
[INFO ] 2021-03-02 12:04:13.342 [DefaultMessageListenerContainer-490] InputMessageConsumer - CONSUMED MESSAGE, docId: 1 docType: order. Total consumed: 1 seconds 39

Ссылки на использованную документацию:</br>
https://activemq.apache.org/components/artemis/documentation/1.0.0/spring-integration.html</br>
https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/boot-features-messaging.html

## Example
java -jar integration-artemis-1.0.0.jar

## Build
mvn clean install
