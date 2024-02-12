package br.com.rsousa.raceresultsservice.infra;

import br.com.rsousa.raceresultsservice.dtos.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(exception.getMessage(), 400));
    }
}
