# Service for testing Spring Integration with ActiveMQ Artemis 
Library name: integration-artemis

  В примере создается одна входящая очередь inputToOutputQueue и исходящая очередь outputQueue.</br>
Опционально между очередями настроен маршрутизатор который отправляет сообщение из входящей очереди в исходящую.</br>
Для проверки транзакционного режима, создан компонент слушатель на входящую очередь.</br>

Для работы в безопасном режиме с шифрованием SSL, были созданы самоподписанные сертификаты и настроена конфигурация
в брокере и клиенте. Так же добавлен сертификат и настройки для использования web-консоли через SSL.

1.	Создание ключей, сертификатов и хранилищ.</br>
С помощью openssl в консоли cоздаем 5 комплектов ключей, сертификатов и хранилищ.</br>

1.1	Серверная часть

1.1.1	Генерируем ключ CA (удостоверяющий ключ)</br>
openssl genrsa -out ca.key 2048

1.1.2	Создаем файл CA сертификата (удостоверяющий сертификат) </br>
openssl req -new -x509 -days 1826 -key ca.key -out ca.crt -subj "/C=RU/ST=AMQ/L=AMQ/O=AMQ/OU=AMQ/CN=ArtemisCA"

1.1.3	Генерируем серверный ключ, в процессе необходимо будет ввести пароль.</br>
openssl genrsa -out broker.key 2048

1.1.4	Создаем файл серверного сертификата
openssl req -new -out broker.csr -key broker.key -subj "/C=RU/ST=AMQ/L=AMQ/O=AMQ/OU=AMQ/CN=ArtemisBroker"

1.1.5	Процесс самоподписания серверного сертификата удостоверяющим ключем CA</br>
openssl x509 -req -in broker.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out broker.crt -days 360

1.1.6	Создание доверенного хранилища сервера и импорт доверенного сертификата.</br>
keytool -import -file ca.crt -alias broker -keystore broker_ts.p12 -deststoretype pkcs12</br>
password: user555</br>
trust this certificate Yes

1.1.7	Экспорт серверного сертификата и ключа в хранилище ключей</br>
openssl pkcs12 -export -in broker.crt -inkey broker.key -out broker_ks.p12 -CAfile ca.crt</br>
password: user555

1.2	 Клиент обработчик

1.2.1	Генерируем ключ клиента</br>
openssl genrsa -out client_consumer.key 2048

1.2.2	Создаем файл клиентского сертификата</br>
openssl req -new -out client_consumer.csr -key client_consumer.key -subj "/C=RU/ST=AMQ/L=AMQ/O=AMQ/OU=AMQ/CN=ArtemisClientConsumer"

1.2.3	Процесс самоподписания клентского сертификата CA удостоверяющим ключем CA</br>
openssl x509 -req -in client_consumer.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out client_consumer.crt -days 360</br>

1.2.4	Создание хранилища клиента обработчика и импорт доверенного сертификата.</br>
keytool -import -alias ArtemisClientConsumer -keystore client_consumer_ts.p12 -file client_consumer.crt -deststoretype pkcs12</br>
password: user555</br>
trust this certificate Yes

1.2.5	Импорт доверенного сертификата в хранилище. </br>
keytool -import -alias CA -keystore client_consumer_ts.p12 -file ca.crt</br>
password: user555</br>
trust this certificate Yes

1.2.6	Экспорт сертификата и ключа клиента обработчика в хранилище ключей</br>
openssl pkcs12 -export -in client_consumer.crt -inkey client_consumer.key -out client_consumer_ks.p12 -CAfile ca.crt

1.3	 Клиент отправитель

1.3.1	Генерируем ключ клиента</br>
openssl genrsa -out client_sender.key 2048

1.3.2	Создаем файл клиентского сертификата</br>
openssl req -new -out client_sender.csr -key client_sender.key -subj "/C=RU/ST=AMQ/L=AMQ/O=AMQ/OU=AMQ/CN=ArtemisClientSender"

