package com.example.hello_library;

import org.gradle.api.provider.Property;

public interface Company {
    Property<String> getName();
    Property<String> getCountry();
}
