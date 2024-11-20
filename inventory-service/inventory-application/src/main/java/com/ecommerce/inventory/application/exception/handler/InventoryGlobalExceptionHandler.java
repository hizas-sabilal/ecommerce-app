package com.ecommerce.inventory.application.exception.handler;

import com.ecommerce.application.handler.ErrorDTO;
import com.ecommerce.application.handler.GlobalExceptionHandler;
import com.ecommerce.inventory.domain.exception.InventoryDomainException;
import com.ecommerce.inventory.domain.exception.InventoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class InventoryGlobalExceptionHandler extends GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = {InventoryDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(InventoryDomainException inventoryDomainException) {
        log.error(inventoryDomainException.getMessage(), inventoryDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(inventoryDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {InventoryNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(InventoryNotFoundException inventoryNotFoundException) {
        log.error(inventoryNotFoundException.getMessage(), inventoryNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(inventoryNotFoundException.getMessage())
                .build();
    }
}
