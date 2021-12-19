Основные задания:

1. Посмотреть содержимое папки; Верхнее окно - сервер, нижнее - клиент.

![image](https://user-images.githubusercontent.com/90458771/146663909-276f2be1-ba30-4b6a-8be0-129f58a54efd.png)

![image](https://user-images.githubusercontent.com/90458771/146663917-b81f3d14-0cd2-4b8e-a02f-f2d166e107ea.png)

2. Создать папку

![image](https://user-images.githubusercontent.com/90458771/146663930-24a07aa5-1f07-4a8f-abf3-bf7299d915dc.png)

![image](https://user-images.githubusercontent.com/90458771/146663937-30960458-7f69-459f-86aa-765e61a09f34.png)

Как видим, создалась папка пользователя, в которой находится только что созданная папка testfolder1

![image](https://user-images.githubusercontent.com/90458771/146663947-7dc2f0d6-23bb-4287-b3aa-c820b4088ec3.png)

![image](https://user-images.githubusercontent.com/90458771/146663950-99334c04-5754-4f1d-96b1-b69a1c6038f9.png)

3. Удалить папку

![image](https://user-images.githubusercontent.com/90458771/146663998-ace1beee-f88e-4ea4-b650-105375ff495b.png)

![image](https://user-images.githubusercontent.com/90458771/146664000-e2ddeca9-f4a9-40d8-bcae-922616d19db9.png)

![image](https://user-images.githubusercontent.com/90458771/146664041-86536c15-c1b7-49fc-83be-605def329e42.png)

4/5. Переименовать и удалить файл

Для начала создадим файл testfile1:

![image](https://user-images.githubusercontent.com/90458771/146664076-57d00357-b473-4b97-93e2-a7b7c18a0439.png)

![image](https://user-images.githubusercontent.com/90458771/146664086-9720d98b-abc4-448a-8a7d-6553ef07be90.png)

![image](https://user-images.githubusercontent.com/90458771/146664081-1534d9b0-b168-4057-9fa6-8cb6708ad6c4.png)

Затем, переименовываем:

![image](https://user-images.githubusercontent.com/90458771/146664108-dcd68a6e-aa91-41ac-bd37-d9c16a1b9fc5.png)

![image](https://user-images.githubusercontent.com/90458771/146664110-1837b8a4-644c-4a8b-9228-5c751156ac93.png)

![image](https://user-images.githubusercontent.com/90458771/146664115-228fd72e-d68c-4795-8a41-cb94633f8abd.png)

И удаляем:

![image](https://user-images.githubusercontent.com/90458771/146664130-ebcb7d28-17d2-4bea-a622-25005554206c.png)

![image](https://user-images.githubusercontent.com/90458771/146664135-11a08f6e-402d-445d-a000-85e7ed074bd3.png)

![image](https://user-images.githubusercontent.com/90458771/146664139-4f229f5f-e845-498b-b0fd-13b6f5905463.png)

6. Скопировать файл с клиента на сервер

Создали новую папку:

![image](https://user-images.githubusercontent.com/90458771/146664277-84841a0a-5082-46b8-8736-8f86101ce8a7.png)

Отправляем туда заготовленный файл:

![image](https://user-images.githubusercontent.com/90458771/146664284-488cd556-c31f-46e3-a50d-09e6aca0cee5.png)

![image](https://user-images.githubusercontent.com/90458771/146664290-9373c3e5-b8a1-4c04-aa3a-c54a0d0bcc16.png)

![image](https://user-images.githubusercontent.com/90458771/146664301-fe328bf8-b60e-4873-8daa-0ce7c9658492.png)

7. Скопировать файл с сервера на клиент

Зашли в папку newtask и оттуда скопировали файл в рабочую директорию сервера

![image](https://user-images.githubusercontent.com/90458771/146664370-3cbdbc85-16a7-4777-9c28-c8f161e380ea.png)

![image](https://user-images.githubusercontent.com/90458771/146664374-3247dda3-5557-420e-b836-81684379b273.png)

![image](https://user-images.githubusercontent.com/90458771/146664385-7ddc6384-aa14-431a-a347-3777c2dbbe1a.png)

8. Выход (отключение клиента от сервера)

![image](https://user-images.githubusercontent.com/90458771/146664397-07136e6b-105b-4d7b-9396-4422a7850d0d.png)

exit отключает клиента от сервера




Дополнительные задания:

1. Ограничьте возможности пользователя рамками одной определенной директории. Внутри нее он может делать все, что хочет: создавать и удалять любые файлы и папки. Нужно проследить, чтобы пользователь не мог совершить никаких действий вне пределов этой директории. Пользователь, в идеале, вообще не должен догадываться, что за пределами этой директории что-то есть.

Из предыдущих заданий можем сделать вывод, что выйти за пределы корневой папки пользователь не может (для пользователя admin рабочей папкой является папка - корень сервера)

![image](https://user-images.githubusercontent.com/90458771/146664525-48494ac9-20b2-48bc-8281-494ce9922651.png)

![image](https://user-images.githubusercontent.com/90458771/146664532-716154b1-1bee-4b10-b036-d89981d558f5.png)

2. Добавьте логирование всех действий сервера в файл. Можете использовать разные файлы для разных действий, например: подключения, авторизации, операции с файлами.

Логирования всех действий сервера производится в файл log.txt:

![image](https://user-images.githubusercontent.com/90458771/146664564-dde10dc2-a5f7-4760-8a26-e9671be1de3f.png)

![image](https://user-images.githubusercontent.com/90458771/146664589-b0fb45ed-3b5d-4067-9ab9-066672e4bf2c.png)

3. Добавьте возможность авторизации пользователя на сервере.

Реализация представлена почти на каждом скриншоте:

![image](https://user-images.githubusercontent.com/90458771/146664635-6190817d-03ee-4f7b-bdf2-ff9030ef76d9.png)

4. Добавьте возможность регистрации новых пользователей на сервере. При регистрации для пользователя создается новая рабочая папка (проще всего для ее имени использовать логин пользователя) и сфера деятельности этого пользователя ограничивается этой папкой.

При регистрации каждый новый пользователь вводит логин и пароль

![image](https://user-images.githubusercontent.com/90458771/146664671-a94fa382-1ee4-492d-b23f-7a6b5cb45d29.png)

![image](https://user-images.githubusercontent.com/90458771/146664681-9551b864-1e13-48d8-8f07-1ee0a4ad9950.png)

Затем, создаётся его рабочая папка:

![image](https://user-images.githubusercontent.com/90458771/146664688-51185642-ca8e-412a-a54f-772ebc7318db.png)

Если пользователь уже существует, то проверяется правильность введённых данных (пример с неверно введённым паролем):

![image](https://user-images.githubusercontent.com/90458771/146664720-8fce435a-d2ba-4c97-ac2f-5861886a38d3.png)

![image](https://user-images.githubusercontent.com/90458771/146664738-5e2fb7e6-c535-4656-bc3c-911784fcfc3a.png)

5. Реализуете квотирование дискового пространства для каждого пользователя.

В пустую папку передаём файл размером до 10 мб (так как для каждого пользователя доступно только 10 мб)

![image](https://user-images.githubusercontent.com/90458771/146664907-452dc0f7-606a-4a82-b923-563f7e21c78e.png)

![image](https://user-images.githubusercontent.com/90458771/146664914-07531c54-98fb-4cb5-8579-216c623d136d.png)

А теперь попробуем передать файл размером более 10 мб:

![image](https://user-images.githubusercontent.com/90458771/146664931-879a6386-c22b-47a4-b71f-b5725d23281b.png)

![image](https://user-images.githubusercontent.com/90458771/146664940-c3ac4596-9a01-4e32-a36c-b7a8e65e50d5.png)

Получили ошибку (недостаточно места)

6. Реализуйте учётную запись администратора сервера.

log/pass = admin/admin. Тут рабочая директория - рабочая директория сервера, то есть папка с папками пользователей

7. Напишите отладочный клиент. Клиент должен подключаться к серверу и в автоматическом режиме тестировать корректность его работы. Используйте подход, аналогичный написанию модульных тестов. Клиент должен вывести предупреждающее сообщение, если сервер работает некорректно.

![image](https://user-images.githubusercontent.com/90458771/146665005-c6f83774-6385-4fc5-89dc-30bd81dff6f1.png)
