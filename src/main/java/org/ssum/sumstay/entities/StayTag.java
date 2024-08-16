package org.ssum.sumstay.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.ssum.tour.entities.TourPlace;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Data
public class StayTag {

    @Id @Column(length = 30)
    private String tag;


    @JsonIgnore // JSON 문자열 변환시 순환참조 방지
    @ToString.Exclude // 롬복 toString() 호출 시 순환참조 방지
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private List<Stay> items;

}
