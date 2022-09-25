package com.osmochilas.creditCardPointManager.service.mapper;

import com.osmochilas.creditCardPointManager.domain.Bill;
import com.osmochilas.creditCardPointManager.entity.BillEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BillMapper {

    List<Bill> toDomain(List<BillEntity> billsEntity);
}
