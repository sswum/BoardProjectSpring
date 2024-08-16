package org.ssum.sumstay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ssum.global.Pagination;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListData<T> {

    private List<T>items; // 목록 데이터
    private Pagination pagination;
}
