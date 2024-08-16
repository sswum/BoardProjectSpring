package org.ssum.sumstay.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssum.sumstay.ListData;
import org.ssum.sumstay.entities.Stay;

@RequiredArgsConstructor
@Service
public class StayInfoService {

    public ListData<Stay> getList() {
        return new ListData<>();
    }
}
