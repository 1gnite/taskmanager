# taskmanager
Учебное приложение. Выполняется на каркасе Spring(MVC, Security)+Hibernate+Tiles

Приложение представляет из себя простенький менеджер задач. Пишется в учебных целях и для предоставления кода на собеседованиях 
на позицию Junior Java Developer :) 

Каркас приложения: Spring MVC (xml-конфиг)
- Управление авторизацией: Spring Security
- Доступ к БД: Hibernate (аннотации)
- Используемая СУБД: MySQL 5
- Фронт-энд: JSP, немного JSTL и Spring Tags (forms, security)
- Конечные страницы формируются по шаблонам Apache Tiles 3

Функционал:
* Регистрация/авторизация с валидацией данных (JSR 303) (done)
** Проверка на существующий в БД e-mail (TODO)
* Разделение ролей пользователей на user и admin (done)
* Админ. панель с просмотром зарегистрированных пользователей и возможностью их удаления (done)
* Создание тематических категорий/подкатегорий для группировки задач (done)
* Реализовано в виде дерева, пока что 2х-уровневая иерархия (root-категории и их ноды). (done) 
* На уровне java-кода иерархия не ограничена, 2 уровня взял для более-менее корректного отображения в боковой панели 
(больше уровней - более широкая панель, тут у меня начинаются проблемы с корректным отображением всего этого в html/css :) )
* Создание задач (название, степень "важности", отображаемая цветными маркерами, дата создания, дата планируемого окончания) (TODO)
* Навигация по времени планируемого окончания задач (сегодня/завтра/неделя/...) (TODO)
* Возможность загружать пользовательские аватары, отображаемые в дальнейшем в header-панели (TODO)
* Восстановление пароля по email (TODO)
* Расшаривание задач (TODO)
* ...

Заметки по использованию:
* При регистрации сразу присваивается роль admin (для возможности просмотра админ. панели). Удаление юзеров ограничено по user-роли, 
и т.к. все пользователи имеют admin-роль, удаление не происходит.
* Поскольку приложение развернуто на бесплатном хостинге, первоначальная загрузка может длиться дольше обычного.

Развернутое приложение посмотреть можно тут: http://taskmgr.jelastic.regruhosting.ru/