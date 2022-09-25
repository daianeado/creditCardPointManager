package com.osmochilas.creditCardPointManager.service.mapper;

import com.osmochilas.creditCardPointManager.domain.Bill;
import com.osmochilas.creditCardPointManager.entity.BillEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-25T18:27:56-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class BillMapperImpl implements BillMapper {

    @Override
    public List<Bill> toDomain(List<BillEntity> billsEntity) {
        if ( billsEntity == null ) {
            return null;
        }

        List<Bill> list = new ArrayList<Bill>( billsEntity.size() );
        for ( BillEntity billEntity : billsEntity ) {
            list.add( billEntityToBill( billEntity ) );
        }

        return list;
    }

    protected Bill billEntityToBill(BillEntity billEntity) {
        if ( billEntity == null ) {
            return null;
        }

        Bill bill = new Bill();

        if ( billEntity.getBillId() != null ) {
            bill.setBillId( String.valueOf( billEntity.getBillId() ) );
        }
        bill.setBankId( billEntity.getBankId() );
        bill.setBankName( billEntity.getBankName() );
        bill.setCreditCardId( billEntity.getCreditCardId() );
        bill.setCreditCardName( billEntity.getCreditCardName() );
        bill.setDueDate( billEntity.getDueDate() );

        return bill;
    }
}
