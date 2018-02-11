package com.stringcodelab.spring5webapp.repositories;

import com.stringcodelab.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
