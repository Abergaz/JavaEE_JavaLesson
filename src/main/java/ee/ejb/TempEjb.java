package ee.ejb;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/** @Stateless  испольщуется 1 раз и не хранит состояние, нет свойств, только методы, реализующие какую-то логику */
/** @Stateful  может хранить состояние в течении сессии, имеет свойства и изменяет их в резульатате работы методов */
/** @Singleton один бин на все приложение */
public class TempEjb {

}
