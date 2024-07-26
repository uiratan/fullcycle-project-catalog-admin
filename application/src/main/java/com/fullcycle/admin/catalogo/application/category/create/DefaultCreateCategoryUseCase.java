package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.domain.category.Category;
import com.fullcycle.admin.catalogo.domain.category.CategoryGateway;
import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {
  final private CategoryGateway categoryGateway;

  public DefaultCreateCategoryUseCase(CategoryGateway categoryGateway) {
    this.categoryGateway = Objects.requireNonNull(categoryGateway);
  }

  @Override
  public CreateCategoryOutput execute(CreateCategoryCommand aCommand) {
    final var aName = aCommand.name();
    final var aDescription = aCommand.description();
    final var anInActive = aCommand.isActive();
    final var aCategory = Category.newCategory(aName, aDescription, anInActive);

    final var unicoValidatorHandlerImplementado = new ThrowsValidationHandler();
    aCategory.validate(unicoValidatorHandlerImplementado);

    final var categoryCreated = this.categoryGateway.create(aCategory);
    return CreateCategoryOutput.from(categoryCreated);
  }
}
