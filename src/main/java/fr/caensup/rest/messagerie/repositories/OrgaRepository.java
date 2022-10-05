package fr.caensup.rest.messagerie.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.caensup.rest.messagerie.models.Organization;

public interface OrgaRepository extends CrudRepository<Organization, Integer> {

}
