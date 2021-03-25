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

errors

OS name: "linux", version: "4.18.0-240.15.1.el8_3.x86_64", arch: "amd64"
mvn -version
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /opt/maven/apache-maven-3.6.3

Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:5: error: implicit declaration of function ‘printf’ [-Werror=implicit-function-declaration]
    C file contents around line 9:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:8: int JNIHeaderDirectives() {
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(struct JNINativeInterface_)));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:10:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:StructFieldInfo:CallObjectMethodA:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct JNINativeInterface_ *) 0)->CallObjectMethodA)));
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:5: error: incompatible implicit declaration of built-in function ‘printf’ [-Werror]
    C file contents around line 9:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:8: int JNIHeaderDirectives() {
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(struct JNINativeInterface_)));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:10:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:StructFieldInfo:CallObjectMethodA:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct JNINativeInterface_ *) 0)->CallObjectMethodA)));
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:9: error: implicit declaration of function ‘memset’ [-Werror=implicit-function-declaration]
    C file contents around line 109:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:108:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:110:         fieldHolder.b = all_bits_set;
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 109:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:108:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:110:         fieldHolder.b = all_bits_set;
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:120:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 120:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:119:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:120:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:121:         fieldHolder.c = all_bits_set;
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:135:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 135:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:134:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:135:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:136:         fieldHolder.i = all_bits_set;
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:146:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 146:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:145:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:146:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:147:         fieldHolder.j = all_bits_set;
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:159:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 159:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:158:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:159:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:160:         fieldHolder.s = all_bits_set;
Error: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:170:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 170:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:169:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:170:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:171:         fieldHolder.z = all_bits_set;
com.oracle.svm.core.util.UserError$UserException: Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:5: error: implicit declaration of function ‘printf’ [-Werror=implicit-function-declaration]
    C file contents around line 9:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:8: int JNIHeaderDirectives() {
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(struct JNINativeInterface_)));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:10:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:StructFieldInfo:CallObjectMethodA:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct JNINativeInterface_ *) 0)->CallObjectMethodA)));
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:5: error: incompatible implicit declaration of built-in function ‘printf’ [-Werror]
    C file contents around line 9:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:8: int JNIHeaderDirectives() {
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:9:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(struct JNINativeInterface_)));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:10:     printf("NativeCodeInfo:JNIHeaderDirectives:StructInfo:struct_JNINativeInterface_:StructFieldInfo:CallObjectMethodA:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((struct JNINativeInterface_ *) 0)->CallObjectMethodA)));
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:9: error: implicit declaration of function ‘memset’ [-Werror=implicit-function-declaration]
    C file contents around line 109:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:108:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:110:         fieldHolder.b = all_bits_set;
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 109:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:108:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:109:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:110:         fieldHolder.b = all_bits_set;
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:120:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 120:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:119:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:120:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:121:         fieldHolder.c = all_bits_set;
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:135:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 135:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:134:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:135:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:136:         fieldHolder.i = all_bits_set;
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:146:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 146:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:145:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:146:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:147:         fieldHolder.j = all_bits_set;
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:159:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 159:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:158:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:159:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:160:         fieldHolder.s = all_bits_set;
Error compiling query code (in /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include -I/home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/include/linux -o /tmp/SVM-5364068367304974146/JNIHeaderDirectives /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c ' output included error: /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:170:9: error: incompatible implicit declaration of built-in function ‘memset’ [-Werror]
    C file contents around line 170:
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:169:         jvalue fieldHolder;
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:170:         memset(&fieldHolder, 0x0, sizeof(fieldHolder));
    /tmp/SVM-5364068367304974146/JNIHeaderDirectives.c:171:         fieldHolder.z = all_bits_set;
	at com.oracle.svm.core.util.UserError.abort(UserError.java:139)
	at com.oracle.svm.hosted.c.NativeLibraries.reportErrors(NativeLibraries.java:369)
	at com.oracle.svm.hosted.NativeImageGenerator.processNativeLibraryImports(NativeImageGenerator.java:1585)
	at com.oracle.svm.hosted.NativeImageGenerator.setupNativeLibraries(NativeImageGenerator.java:1064)
	at com.oracle.svm.hosted.NativeImageGenerator.setupNativeImage(NativeImageGenerator.java:882)
	at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:561)
	at com.oracle.svm.hosted.NativeImageGenerator.lambda$run$0(NativeImageGenerator.java:476)
	at java.util.concurrent.ForkJoinTask$AdaptedRunnableAction.exec(ForkJoinTask.java:1386)
	at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:289)
	at java.util.concurrent.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1056)
	at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1692)
	at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:175)
Error: Image build request failed with exit status 1


Java version: 1.8.0_282, vendor: GraalVM Community, runtime: /home/skyhunter/.sdkman/candidates/java/21.0.0.r8-grl/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.18.0-240.15.1.el8_3.x86_64", arch: "amd64", family: "unix"
[skyhunter@localhost reactive]$ java -version
openjdk version "1.8.0_282"
OpenJDK Runtime Environment (build 1.8.0_282-b07)
OpenJDK 64-Bit Ser


Error: Error compiling query code (in /tmp/SVM-5314415146569099431/AArch64LibCHelperDirectives.c). Compiler command '/usr/bin/gcc -Wall -Werror -o /tmp/SVM-5314415146569099431/AArch64LibCHelperDirectives /tmp/SVM-5314415146569099431/AArch64LibCHelperDirectives.c ' output included error: /tmp/SVM-5314415146569099431/AArch64LibCHelperDirectives.c:8:5: error: implicit declaration of function ‘printf’ [-Werror=implicit-function-declaration]



