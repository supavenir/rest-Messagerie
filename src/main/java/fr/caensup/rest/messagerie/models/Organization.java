package fr.caensup.rest.messagerie.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor()

@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NonNull
	@Column(length = 20, nullable = false)
	private String name;

	@NonNull
	@Column(length = 20, nullable = false)
	private String domain;

	@NonNull
	@Column(length = 20, nullable = false)
	private String aliases;

	@OneToMany(mappedBy = "organization")
	private List<Group> groupes;

	@OneToMany(mappedBy = "organization")
	private List<User> users;

	public void addGroup(Group gr) {
		if (groupes.add(gr)) {
			gr.setOrganization(this);
		}

	}

	public void addUser(User us) {
		if (users.add(us)) {
			us.setOrganization(this);
		}

	}

}