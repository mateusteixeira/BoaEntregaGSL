package br.com.boaentrega.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="USER_SEQ_GEN",sequenceName="USER_SEQ", initialValue=0, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USER_SEQ_GEN")
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
