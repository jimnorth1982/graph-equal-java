package org.jimmycodes.graphequaljava.rest;

import org.jetbrains.annotations.NotNull;


public record UserModel(@NotNull String user_id, @NotNull String email_address, String first_name, String last_name) {
}
