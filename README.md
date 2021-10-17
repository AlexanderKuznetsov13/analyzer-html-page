# analyzer-html-page
Test project for Simbirsoft company. 

## Что использовалось 
- spring boot
- liquibase (для разворачивания БД)
- slf4j (логирование)
- postman (для тестирования)
- postgresql (храние данные)
- junit (тесты)
- jsoup (парсинг HTML DOM дерева)


# Requirements (in Russian):**

###### Что мы хотим от вас получить

Приложение, которое позволяет парсить произвольную HTML-страницу и выдает статистику по количеству уникальных слов.

###### Требования к приложению
1. В качестве входных данных приложение принимает строку с адресом
   web-страницы. Пример входной строки: https://www.simbirsoft.com/
2. Приложение разбивает текст страницы на отдельные слова с помощью
   списка разделителей.
   Пример списка:
   `{' ', ',', '.', '! ', '?','"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'}`
3. В качестве результата работы пользователь должен получить статистику по
   количеству уникальных слов в тексте.
   Пример:
   РАЗРАБОТКА -1
   ПРОГРАММНОГО - 2
   ОБЕСПЕЧЕНИЯ - 4
4. При разработке позволяется использовать сторонние библиотеки.
5. Приложение написано в соответствии с принципами ООП
6. Приложение написано на языке выбранного направления (Java, C#, Golang)
   Что нам понравится в приложении
   Для зачисления достаточно, если ваше приложение работает и
   имеет более одного класса, но стоит учитывать ограниченное количество мест, поэтому хорошим бонусом будет:
1. Хороший стиль кода, приближенный к общепринятым стандартам
   форматирования кода
2. Использование паттернов проектирования
3. Логирование ошибок в файл
4. Сохранение статистики в базу данных.
5. Возможность расширяемости проекта и многоуровневую архитектуру
6. Тесты


## Инструкция 

- Перед запуском приложения, нужно создать PosgreSQL БД в PgAdmin: pageanalyzer
- После выполнить mvn clean install
- Поправить credentials в src/main/resources/liquibase.properties (default password: **_adminadmin_**
- Запуск приложения как spring-boot 
```
mvn spring-boot:run
```


- Приложение принимает полноценный адрес html-страницы, например, https://www.simbirsoft.com/
Postman файл приложен к репозиторию

Возможные запросы:
```
http://localhost:8080/statistic/analyzeByURL?url=https://www.simbirsoft.com/
```

Структура страницы парсится используя библиотеку **jsoup**, уникальные слова сохраняются в таблице БД

**Структура таблицы**

```sql
CREATE TABLE pageanalyzer.pages (
id              INTEGER NOT NULL DEFAULT nextval('pageanalyzer.pages_seq'),
url             VARCHAR(1000)    NOT NULL,
statistic       text,
CONSTRAINT pages_id_pk PRIMARY KEY (id)
);

COMMENT ON TABLE pageanalyzer.pages IS 'List of pages';
COMMENT ON COLUMN pageanalyzer.pages.id IS 'ID';
COMMENT ON COLUMN pageanalyzer.pages.url IS 'URL of page';
COMMENT ON COLUMN pageanalyzer.pages.statistic IS 'statistic of page';
```

**Получение всех статистик**
```
http://localhost:8080/statistic/all
```
