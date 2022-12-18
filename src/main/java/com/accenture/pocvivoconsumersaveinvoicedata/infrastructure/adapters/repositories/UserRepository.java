package com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.repositories;



import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
