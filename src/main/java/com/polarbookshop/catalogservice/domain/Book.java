package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.Version;

import java.time.Instant;

public record Book (

        @Id
        Long id,

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
        Double price,

        @CreatedBy
        Instant createdDate,

        @LastModifiedBy
        Instant lastModifiedDate,

        String publisher,

        @Version
        int version
) {
        public static Book build(String isbn, String title, String author, Double price, Instant createdDate, Instant lastModifiedDate, String publisher, Integer version) {
                return new Book(null, isbn, title, author, price, null, null, null, 0);
        }
}
