1. Почему на любом объекте можем вызвать метод getClass()?
   Метод getClass() является частью класса Object, который является суперклассом для всех классов
2. Почему на любом классе можем вызвать .class?
   .class — это синтаксический сахар, позволяющий получить объект Class, 
    представляющий метаинформацию о классе. Он доступен для любого класса, потому что в Java классы являются объектами, 
    и каждый класс в Java имеет свою метаинформацию, представленную объектом типа Class
3. В чём отличие динамического прокси от статического?  Приведите преимущества и недостатки.
   Динамическое прокси и статическое прокси — это два подхода для создания прокси-объектов, которые представляют собой объекты, перехватывающие вызовы методов других объектов.
    Динамическое прокси:
    
    Это прокси-объекты, которые создаются во время выполнения с использованием механизма рефлексии.
    Используется интерфейс для создания прокси-объекта. Прокси реализует интерфейс, который передается в момент создания.
    Динамическое прокси позволяет создавать прокси для любого интерфейса в Java в реальном времени.
    Пример: Proxy.newProxyInstance() из пакета java.lang.reflect.
    Преимущества:
    Гибкость: можно создавать прокси на лету для любых интерфейсов.
    Не требует изменения исходного класса.
    Недостатки:
    Нужно работать с рефлексией, что может повлиять на производительность.
   Статическое прокси:

    Это прокси-объекты, которые создаются во время компиляции и требуют явного написания класса прокси.
    Статический прокси класс реализует интерфейсы или наследует конкретные классы и переопределяет их методы.
    Такой прокси компилируется и фиксирован на этапе написания кода.
    Преимущества:
    Быстрее, чем динамическое прокси, так как нет необходимости использовать рефлексию.
    Прокси объект может работать с конкретными методами.
    Недостатки:
    Требует явного написания классов и методов, что делает его менее гибким.
    Нужно создавать отдельный класс прокси для каждого класса или интерфейса.

