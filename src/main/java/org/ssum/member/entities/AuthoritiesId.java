package org.ssum.member.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.ssum.global.entities.Member;
import org.ssum.member.constants.Authority;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuthoritiesId {
    private Member member;
    private Authority authority;
}
