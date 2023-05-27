package org.boris.business.model.enums.sort;

public enum PostSort {
    ID("id"),
    TITLE("title"),
    CONTENT("content"),
    DESCRIPTION("description");

    public String getAttribute() {
        return attribute;
    }

    private final String attribute;
    PostSort(String sort) {
    this.attribute= sort;
    }
}
