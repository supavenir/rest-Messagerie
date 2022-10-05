package fr.caensup.rest.messagerie.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.caensup.rest.messagerie.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
