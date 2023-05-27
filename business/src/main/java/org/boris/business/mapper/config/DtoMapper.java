package org.boris.business.mapper.config;

import java.util.List;
import java.util.Set;

public interface DtoMapper<S, T> {

    /**
     * This method maps passed as argument entity object to a dto.
     *
     * @param entity must not be null
     * @return mapped dto
     */
    S toDto(T entity);

    /**
     * This method maps passed as argument set of entities to set of dtos.
     *
     * @param entitySet must not be null
     * @return mapped set of dtos
     */
    Set<S> toDtoSet(Set<T> entitySet);

    /**
     * This method maps passed as argument list of entities to list of dtos.
     *
     * @param entityList must not be null
     * @return mapped set of dtos
     */
    List<S> toDtoList(List<T> entityList);
}