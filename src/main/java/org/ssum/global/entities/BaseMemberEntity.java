package org.ssum.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseMemberEntity extends BaseEntity {
    @CreatedBy //로그인한 멤버 사용자를 간단하게 조회할 수 있게
    @Column(length = 65, updatable = false)
    private String createBy;
    @Column(length = 65, insertable = false)
    @LastModifiedBy // 단순하게 값을 바꿀 땐 modifiedBy에 들어간다.
    private String modifiedBy;


}
