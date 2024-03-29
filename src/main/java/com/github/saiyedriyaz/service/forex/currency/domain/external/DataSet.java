package com.github.saiyedriyaz.service.forex.currency.domain.external;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
public class DataSet {
    private String structureRef;
    private String setID;
    private String action;
    private String validFromDate;

    @JacksonXmlProperty(localName = "Series")
    Series series;
}
