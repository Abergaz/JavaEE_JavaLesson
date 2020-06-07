package ee.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Navigate {
    public String goToNextPage(){
        return "NewPage.xhtml";
    }
}
