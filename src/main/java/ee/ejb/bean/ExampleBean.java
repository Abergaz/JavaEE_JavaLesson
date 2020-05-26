package ee.ejb.bean;

import javax.annotation.Resource;
/** настройка бина описана в web/WEB-INF/ejb-jar.xml*/
public class ExampleBean{
    @Resource /** инжектим значение из xml настройки бина*/
    Double currencyRate;
   public String getName(){
       return "Max " +currencyRate;
   }
}
