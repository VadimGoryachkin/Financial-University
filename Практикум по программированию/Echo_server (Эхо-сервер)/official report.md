Пункты с 1 по 7 реализованы в файлах client.py и server.py

2 пункт. Клиент вводит exit и разрывает соединение

![image](https://user-images.githubusercontent.com/90458771/140731977-8de89f64-5705-409c-8abe-042b4967eb2f.png)


3 пункт. Сервер продолжает прослушивать, это значит, что можно подключиться повторно. Два клиента подключились и разорвали соединение

![image](https://user-images.githubusercontent.com/90458771/140732075-f10d2772-9388-45d8-b023-577cb4978d88.png)


4 пункт. Номер порта и имя хоста (для клиента) спрашивается у пользователя. Безопасный ввод данных реализован модулем getpass и значения по умолчанию при пустом вводе. 
Также, при некорректном вводе ip или port соединение не установится и выведется ошибка, следовательно, в данном сценарии проверка ввода не нужна

![image](https://user-images.githubusercontent.com/90458771/140732187-51b8c044-6f2a-4351-9572-8c7df52e27ab.png)

![image](https://user-images.githubusercontent.com/90458771/140753028-a2cc8f04-de24-4b3d-9a6f-f9461da22670.png)



5 пункт. Для выполнения этого пункта используем модуль sys
Также изменяем файл вывода на наш заготовленный файл (server_log.txt).

![image](https://user-images.githubusercontent.com/90458771/140753292-bdaef528-6b0f-4c14-adb6-6cc4aa90dba5.png)

![image](https://user-images.githubusercontent.com/90458771/140753310-02dd44f4-a2b9-4542-b5e0-bd233b570aa2.png)

![image](https://user-images.githubusercontent.com/90458771/140732374-cea1fd23-e900-4564-9fbb-b2976bfec45f.png)

![image](https://user-images.githubusercontent.com/90458771/140732715-b0411938-826b-4a3b-826f-24078d54d860.png)


6 пункт. Ниже представлен модифицированный код:

![image](https://user-images.githubusercontent.com/90458771/140753572-45781875-de8f-42dc-bc25-41033b0447fe.png)

![image](https://user-images.githubusercontent.com/90458771/140733136-e5fb33f1-348f-4c1f-b5db-238f0e585d40.png)


7 пункт. Реализован сервер идентификации. Далее сначала запрашивается имя пользователя

![image](https://user-images.githubusercontent.com/90458771/140733369-629efc7d-f34d-4eb8-b96a-ca75591e0184.png)

Затем имя и IP пользователя записывается в файл (client.txt)

![image](https://user-images.githubusercontent.com/90458771/140728033-93ac9363-f2e7-499c-ae5b-a5fa99f2d975.png)

Теперь при повторном подключении сервер нас приветствует

![image](https://user-images.githubusercontent.com/90458771/140734035-fec6aa0a-4dbf-4a1c-bb9a-16d63a181e9d.png)

Пункты с 8 по 10 реализованы в файлах client.py и server.py

8 пункт. Реализован сервер аутентификации. При первом подключении сревер попросил придумать пароль, далее он сохранил пароль и уже предложил авторизоваться, после авторизации.

Пароли в файлах хранятся в хешированном виде с ипользованием алгоритма шифрования md5. 

При авторизации сервер отправляет клиенту токен, который действует одну сессию. 

Когда клиент отправляет сообщение, к нему добавляется токен.

Сервер совершает проверку токена и, если токен верен, обрабатывает сообщение. 

Информация о логине/пароле сохраняется в зашифрованном виде в csv файл

![image](https://user-images.githubusercontent.com/90458771/140734160-6df275e2-da0d-419d-b8e5-5d519250f7ca.png)

![image](https://user-images.githubusercontent.com/90458771/140734225-75b50916-3b32-4912-9b0a-c82f383bd5cb.png)


Теперь сервер видит, что клиент зарегистрировался и авторизовался и может обмениваться с ним сообщениями

![image](https://user-images.githubusercontent.com/90458771/140734305-d05d7d69-fbd9-4c10-9123-02d82c25e705.png)


9 пункт. Реализованы вспомогательные функции отправки и принятия текстовых сообщений в сокет.

Работа отправки и принятия сообщений приведена в предыдущем пункте. Видим, что выводится длина сообщений, а сообщения передаются как байтовые массивы.

Однако, вспомогательные части на экран не выводятся.

Данный функции реализованы отдельно и созданы в виде унаследованного расширения класса socket. 

Ниже представлена функция приема отправки клиента

![image](https://user-images.githubusercontent.com/90458771/140753795-2f8392d8-6a4f-4a9f-81a4-d05fa5f9e81a.png)

Функция приема отправки сервера

![image](https://user-images.githubusercontent.com/90458771/140753895-fcd10768-09d3-4f49-b3ee-d4cdc21514cd.png)

10 пункт. Дополнили код клиента. Теперь сервер и клиент могут переписываться последовательно.

![image](https://user-images.githubusercontent.com/90458771/140734468-34294d7f-7757-4bbb-a497-131ea3b072b5.png)


Слева расположены сообщения сервера, а справа клиента. Если клиент отсоединиися, то сервер будет ждать новое подключение
