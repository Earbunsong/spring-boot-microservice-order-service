package co.dev.kh.orderservice.external.decoder;

import co.dev.kh.orderservice.exception.CustomException;
import co.dev.kh.orderservice.external.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        ObjectMapper objectMapper
                = new ObjectMapper();

        log.info("::{}", response.request().url());
        log.info("::{}", response.request().headers());

        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(),
                    ErrorResponse.class);

            return new CustomException(errorResponse.getErrorCode(),
                    errorResponse.getErrorMessage(),
                    response.status());

        } catch (IOException e) {
            throw new CustomException("Internal Server error","INTERNAL SERVER ERROR",500);
        }
    }
}
