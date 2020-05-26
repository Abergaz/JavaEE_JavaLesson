package ee.ejb.bean;

import ee.ejb.HelloWorldEjb;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.WebServiceRefs;

@Singleton
public class ExampleBean{
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    EntityManager entityManager;
    @EJB
    HelloWorldEjb helloWorldEjb;
    @Inject
    MyRequestScope myRequestScope;
    @Resource
    SessionContext sessionContext;
    @WebServiceRef
    MyWebService myWebService;

   public String getName(){
       /** sessionContext cпециальный объект котороый позволяет контролирвать поведение EJB бина */
       return "Max";
   }
}

/** обычный бин */
@RequestScoped
class MyRequestScope{}
/** web service*/
@WebService
class MyWebService{

}