package com.project.ecommerce.projectEcommerce.Repository;

import com.project.ecommerce.projectEcommerce.Entity.Conformation.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ttn on 27/3/21.
 */
public interface ConfirmationTokenRepository
        extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
