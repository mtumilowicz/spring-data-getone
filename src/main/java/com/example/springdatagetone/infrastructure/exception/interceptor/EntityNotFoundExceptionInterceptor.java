package com.example.springdatagetone.infrastructure.exception.interceptor;

import com.example.springdatagetone.infrastructure.exception.json.ApplicationExceptionAsJSON;
import com.google.common.base.Preconditions;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.nonNull;

/**
 * Created by mtumilowicz on 2018-07-25.
 */
@ControllerAdvice
class EntityNotFoundExceptionInterceptor {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    ApplicationExceptionAsJSON entityNotFoundException(@NonNull HttpServletRequest request,
                                                       @NonNull EntityNotFoundException ex) {
        Preconditions.checkArgument(nonNull(request.getRequestURI()));
        Preconditions.checkArgument(nonNull(ex.getLocalizedMessage()));

        return ApplicationExceptionAsJSON.builder()
                .url(request.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
    }
}
