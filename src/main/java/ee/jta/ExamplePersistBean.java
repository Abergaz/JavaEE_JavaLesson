package ee.jta;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
/** используетя по умолчанию
 REQUIRED - говорит о том что не создавать еще одну транзакцию, если уже выше была создана транзакия
 REQUIRED_new - создает на вес отделтные транзакции
 SUPPORTS -будет использовать транзакцию если она была создана
 MANDATORY -
 NOT_SUPPORTED не использует транзакции
  */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ExamplePersistBean {
    @PersistenceContext
    EntityManager entityManager;
    @Resource
    SessionContext sessionContext;/** инжектим контекст для управления транзакциями */
    public void saveStudent(){
        entityManager.persist(new Student("Max"));
        sessionContext.setRollbackOnly(); /** откатываем транзакцию*/
        throw  new RuntimeException(); /** при выбрасывании RuntimeException транзакция тоже откатывается */

    }
}

/** при проверяемых исключенях транзакци не откатываются,
  но можно создать свое проверяемое исключени и пометить аннотацией  */
@ApplicationException(rollback = true)
class MyException extends Exception{

}
