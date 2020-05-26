package ee.ejb.bean;

import javax.ejb.*;
import javax.ws.rs.core.Feature;
import java.util.concurrent.Future;

@Singleton
@Asynchronous /** можно поставить на клвсс или метод */
public class ExampleBean{

   public void getName(){
       /** эмитируем долгую работу*/
       try {
           Thread.sleep(100_000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
   /** если нужен возвращамый результат из асинхронного метода */
   public Future<String> getMyName(){
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return new AsyncResult<String>("Max");
   }
}
