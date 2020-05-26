package ee.jta;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
    public void saveStudent(){
        entityManager.persist(new Student("Max"));
    }
}
