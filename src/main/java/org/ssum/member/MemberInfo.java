package org.ssum.member;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.ssum.global.entities.Member;

import java.util.Collection;

@Builder
@Data
public class MemberInfo implements UserDetails {
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;  //얘를 가지고 인가를 한다.
    private Member member;

    @Override //권한체계가 일정치 않기 때문에 우리가 정의해야 한다.
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {  //원래는 계정이 만료되면 못 쓰는건데 내가 그걸 통제해서
        //이 메소드에 유입되면 쓸 수 있게 할 지 말지 ...?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//계정이 잠겨있는지 아닌지 체크. true / false가 통제
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //로그인 성공 시 핸들러 코딩할 예정이라 로그인 가능하게끔 true 바꿈
     }

    @Override
    public boolean isEnabled() { //회원 탈퇴여부를 체크하는 메서드
        return true;
    }
}
