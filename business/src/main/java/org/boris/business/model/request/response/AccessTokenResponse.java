package org.boris.business.model.request.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "AccessTokenResponse", description = "Access token response object")
public record AccessTokenResponse(
        @Schema(description = "Access token", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGV4YW1wbGUuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sIm")
        String accessToken

) {
}
