package br.com.boaentrega.domain;

import java.io.Serializable;

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
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "PROFILE")
    @Enumerated(EnumType.STRING)
    private Profile profile;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USER")
    private User user;
}
