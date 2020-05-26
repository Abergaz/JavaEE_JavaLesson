package ee.ejb.bean;

import javax.ejb.*;
import java.util.concurrent.TimeUnit;

@Singleton
@Lock(LockType.WRITE) /** управляет потокобезопсностью, блокируется запись, изенение данных бина*/
@AccessTimeout(value = 5,unit = TimeUnit.SECONDS)/** разлочить bean, если он не разлочиться сам чрере 5 секунд */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)/** по умолчанию, блокировкой управляет контейнер, если bean то мы должны сами контролировать вручную через synchronized и т.д*/
public class ExampleBean{
    int i;

    @Lock(LockType.READ) /** разрешаем этому методу чтение при многопоточности*/
    public int getI() {
        return i;
    }

    public int setI(int i) {
        return this.i = i;
    }
    public int increaseI(){
        return ++i;
    }
}
