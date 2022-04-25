package br.com.boaentrega.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
@SequenceGenerator(name = AbstractEntity.SEQ_NAME, sequenceName = "USER_SEQ", initialValue = 0, allocationSize = 1)
public class User extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

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

    @Override
    public String getMainIdentifier() {
        return email;
    }

    @Override
    public String getSecondaryIdentifier() {
        return firstName;
    }
}
