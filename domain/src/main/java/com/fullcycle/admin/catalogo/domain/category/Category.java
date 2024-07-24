package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.AggregateRoot;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {

  private String name;
  private String description;
  private boolean active;
  private Instant createdAt;
  private Instant updatedAt;
  private Instant deletedAt;

  private Category(
          final CategoryID anId,
          final String aName,
          final String aDescription,
          final boolean isActive,
          final Instant aCreationdAt,
          final Instant aUpdateAt,
          final Instant aDeleteAt
  ) {
    super(anId);
    this.name = aName;
    this.description = aDescription;
    this.active = isActive;
    this.createdAt = aCreationdAt;
    this.updatedAt = aUpdateAt;
    this.deletedAt = aDeleteAt;
  }

  public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
    final var id = CategoryID.unique();
    final var now = Instant.now();
    return new Category(id, aName, aDescription, isActive, now, now, null);
  }

  public CategoryID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isActive() {
    return active;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Instant getDeletedAt() {
    return deletedAt;
  }
}
