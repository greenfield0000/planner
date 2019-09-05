# Проект "Доставка еды"

## Запуск и сборка
Запуск осуществляется поседством скрипта, который имеет название **runner.sh**.
Изначально требуется дать права.
### Выдача прав
Права стоит выдавать в случае, если не хочется каждый раз запускать через sudo. В терминал набираем команду:

	sudo chmod +x ./builder.sh && sudo chmod +x ./runner.sh

### Сборка

Сборка делится на 2-е фазы:
+ Сборка сервисной части:
	maven 3+
	java 8
+ Сборка образов на основе исходных файлов

Обе фазы последовательно выполняются скриптом **./builder.sh** или **sh ./builder.sh**


### Запуск

После того, как назначите права (предыдущий пункт не является обязательным), скрипт можно запустить. 
Во время выполнения вам придется набирать необходимый вам пункт. Для запуска пропишите в терминале одну из команд:

	sh runner.sh или ./runner.sh
### Заполнение первоначальными данными
Если все сервисы успешно стартовали, с помощью модуля dbmigration необходимо накатить обновление на первоначальную структуру меню и журналов (их метаданные). Достаточным условием для применения изменений - запущенная база данных metadata-db.

### Схема микросервисов
Описание основных сервисов:
1. B2B-FRONT. Angular 2-7.
2. Gateway. Spring Boot 3.
3. Auth-service. Spring Boot 3.
4. Menu-service. Spring Boot 3.
5. Journal-service. Spring Boot 3.
6. Kladr-service. Spring Boot 3.
Описание основных БД:
1. Auth-db. Mysql 8.0.17-1debian9
2. Metadata-db. 4.2.0
3. Redis-session-db. Redis 5.0.5
Сборка и деплой:
1. Docker 19.03.1
2. Docker-compose 1.17.1

Ниже представлена схема взаимодействия микросервисов и бд.

<p align="center">
  <img src="https://github.com/greenfield0000/deliveryfood/blob/master/microservices-diagram.jpg" alt="alternate text">
</p>
