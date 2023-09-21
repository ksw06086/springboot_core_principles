package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class AppInitV1Servlet implements AppInit{
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartup");
        
        // 순수 서블릿 코드 등록(HelloServlet 클래스에는 Mapping 안해줬는데 여기서 설정해주는 방법)
        // 유연성이 제공됨 -> 내가 원하는 조건에 맞춰 경로를 바꿔줄 수 잇다.
        ServletRegistration.Dynamic helloServlet =
                servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello-servlet");
    }
}
