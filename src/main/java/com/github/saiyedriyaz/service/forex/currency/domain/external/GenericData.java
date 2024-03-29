package com.github.saiyedriyaz.service.forex.currency.domain.external;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@JacksonXmlRootElement(localName = "GenericData")
@Jacksonized
public class GenericData {
    private String schemaLocation;

    @JacksonXmlProperty(localName = "Header")
    private Header header;

    @JacksonXmlProperty(localName = "DataSet")
    private DataSet dataSet;
}
