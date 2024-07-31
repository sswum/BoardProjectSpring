package org.ssum.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false) // 추가할때만 값이 들어가게 설정
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(insertable = false) // 업데이트할 때만 값이 들어가게 설정
    private LocalDateTime modifiedAt;
    @Column(insertable = false)
    private LocalDateTime deletedAt;
}
