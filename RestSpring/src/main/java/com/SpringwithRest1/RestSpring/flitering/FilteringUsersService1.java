package com.SpringwithRest1.RestSpring.flitering;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ttn on 12/3/21.
 */
@Component
public class FilteringUsersService1 {
    static List<FilteringUser1> Users1 = new ArrayList<>();
    static {
        Users1.add(new FilteringUser1("Akash","Gmail.com","Aaksh1"));
        Users1.add(new FilteringUser1("Aka","Gmail1.com","Aaksh2"));
        Users1.add(new FilteringUser1("Akash","Gmail2.com","Aaksh3"));
    }
    public List<FilteringUser1> findAll(){

        return Users1;
    }
    public FilteringUser1 save(FilteringUser1 users){
        Users1.add(users);
        return users;

    }
}
