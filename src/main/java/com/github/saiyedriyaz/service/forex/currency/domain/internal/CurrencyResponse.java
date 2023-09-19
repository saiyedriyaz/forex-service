package com.github.saiyedriyaz.service.forex.currency.domain.internal;

import com.github.saiyedriyaz.service.forex.currency.constants.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CurrencyResponse {
    public CurrencyResponse() {
    }

    private Currency[] currencies;
}
