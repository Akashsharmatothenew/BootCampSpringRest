package com.SpringWithJpa1.Employee2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/api")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/addauthordetails")
    public ResponseEntity<Object> addAuthorDetails(@RequestBody Author author) {
        Author user = authorService.saveAuthor(author);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // Question 9
    /*Which method on the session object can be used to remove an object from the cache?

    1. session evict() method to remove a single object from the hibernate first level cache.
    2. session clear() method to clear the cache i.e delete all the objects from the cache.*/


    //Question 10
   /* What does @transactional annotation do?
    @transactional annotation to separate transaction management code from the code for business logic.*/
}
