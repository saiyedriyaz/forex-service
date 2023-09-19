package com.github.saiyedriyaz.service.forex.currency.domain.internal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangedAmount {
    private String amount;
    private ConversionRate conversionRate;
}
