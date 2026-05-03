package com.turkcell.library_management_cqrs.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_management_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.library_management_cqrs.core.mediator.Mediator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/categories")
public class CatgeoriesController {
    private final Mediator mediator;

    public CatgeoriesController(Mediator mediator) {
        this.mediator = mediator;
    }
    

    @PostMapping
    public String create(@RequestBody CreateCategoryCommand command) {

        return mediator.send(command);
    }
    


}
