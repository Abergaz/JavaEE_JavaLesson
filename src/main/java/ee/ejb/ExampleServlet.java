package ee.ejb;

import ee.ejb.bean.ExampleBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@WebServlet("/ejbExample")
public class ExampleServlet extends HttpServlet {
    @EJB
    ExampleBean exampleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** так работать не будет, т.к. севрлеты не работают в многопоточном режиме
        resp.getWriter().write(exampleBean.setI(exampleBean.getI() + 1)); */
        /** для того чтобы работало необходимо увеличение i перенести в bean*/
        resp.getWriter().write(exampleBean.increaseI());
        /** тогда 1000 потоков вернет 1000 цыфр, т.к. EJB потокобезопасны их контролирует контуйнер*/
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                URLConnection urlConnection = null;
                try {
                    urlConnection = new URL("http://localhost:8080/ejbExample").openConnection();
                    Scanner scanner = new Scanner(urlConnection.getInputStream());
                    while (scanner.hasNext()) {
                        System.out.println(scanner.next());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();;
        }
    }
}
