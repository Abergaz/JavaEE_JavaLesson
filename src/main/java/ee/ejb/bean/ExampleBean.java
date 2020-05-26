package ee.ejb.bean;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.*;
@Singleton
@RolesAllowed({"root","admin"})
@DenyAll /** запретить всем */
@PermitAll /** разрешить всем */
@RunAs("inventoryDpt") /** запускатть от имени указанной роли*/
public class ExampleBean {
    @Resource
    SessionContext sessionContext;
    public String getName() {
        if (sessionContext.isCallerInRole("root")){
            return "root";
        }
        return "Max ";
    }
}
