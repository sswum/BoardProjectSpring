package org.ssum.global.entities;

import jakarta.persistence.*;
import lombok.*;
import org.ssum.member.entities.Authorities;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    private long seq;

    @Column(length = 65, unique = true, nullable = false)
    private String email;

    @Column(length = 65, nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String userName;

    @Column(length = 15, nullable = false)
    private String mobile;

    @ToString.Exclude
    @OneToMany(mappedBy = "member")
    private List<Authorities> authorities;

}
