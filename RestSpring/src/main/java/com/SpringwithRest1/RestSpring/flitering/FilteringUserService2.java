package com.SpringwithRest1.RestSpring.flitering;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.SpringwithRest1.RestSpring.flitering.FilteringUsersService1.Users1;

/**
 * Created by ttn on 12/3/21.
 */
@Component
public class FilteringUserService2 {
    static List<FiltreingUser2> Users2 = new ArrayList<>();
    static {
        Users2.add(new FiltreingUser2("Akash","Gmail.com","Aaksh1"));
        Users2.add(new FiltreingUser2("Aka","Gmail1.com","Aaksh2"));
        Users2.add(new FiltreingUser2("Akash","Gmail2.com","Aaksh3"));
    }
    public List<FiltreingUser2> findAll2(){
        return Users2;
    }

    public FiltreingUser2 save2(FiltreingUser2 users){
        Users2.add(users);
        return users;

    }
}
