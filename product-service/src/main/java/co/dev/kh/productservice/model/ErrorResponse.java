package co.dev.kh.productservice.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
     private String errorMessage;
     private String errorCode;
}
