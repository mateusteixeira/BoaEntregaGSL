package br.com.boaentrega.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "USER")
@RequiredArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACTIVE")
    private boolean active = false;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
    private UserProfile userProfile;

}
