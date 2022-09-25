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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setCpf( user.getCpf() );
        userEntity.setCreatedAt( user.getCreatedAt() );
        userEntity.setCreditCards( creditCardListToCreditCardEntityList( user.getCreditCards() ) );

        return userEntity;
    }

    @Override
    public User toDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setCpf( userEntity.getCpf() );
        user.setCreatedAt( userEntity.getCreatedAt() );
        user.setCreditCards( creditCardEntityListToCreditCardList( userEntity.getCreditCards() ) );

        return user;
    }

    protected CreditCardEntity creditCardToCreditCardEntity(CreditCard creditCard) {
        if ( creditCard == null ) {
            return null;
        }

        CreditCardEntity creditCardEntity = new CreditCardEntity();

        creditCardEntity.setId( creditCard.getId() );
        creditCardEntity.setBankId( creditCard.getBankId() );
        creditCardEntity.setBankName( creditCard.getBankName() );
        creditCardEntity.setCreditCardId( creditCard.getCreditCardId() );
        creditCardEntity.setCreditCardName( creditCard.getCreditCardName() );
        creditCardEntity.setPointsRule( creditCard.getPointsRule() );
        creditCardEntity.setCurrency( creditCard.getCurrency() );
        creditCardEntity.setCpf( creditCard.getCpf() );
        creditCardEntity.setUser( toEntity( creditCard.getUser() ) );

        return creditCardEntity;
    }

    protected List<CreditCardEntity> creditCardListToCreditCardEntityList(List<CreditCard> list) {
        if ( list == null ) {
            return null;
        }

        List<CreditCardEntity> list1 = new ArrayList<CreditCardEntity>( list.size() );
        for ( CreditCard creditCard : list ) {
            list1.add( creditCardToCreditCardEntity( creditCard ) );
        }

        return list1;
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
        creditCard.setUser( toDomain( creditCardEntity.getUser() ) );

        return creditCard;
    }

    protected List<CreditCard> creditCardEntityListToCreditCardList(List<CreditCardEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CreditCard> list1 = new ArrayList<CreditCard>( list.size() );
        for ( CreditCardEntity creditCardEntity : list ) {
            list1.add( creditCardEntityToCreditCard( creditCardEntity ) );
        }

        return list1;
    }
}
