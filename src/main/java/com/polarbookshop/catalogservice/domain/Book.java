package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book (

        @Pattern(
                regexp = "^(\\d{10}|\\d{13})$",
                message = "The ISBN format must follow ISBN-10 or ISBN-13 standards"
        )
        String isbn,

        @NotBlank(message = "A title needs to be defined.")
        String title,

        @NotBlank(message = "An author needs to be defined.")
        String author,

        @NotNull(message = "A price needs to be provided.")
        @Positive(message = "The price must be a positive integer.")
        Double price
) {}
