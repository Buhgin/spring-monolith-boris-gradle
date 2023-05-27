package org.boris.business.model.enums.sort;

public enum CommentSort {
    ID("id"),
    NAME("name"),
    EMAIL("email"),
    BODY("body");


    public String getAttribute() {
        return attribute;
    }

    private final String attribute;

    CommentSort(String sort) {
        this.attribute = sort;
    }
}
