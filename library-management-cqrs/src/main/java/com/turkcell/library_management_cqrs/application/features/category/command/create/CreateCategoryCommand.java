package com.turkcell.library_management_cqrs.application.features.category.command.create;

import java.util.UUID;

import com.turkcell.library_management_cqrs.core.mediator.cqrs.Command;

public record CreateCategoryCommand(String name) implements Command<String> {}
