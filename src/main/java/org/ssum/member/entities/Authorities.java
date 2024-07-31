package org.ssum.member.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ssum.global.entities.Member;
import org.ssum.member.constants.Authority;

@Data
@Entity
@Builder
@IdClass(AuthoritiesId.class)
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {
    @Id
    @ManyToOne(fetch = FetchType.LAZY) // 보통 매니투원은 사용자 한명인데 게시글 여러개 경우
    private Member member;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Authority authority;
}
