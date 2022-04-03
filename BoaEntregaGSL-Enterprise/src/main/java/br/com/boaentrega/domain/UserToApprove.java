package br.com.boaentrega.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("UserToApprove")
public class UserToApprove  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Long idUser;
}
