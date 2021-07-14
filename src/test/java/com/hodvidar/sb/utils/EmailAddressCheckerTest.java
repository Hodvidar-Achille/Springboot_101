package com.hodvidar.sb.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailAddressCheckerTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            " | false",
            "a | false",
            "achille.genet@pm.me | true"
    })
    void isEmailValid(final String email, final boolean expected) {
        assertThat(EmailAddressChecker.isEmailValid(email)).isEqualTo(expected);
    }
}
