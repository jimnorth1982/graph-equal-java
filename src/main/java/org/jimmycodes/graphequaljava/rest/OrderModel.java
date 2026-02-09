package org.jimmycodes.graphequaljava.rest;

import java.math.BigDecimal;

import org.jetbrains.annotations.NotNull;


public record OrderModel(
    @NotNull String id,
    String user_id,
    String name,
    BigDecimal price
) {}