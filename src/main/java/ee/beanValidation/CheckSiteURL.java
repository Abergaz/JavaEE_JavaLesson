package ee.beanValidation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CheckSiteLogic.class})
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckSiteURL {
    String message() default "wrong URL";/** сообщение об ошибке если не прошли валидацию*/
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    /**  дополнительные поля для проверки*/
    int port() default  -1;
    String host() default "";
    String protocol() default "";
}
