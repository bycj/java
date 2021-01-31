//package xinan.demo.baselearn.config;
//
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author he peng
// * @date 2018/10/2
// */
//public class DemoFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//
//        // TODO do something
//        BodyCachingHttpServletResponseWrapper responseWrapper =
//                new BodyCachingHttpServletResponseWrapper((HttpServletResponse) response);
//
//        chain.doFilter(request , responseWrapper);
//
//        byte[] responseBody = responseWrapper.getBody();
//        // TODO do something
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}