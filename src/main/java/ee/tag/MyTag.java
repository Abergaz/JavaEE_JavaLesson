package ee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTag extends SimpleTagSupport {
    /** атрибут тега*/
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().print("hello world ");
        getJspContext().getOut().print(name);
        getJspBody().invoke(null);
        getJspContext().setAttribute("one","value");
    }
}
