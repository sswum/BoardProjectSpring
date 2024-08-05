package org.ssum.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseMember extends Base {
    @CreatedBy
    @Column(length=40, updatable = false)
    private String createdBy; //로그인한 사용자

    @LastModifiedBy
    @Column(length=40, insertable = false)
    private String modifiedBy; // 수정한 사용자
}
