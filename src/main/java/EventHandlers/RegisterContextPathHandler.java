package EventHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
public class RegisterContextPathHandler {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @EventListener
    public void handlerRefreshApplicationContext(ContextRefreshedEvent refreshedEvent){
        webApplicationContext.getServletContext().setInitParameter("context",webApplicationContext.getServletContext().getContextPath());
        System.out.println("!! Initiating ContextRefreshedEvent Listner !!");
    }
}
