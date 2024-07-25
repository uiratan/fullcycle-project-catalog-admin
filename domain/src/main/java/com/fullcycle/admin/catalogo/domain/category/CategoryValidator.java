package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

  public static final int NAME_MAX_LENGTH = 255;
  public static final int NAME_MIN_LENGTH = 3;
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
    if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
      Error error = new Error("'name' must be between 3 and 255 characters");
      this.validationHandler().append(error);
      return;
    }
  }
}
