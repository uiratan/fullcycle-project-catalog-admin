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
    if (isNameEmpty()) {
      Error error = new Error("'name' should not be null");
      this.validationHandler().append(error);
    }
  }

  private boolean isNameEmpty() {
    return this.category.getName() == null;
  }
}
