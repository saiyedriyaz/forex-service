package com.github.saiyedriyaz.service.forex.currency.domain;

import com.github.saiyedriyaz.service.forex.currency.domain.external.*;
import com.github.saiyedriyaz.service.forex.currency.domain.internal.CurrencyConversionRates;
import com.github.saiyedriyaz.service.forex.currency.constants.Currency;
import com.github.saiyedriyaz.service.forex.currency.domain.internal.ConversionRate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SchemaTransformer {
    private static final String BBK_STD_CURRENCY = "BBK_STD_CURRENCY";

    public static CurrencyConversionRates transform(GenericData genericData) {
        var currencyConversionRates = new CurrencyConversionRates(new ArrayList<>());
        var series = extractSeries(genericData);
        var obsList = extractObsList(series);
        if (!obsList.isEmpty()) {
            currencyConversionRates.getConversionRateList().addAll(
                    obsList.stream().map(e -> constructObject(series, e)).collect(Collectors.toList()));
        }
        return currencyConversionRates;
    }

    private static Series extractSeries(GenericData genericData) {
        Optional<DataSet> dataset = Optional
                .ofNullable(genericData)
                .map(o -> Optional.ofNullable(o.getDataSet()).orElse(DataSet.builder().build()));

        Optional<Series> series = Optional.empty();
        if (dataset.isPresent()) {
            series = dataset.map(o -> Optional.ofNullable(o.getSeries())).get();
        }
        return series.orElse(Series.builder().build());
    }

    private static String extractSeriesValue(List<Value> valueList, String key) {
        return valueList.stream().filter(v -> key.equals(v.getId())).findFirst().orElse(new Value()).getValue();
    }

    private static List<Obs> extractObsList(Series series) {
        return Optional.ofNullable(series)
                .map(o -> Optional.ofNullable(o.getObsList()).orElse(new ArrayList<>()))
                .orElse(new ArrayList<>());
    }

    private static ConversionRate constructObject(Series series, Obs e) {
        return new ConversionRate(
                Optional.ofNullable(e.getObsValue()).orElse(new ObsValue("No value available")).getValue(),
                Optional.ofNullable(e.getObsDimension()).orElse(new ObsDimension()).getValue(),
                Currency.valueOf(extractSeriesValue(series.getSeriesKey().getValueList(), BBK_STD_CURRENCY)));
    }
}
