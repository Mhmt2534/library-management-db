package com.turkcell.library_management_cqrs.core.mediator;

import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import com.turkcell.library_management_cqrs.core.mediator.cqrs.Command;
import com.turkcell.library_management_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_management_cqrs.core.mediator.cqrs.Query;
import com.turkcell.library_management_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class SpringMediator implements Mediator{
    private final ApplicationContext applicationContext;

    public SpringMediator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <R> R send(Command<R> command) {
        var handler = (CommandHandler<Command<R>, R>) resolveHandler(command.getClass(), CommandHandler.class);

        return handler.handle(command);
    }

    @Override
    public <R> R send(Query<R> query) {
        var handler = (QueryHandler<Query<R>, R>) resolveHandler(query.getClass(), QueryHandler.class);

        return handler.handle(query);
    }



    private Object resolveHandler(Class<?> requestType, Class<?> handlerInterface){
        // ResolvableType handleryType = ResolvableType.forClassWithGenerics(handlerInterface, 
        //     ResolvableType.forClass(requestType),
        // ResolvableType.NONE);

        
        String[] beans = applicationContext.getBeanNamesForType(handlerInterface);

         for (String beanName : beans) {
        Object bean = applicationContext.getBean(beanName);

        ResolvableType type = ResolvableType.forClass(bean.getClass()).as(handlerInterface);

        Class<?> handledRequestType = type.getGeneric(0).resolve();

        if (handledRequestType != null && handledRequestType.equals(requestType)) {
            return bean;
        }
    }

    throw new IllegalStateException("Handler bulunamadı: " + requestType.getSimpleName());
    }

}
