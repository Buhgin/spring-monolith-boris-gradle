package org.boris.business.model.enums.sort;

import org.springframework.data.domain.Sort;

public enum SortType {
    ASC(Sort.Direction.ASC),

    DESC(Sort.Direction.DESC);


    private final Sort.Direction direction;


    SortType(Sort.Direction direction) {
        this.direction = direction;
    }

    public Sort.Direction getDirection() {
        return direction;
    }


}
