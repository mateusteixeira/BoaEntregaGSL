package br.com.boaentrega.domain;

import br.com.boaentrega.domain.enumeration.Profile;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_PROFILE")
@SequenceGenerator(name = AbstractEntity.SEQ_NAME, sequenceName = "USER_PROFILE_SEQ", initialValue = 0, allocationSize = 1)
public class UserProfile extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

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
