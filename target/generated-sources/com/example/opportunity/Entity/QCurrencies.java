package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCurrencies is a Querydsl query type for Currencies
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCurrencies extends EntityPathBase<Currencies> {

    private static final long serialVersionUID = -1637530418L;

    public static final QCurrencies currencies = new QCurrencies("currencies");

    public final NumberPath<Float> code = createNumber("code", Float.class);

    public final NumberPath<Float> conversion_rate = createNumber("conversion_rate", Float.class);

    public final DatePath<java.util.Date> conversionDate = createDate("conversionDate", java.util.Date.class);

    public final NumberPath<Long> idCurrency = createNumber("idCurrency", Long.class);

    public QCurrencies(String variable) {
        super(Currencies.class, forVariable(variable));
    }

    public QCurrencies(Path<? extends Currencies> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCurrencies(PathMetadata metadata) {
        super(Currencies.class, metadata);
    }

}

