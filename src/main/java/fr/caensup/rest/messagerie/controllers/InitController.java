package fr.caensup.rest.messagerie.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

import fr.caensup.rest.messagerie.models.Group;
import fr.caensup.rest.messagerie.models.Organization;
import fr.caensup.rest.messagerie.models.User;

@RestController
public class InitController {
	@GetMapping("init/{cOrga}/{cGroup}/{cUser}")
	public @ResponseBody String initAction(@PathVariable int cOrga, @PathVariable int cGroup, @PathVariable int cUser) {
		for (int o = 0; o < cOrga; o++) {
			Organization orga = new Organization();
			Faker fake = new Faker();
			orga.setName(fake.animal().name());
			for (int g = 0; g < cGroup; g++) {
				Group gr = new Group();
				gr.setName(fake.ancient().hero());
				orga.addGroup(gr);
				for (int u = 0; u < cUser; u++) {
					User us = new User(fake.name().firstName(), fake.name().lastName(), fake.internet().emailAddress(),
							"0000");
					orga.addUser(us);
					gr.addUSer(us);
				}
			}
			orgaRepo.save(orga);
		}
		return "init ok";
	}
}