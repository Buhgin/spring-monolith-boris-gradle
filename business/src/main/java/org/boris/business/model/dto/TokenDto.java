package org.boris.business.model.dto;

public record TokenDto(
                       String token,
                       AuthDetailsDto authDetailsDto) {
}
