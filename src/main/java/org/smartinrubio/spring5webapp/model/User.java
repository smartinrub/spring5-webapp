package org.smartinrubio.spring5webapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class User {

    @NotNull
    @Size(min = 5, max = 16)
    private final String firstName;

    @NotNull
    private final String lastName;

    @NotNull
    private final String email;

    @NotNull
    private final String password;
}
