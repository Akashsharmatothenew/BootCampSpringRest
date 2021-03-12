package com.SpringwithRest1.RestSpring.flitering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ttn on 11/3/21.
 */
@RestController
public class FilteringController {

    @GetMapping("/Q8")
    public List<FilteringUserServices> retrieveListOfSomeDetailes(){
        return Arrays.asList(new FilteringUserServices
                ("Akash","akashsharma@gmail.com", "Akash"),
                new FilteringUserServices("Mayank","mayank@gmail.com","Mayank"));
    }

}
