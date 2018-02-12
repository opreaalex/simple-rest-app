package com.opreaalex.util;

import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;

public class UriUtil {

    public static URI getUriWithStockId(final BigInteger id) {
        return UriComponentsBuilder
                .fromPath("/api/stocks/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
