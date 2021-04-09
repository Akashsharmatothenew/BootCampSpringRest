package com.project.ecommerce.projectEcommerce.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        List<String> newList=stringList.stream().distinct().collect(Collectors.toList());
        return String.join(SPLIT_CHAR, newList);
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return Arrays.asList(string.split(SPLIT_CHAR));
    }
}