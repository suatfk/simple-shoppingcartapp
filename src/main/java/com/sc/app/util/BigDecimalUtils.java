package com.sc.app.util;

import java.math.BigDecimal;

public class BigDecimalUtils {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public static BigDecimal percentage(BigDecimal base, BigDecimal pct) {
        return base.multiply(pct).divide(ONE_HUNDRED);
    }
}
