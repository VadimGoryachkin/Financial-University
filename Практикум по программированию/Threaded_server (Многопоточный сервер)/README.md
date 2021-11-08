Пункт 2.(представлен в server.py и client.py)

Модифицированный простой эхо-сервер:


![image](https://user-images.githubusercontent.com/90458771/140763137-befbe280-dd43-440a-9bfa-ee42dfbc393f.png)


Результат подключения клиентов:


![image](https://user-images.githubusercontent.com/90458771/140778083-fb9bfacf-2d79-4504-b16c-cedfe895c39e.png)


![image](https://user-images.githubusercontent.com/90458771/140778098-0918d80a-a588-4d48-9de7-752dd1816209.png)


![image](https://user-images.githubusercontent.com/90458771/140778169-3310b167-0583-41e9-8261-4fe12090130c.png)


![image](https://user-images.githubusercontent.com/90458771/140778190-a18091d4-40c4-4b77-8c65-4552822b7c8f.png)


Пункт 3. Реализован простой чат сервер на базе сервера аутентификации

Регистрация первого клиента

![image](https://user-images.githubusercontent.com/90458771/140778367-e611f013-7100-413a-bed4-bdc103b70898.png)


Регистрация второго клиента


![image](https://user-images.githubusercontent.com/90458771/140778448-fa7094b6-1bb1-41ce-9a4b-4b413ffc6650.png)


Файл регистрации - clients.csv

![image](https://user-images.githubusercontent.com/90458771/140778542-4bf46967-b3b4-4515-94e2-bc5fab4c5726.png)


![image](https://user-images.githubusercontent.com/90458771/140779319-24d7a589-ec9b-47fa-98f4-78bfe17fd66d.png)


Вывод сервера:


![image](https://user-images.githubusercontent.com/90458771/140779384-af252c54-cb1d-435b-95a4-c5fce28553ea.png)


Переписка у пользователей и сервера:


![image](https://user-images.githubusercontent.com/90458771/140779483-d129fb0a-8805-4ac6-b54c-ca2947a303eb.png)


![image](https://user-images.githubusercontent.com/90458771/140779511-2e55aae0-2dca-4271-9c05-c1c82e34487f.png)


История сообщений (из файла msg_hst_2371938254.7826521.csv)


![image](https://user-images.githubusercontent.com/90458771/140779645-353690d5-c420-4522-aff9-9bc12725eb79.png)

Пункт 4. Реализован сервер с управляющим потоком

Отключение сервера - команда:

![image](https://user-images.githubusercontent.com/90458771/140779896-baa96810-7c00-493c-8bc0-2f1eb1967d63.png)


Пауза (остановка прослушивание порта) - команда:

![image](https://user-images.githubusercontent.com/90458771/140780194-20dd0e62-5533-40e3-92b4-519763d7ae4e.png)

![image](https://user-images.githubusercontent.com/90458771/140780211-7e320641-fefb-4169-8850-55c7dbeb7a72.png)

Видим, что у клиента ничего не происходит, он ожидает соединения, так как мы запретили подключения
Теперь, если мы введем start listen то клиент сразу подключится

![image](https://user-images.githubusercontent.com/90458771/140780429-54e663f0-630f-4d1e-9ec3-4f07356bf370.png)

![image](https://user-images.githubusercontent.com/90458771/140780450-b45c621f-e3a3-483b-8208-45c7728a9320.png)


Показ логов выключается и включается с помощью команд - stop log start log

![image](https://user-images.githubusercontent.com/90458771/140781065-279ee563-f341-4402-be57-a8b578d06115.png)


Очистка логов выполняется с помощью команды - clear log

![image](https://user-images.githubusercontent.com/90458771/140781155-a2e938ca-e6ae-417f-a6d2-b4d99c3ef3ba.png)


Очистка файла идентификации выполняется с помощью команды - clear file


![image](https://user-images.githubusercontent.com/90458771/140780870-35a6f7e7-2eaf-4762-9ab9-c3e75885330e.png)


