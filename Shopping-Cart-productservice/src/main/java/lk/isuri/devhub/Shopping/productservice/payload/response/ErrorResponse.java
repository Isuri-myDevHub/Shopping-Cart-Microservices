package lk.isuri.devhub.Shopping.productservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ErrorResponse class represents the structure of the response sent for error scenarios.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String errorMessage;  // Holds the detailed error message
    private String errorCode;     // Represents a code associated with the specific error
}
