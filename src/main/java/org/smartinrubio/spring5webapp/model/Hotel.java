package org.smartinrubio.spring5webapp.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Hotel {
    private final Long id;
    private final String name;
    private final String address;
    private final Float rating;
}
