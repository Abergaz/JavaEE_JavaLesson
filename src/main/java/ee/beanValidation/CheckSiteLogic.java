package ee.beanValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckSiteLogic implements ConstraintValidator<CheckSiteURL, String> {
    int port;
    String host;
    String protocol;

    @Override
    public void initialize(CheckSiteURL constraintAnnotation) {
        /** инициализируем доп поля из нашей анатации*/
        port = constraintAnnotation.port();
        host =constraintAnnotation.host();
        protocol = constraintAnnotation.protocol();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value==null || value.equals("")){
            return true; /** считаем что? если Null или пусто то норм, т.к. если нужна проверка на Null вешаем анатацию @NotNull*/
        }
        java.net.URL url;
        try {
            url = new URL(value);
        }catch (MalformedURLException e){
            return false; /** URL не разрешается, выдаем false - проверка не пройдена*/
        }
        /** проверяем доп поля аннатоции */
        if (protocol!=null && protocol.length()>0 && !protocol.equals(url.getProtocol())){
            /** можем переопределить сообщение об ошибке, которая описана в аннотации */
            context.disableDefaultConstraintViolation();/**отключили дефолтное*/
            context.buildConstraintViolationWithTemplate("protocol invalid").addConstraintViolation();/** записали новое */
            return false;
        }
        if (host!=null && host.length()>0 && !host.equals(url.getHost())){
            /** можем переопределить сообщение об ошибке, которая описана в аннотации */
            context.disableDefaultConstraintViolation();/**отключили дефолтное*/
            context.buildConstraintViolationWithTemplate("host invalid").addConstraintViolation();/** записали новое */
            return false;
        }
        if (port!=-1 && port != url.getPort() ){
            /** можем переопределить сообщение об ошибке, которая описана в аннотации */
            //context.disableDefaultConstraintViolation();/**отключили дефолтное*/
            //context.buildConstraintViolationWithTemplate("port invalid").addConstraintViolation();/** записали новое */
            return false;
        }
        return true;
    }
}
