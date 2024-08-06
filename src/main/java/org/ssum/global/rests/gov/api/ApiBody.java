package org.ssum.global.rests.gov.api;

import lombok.Data;

import java.util.List;

@Data
public class ApiBody {
    private List<ApiItem> items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;

}
