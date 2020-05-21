package ee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/** Фильтр можно определить черех ааннотаицю, а не только web.xml */
@WebFilter(value="/FilterServlet", initParams = {@WebInitParam(name = "name",value = "Макс")})
public class MyNewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /** Читаем параметр определенный в web.xml  в фильтре */
        System.out.println(filterConfig.getInitParameter("name"));
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write("doFilter start");
        /** провряем какое-то условие и если все хрошо выполняем запрос */
        if(true){
            chain.doFilter(request,response);
        }else{
            /** иначе тоже что-то выолняем*/
        }
        response.getWriter().write("doFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