1.3.3	Процесс самоподписания клентского сертификата CA удостоверяющим ключем CA</br>
openssl x509 -req -in client_sender.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out client_sender.crt -days 360

1.3.4	Создание хранилища клиента обработчика и импорт доверенного сертификата.</br>
keytool -import -alias ArtemisClientSender -keystore client_sender_ts.p12 -file client_sender.crt -deststoretype pkcs12
password: user555</br>
trust this certificate Yes

1.3.5	Импорт доверенного сертификата в хранилище.</br>
keytool -import -alias CA -keystore client_sender_ts.p12 -file ca.crt</br>
password: user555

1.3.6	Экспорт сертификата и ключа клиента обработчика в хранилище ключей</br>
openssl pkcs12 -export -in client_sender.crt -inkey client_sender.key -out client_sender_ks.p12 -CAfile ca.crt


1.4	 Клиент браузера

1.4.1	Генерируем ключ браузера</br>
openssl genrsa -out client_browser.key 2048

1.4.2	Создаем файл браузерного сертификата</br>
openssl req -new -out client_browser.csr -key client_browser.key -subj "/C=RU/ST=AMQ/L=AMQ/O=AMQ/OU=AMQ/CN=ArtemisClientBrowser"

1.4.3	Процесс самоподписания браузерного сертификата CA удостоверяющим ключем CA</br>
openssl x509 -req -in client_browser.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out client_browser.crt -days 360

1.4.4	Создание браузерного хранилища и импорт доверенного сертификата.</br>
keytool -import -file ca.crt -alias CA -keystore client_browser_ts.ts</br>
password: user555</br>
trust this certificate Yes

1.4.5	Экспорт сертификата и ключа браузера в хранилище ключей.</br>
openssl pkcs12 -export -in client_browser.crt -inkey client_browser.key -out client_browser_ks.p12 -CAfile ca.crt</br>
password: user555

1.4.6	Импорт сертификата и ключа браузера в хранилище ключей</br>
keytool -importkeystore -srckeystore client_browser_ks.p12 -destkeystore client_browser_ts.ts -srcstoretype pkcs12

1.5	Узел кластера

1.5.1	Генерируем ключ узла кластера</br>
openssl genrsa -out broker_node.key 2048

1.5.2	Создаем файл сертификата узла кластера</br>
openssl req -new -out broker_node.csr -key broker_node.key -subj "/C=RU/ST=AMQ/L=AMQ/O=AMQ/OU=AMQ/CN=ArtemisBrokerNode"

1.5.3	Процесс самоподписания сертификата CA узла кластера удостоверяющим ключом CA</br>
openssl x509 -req -in broker_node.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out broker_node.crt -days 360

1.5.4	Создание хранилища узла кластера и импорт доверенного сертификата.</br>
keytool -import -alias ArtemisBrokerNode -keystore broker_node_ts.p12 -file broker_node.crt -deststoretype pkcs12</br>
password: user555</br>
trust this certificate Yes

1.5.5	Импорт доверенного сертификата в хранилище</br>
keytool -import -alias CA -keystore broker_node_ts.p12 -file ca.crt</br>
password: user555

1.5.6	Экспорт сертификата и ключа клиента обработчика в хранилище ключей</br>
openssl pkcs12 -export -in broker_node.crt -inkey broker_node.key -out broker_node_ks.p12 -CAfile ca.crt
 

После обработки сообщений в логе выводиться информация:</br>
[INFO ] 2021-03-02 12:04:13.342 [DefaultMessageListenerContainer-490] InputMessageConsumer - CONSUMED MESSAGE, docId: 1 docType: order. Total consumed: 1 seconds 39

Ссылки на использованную документацию:</br>
https://activemq.apache.org/components/artemis/documentation/1.0.0/spring-integration.html</br>
https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/boot-features-messaging.html

## Example
java -jar integration-artemis-1.0.0.jar

## Build
mvn clean install
