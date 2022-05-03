package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGeography is a Querydsl query type for Geography
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGeography extends EntityPathBase<Geography> {

    private static final long serialVersionUID = -1002722499L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGeography geography = new QGeography("geography");

    public final QArea areas;

    public final StringPath continent = createString("continent");

    public final StringPath country = createString("country");

    public final ListPath<Customer, QCustomer> customer = this.<Customer, QCustomer>createList("customer", Customer.class, QCustomer.class, PathInits.DIRECT2);

    public final NumberPath<Long> idGeography = createNumber("idGeography", Long.class);

    public final BooleanPath status = createBoolean("status");

    public QGeography(String variable) {
        this(Geography.class, forVariable(variable), INITS);
    }

    public QGeography(Path<? extends Geography> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGeography(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGeography(PathMetadata metadata, PathInits inits) {
        this(Geography.class, metadata, inits);
    }

    public QGeography(Class<? extends Geography> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.areas = inits.isInitialized("areas") ? new QArea(forProperty("areas")) : null;
    }

}

