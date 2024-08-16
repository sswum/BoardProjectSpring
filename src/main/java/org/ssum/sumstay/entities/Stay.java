package org.ssum.sumstay.entities;

import jakarta.persistence.*;
import lombok.*;
import org.ssum.global.entities.BaseEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Stay extends BaseEntity { //숙박업체에 대한 엔티티 구성

    @Id
    @GeneratedValue
    private Long seq;

    @Column(length = 150, nullable = false)
    private String stay; // 숙박명

    private Double latitude; // 위도

    private Double longitude; // 경도

    @Column(length = 200)
    private String tel; // 연락처

    @Column(length = 150)
    private String address; // 주소

    private String photoUrl1; // 사진 파일 주소


    @Lob
    private String description; // 숙박지 설명

    @Column(length = 150)
    private String pageLink; // 홈페이지 주소

    @ManyToMany(fetch = FetchType.LAZY)
    private List<StayTag> tags;


}
