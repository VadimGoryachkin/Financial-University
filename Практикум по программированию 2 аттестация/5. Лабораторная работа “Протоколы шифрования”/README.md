Суть работы заключается в том, что при запуске и клиент, и сервер генерируют свою пару ключей. При подключении клиент отсылает серверу свой открытый ключ. Затем, сервер отсылает клиенту открытый ключ сервера. Далее, клиент отправляет сообщение серверу, при этом шифруя его своим закрытым ключом и открытым ключом сервера. После получения сообщения, сервер расшифровывает его сначала своим закрытым ключом, а затем открытым ключом клиента. Обратное сообщение отсылается аналогично. Для шифрования и расшифрования я использовал фукнции симметричного шифрования из лабораторной работы по симметричному шифрованию (Unix).

![image](https://user-images.githubusercontent.com/90458771/146659927-10aa3cd5-8923-41d5-8116-ec0af695713d.png)

Затем, в фукнции get_keys() мы считываем уже существующие ключи, а если их нет, то создаются новые.

  Дополнительное задание № 1

Модифицируйте код клиента и сервера так, чтобы приватный и публичный ключ хранились в текстовых файлах на диске и, таким образом, переиспользовались между запусками.

Задание реализовано в коде программы. Мы можем удостовериться, что между запусками, ключи в файлах не меняются.

Ниже представлены: csv файл с ключами клиента

![image](https://user-images.githubusercontent.com/90458771/146660148-f50ba949-38b3-41b5-bdc0-fc505d53e08c.png)

И csv файл с ключами сервера

![image](https://user-images.githubusercontent.com/90458771/146660336-8bc7725a-d55a-487c-b62b-3728c80206a4.png)

Сервер хранит ключи для каждого из клиентов (по IP-адресу)

  Дополнительное задание № 2

Проведите рефакторинг кода клиента и сервера так, чтобы все, относящееся к генерации ключей, установлению режима шифрования, шифрованию исходящих и дешифрованию входящих сообщений было отделено от основного алгоритма обмена сообщениями.

Задание реализовано в коде программы:

![image](https://user-images.githubusercontent.com/90458771/146660386-d20aa811-4cd5-49ed-a067-6275c84a34b6.png)

![image](https://user-images.githubusercontent.com/90458771/146660431-9d2de1eb-3316-4622-acb7-3e4bf56714b6.png)

  Дополнительное задание № 3

Реализуйте на сервере проверку входящих сертификатов. На сервере должен храниться список разрешенных ключей. Когда клиент посылает на сервер свой публичный ключ, сервер ищет его среди разрешенных и, если такого не находит, разрывает соединение. Проверьте правильность работы не нескольких разных клиентах. 

Так как это задание подразумевает, что ключи уже существуют, я прикрепил файлы с созданными ключами. В файле allowed.csv находятся разрешенные открытые ключи клиентов.

![image](https://user-images.githubusercontent.com/90458771/146660540-5cc63959-9af7-4241-b685-647a061b2381.png)

  Дополнительное задание № 4

Модифицируйте код клиента и сервера таким образом, чтобы установление режима шифрования происходило при подключении на один порт, а основное общение - на другом порту. Номер порта можно передавать как первое зашифрованное сообщение. 

Задание реализовано в коде программы. Мы видим, что сервер и клиент выводят сообщения о подключении к конкретному порту.
Изначально сервер подключился к порту 10101

![image](https://user-images.githubusercontent.com/90458771/146660802-c2d2bff3-ebd9-4318-b914-0012401f4548.png)

После того, как подключился клиент, они переключились на новый порт (рандомный) и продолжают обмен сообщений уже на нём.

![image](https://user-images.githubusercontent.com/90458771/146660821-d49919e4-87e6-4a3c-b5ce-14860e85fff8.png)

![image](https://user-images.githubusercontent.com/90458771/146660939-e1074602-a451-4ab0-85f9-81865542658f.png)

![image](https://user-images.githubusercontent.com/90458771/146660920-907d75cb-790d-4894-8e4a-02d82924bb6b.png)

![image](https://user-images.githubusercontent.com/90458771/146660988-ca302f24-5eab-4007-9a88-341b583e1b34.png)

  Дополнительное задание № 5

Модифицируйте код FTP-сервера таким образом, чтобы он поддерживал шифрование.

![image](https://user-images.githubusercontent.com/90458771/146661134-3f191fba-912b-41d0-ab47-a27e0bfde38e.png)

![image](https://user-images.githubusercontent.com/90458771/146661148-2292ac27-f61f-4e4e-a863-e34f171140c7.png)

Для реализации данной задачи методы send и recv были заменены на модифицированные (и прописанные) s_send и s_recv. Модифицированные  методы теперь поддерживают шифрование. Генерация и обмен ключами происходит при каждом запросе (каждый раз - разные).

![image](https://user-images.githubusercontent.com/90458771/146661203-2ccda424-aadc-4c27-9842-935bffeac0d3.png)

![image](https://user-images.githubusercontent.com/90458771/146661211-619b8c95-9ac2-4026-916f-fbe75fb21c65.png)

В лог файле осуществляется запись запросов (действий) и их результат:

![image](https://user-images.githubusercontent.com/90458771/146661341-5f7337b7-bdae-443a-b0cc-89024c83c5d2.png)
