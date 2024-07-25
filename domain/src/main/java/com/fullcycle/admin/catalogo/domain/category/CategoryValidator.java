package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

  private final Category category;

  public CategoryValidator(final Category category, final ValidationHandler aHandler) {
    super(aHandler);
    this.category = category;
  }

  @Override
  public void validate() {
    checkNameConstraints();
  }

  private void checkNameConstraints() {
    final var name = this.category.getName();
    if (name == null) {
      Error error = new Error("'name' should not be null");
      this.validationHandler().append(error);
      return;
    }

    if (name.isBlank()) {
      Error error = new Error("'name' should not be empty");
      this.validationHandler().append(error);
      return;
    }

    final int length = name.trim().length();
    if (length > 255 || length < 3) {
      Error error = new Error("'name' must be between 3 and 255 characters");
      this.validationHandler().append(error);
      return;
    }
  }
}
