package com.SpringwithRest1.RestSpring.flitering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ttn on 11/3/21.
 */
@RestController
public class FilteringController2 {

    @Autowired
    FilteringUserService2 filteringUserService2;


    @GetMapping("/Q9")
    public MappingJacksonValue retrieveListOfSomeDetaile(){
        List<FiltreingUser2> list = filteringUserService2.findAll2();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("name","email");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("Password",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;
    }

}
