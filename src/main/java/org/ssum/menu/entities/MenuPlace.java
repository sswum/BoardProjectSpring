package org.ssum.menu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ssum.global.entities.BaseEntity;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Data
public class MenuPlace extends BaseEntity {
    @Id
    private Long contentId;
    private Long contentTypeId;
    private String category1;
    private String category2;
    private String category3;
    private String title;
    private String address;



}
