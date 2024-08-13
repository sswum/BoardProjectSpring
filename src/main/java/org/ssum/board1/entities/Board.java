package org.ssum.board1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ssum.global.entities.BaseMemberEntity;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
//게시판 설정
public class Board extends BaseMemberEntity {
    @Id
    @Column(length = 30)
    private String bId;

    @Column(length = 60, nullable = false)
    private String bName;

}
