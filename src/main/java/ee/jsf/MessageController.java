package ee.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class MessageController {
    String message;

    public MessageController(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    FacesContext facesContext = FacesContext.getCurrentInstance();
    public void doJob(){
        if (message.equals("error")){
            facesContext.addMessage("message", new FacesMessage(FacesMessage.SEVERITY_WARN,"empty message","message was empty"));
        }
    }
}
