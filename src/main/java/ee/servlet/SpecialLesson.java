package ee.servlet;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/specExample")
public class SpecialLesson  extends HttpServlet {
    @Inject
    A a;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        a.print();
    }
}

interface A {
    void  print();
}
class B implements A{
    @Override
    public void print() {
        System.out.println("B");
    }
}
@Specializes /** говорит что именно  эта реализация будет инжекстится по уполчанию */
class C extends B{
    @Override
    public void print() {
        System.out.println("C");
    }
}