package org.ssum.global;

import lombok.Data;

import java.util.List;

@Data
public class ListData<T> {
    private List<T> items;
    private Pagination pagination;
}
