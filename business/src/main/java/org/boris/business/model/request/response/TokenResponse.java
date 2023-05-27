package org.boris.business.model.request.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "TokenResponse", description = "Access and refresh token response object")
public record TokenResponse(
        @Schema(description = "Access token", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGV4YW1wbGUuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sIm")
        String accessToken,
        @Schema(description = "Refresh token", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGV4YW1wbGUuY29tIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sIm")
        String refreshToken
) {
}
