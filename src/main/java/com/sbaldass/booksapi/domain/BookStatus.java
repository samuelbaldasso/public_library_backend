package com.sbaldass.booksapi.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookStatus {
    ISSUED("issued"),
    RETURNED("returned");

    private String name;

    BookStatus(String name){
        this.name = name;
    }
}
