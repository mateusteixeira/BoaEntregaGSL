package br.com.boaentrega.domain;

import br.com.boaentrega.domain.enumeration.Profile;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_PROFILE")
public class UserProfile extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "USER_PROFILE_SEQ_GEN", sequenceName = "USER_PROFILE_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PROFILE_SEQ_GEN")
    private Long id;

    @Column(name = "PROFILE")
    @Enumerated(EnumType.STRING)
    private Profile profile;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER")
    private User user;

    @Override
    public String getMainIdentifier() {
        return null;
    }

    @Override
    public String getSecondaryIdentifier() {
        return null;
    }
}
