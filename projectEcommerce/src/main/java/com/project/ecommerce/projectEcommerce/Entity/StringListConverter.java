package com.project.ecommerce.projectEcommerce.Entity;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StringListConverter implements AttributeConverter<List<String>,String>{
        private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        List<String> newList=strings.stream().distinct().collect(Collectors.toList());
        return String.join(SPLIT_CHAR, newList);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        return Arrays.asList(s.split(SPLIT_CHAR));
    }
}
