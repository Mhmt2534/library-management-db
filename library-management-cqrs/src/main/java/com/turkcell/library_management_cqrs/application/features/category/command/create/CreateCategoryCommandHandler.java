package com.turkcell.library_management_cqrs.application.features.category.command.create;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.turkcell.library_management_cqrs.core.mediator.cqrs.Command;
import com.turkcell.library_management_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, String>{

 

    @Override
    public String handle(CreateCategoryCommand command) {
        
        UUID uuid = UUID.randomUUID();

        return "Kitap başarıyla eklendi! " + uuid;
    }

   
 
}
