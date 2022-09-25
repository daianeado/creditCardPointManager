package com.osmochilas.creditCardPointManager.service.mapper;

import com.osmochilas.creditCardPointManager.domain.CreditCard;
import com.osmochilas.creditCardPointManager.domain.User;
import com.osmochilas.creditCardPointManager.entity.CreditCardEntity;
import com.osmochilas.creditCardPointManager.entity.UserEntity;
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
public class CreditCardMapperImpl implements CreditCardMapper {

    @Override
    public List<CreditCard> toDomain(List<CreditCardEntity> creditCardEntity) {
        if ( creditCardEntity == null ) {
            return null;
        }

        List<CreditCard> list = new ArrayList<CreditCard>( creditCardEntity.size() );
        for ( CreditCardEntity creditCardEntity1 : creditCardEntity ) {
            list.add( creditCardEntityToCreditCard( creditCardEntity1 ) );
        }

        return list;
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setCpf( userEntity.getCpf() );
        user.setCreatedAt( userEntity.getCreatedAt() );
        user.setCreditCards( toDomain( userEntity.getCreditCards() ) );

        return user;
    }

    protected CreditCard creditCardEntityToCreditCard(CreditCardEntity creditCardEntity) {
        if ( creditCardEntity == null ) {
            return null;
        }

        CreditCard creditCard = new CreditCard();

        creditCard.setId( creditCardEntity.getId() );
        creditCard.setBankId( creditCardEntity.getBankId() );
        creditCard.setBankName( creditCardEntity.getBankName() );
        creditCard.setCreditCardId( creditCardEntity.getCreditCardId() );
        creditCard.setCreditCardName( creditCardEntity.getCreditCardName() );
        creditCard.setPointsRule( creditCardEntity.getPointsRule() );
        creditCard.setCurrency( creditCardEntity.getCurrency() );
        creditCard.setCpf( creditCardEntity.getCpf() );
        creditCard.setUser( userEntityToUser( creditCardEntity.getUser() ) );

        return creditCard;
    }
}
