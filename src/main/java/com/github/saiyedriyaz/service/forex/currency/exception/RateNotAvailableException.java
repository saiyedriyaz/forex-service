package com.github.saiyedriyaz.service.forex.currency.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RateNotAvailableException extends Exception {
    private String date;
}
