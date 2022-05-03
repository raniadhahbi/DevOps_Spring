package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 1919569917L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomer customer = new QCustomer("customer");

    public final ListPath<Area, QArea> areaList = this.<Area, QArea>createList("areaList", Area.class, QArea.class, PathInits.DIRECT2);

    public final ListPath<Business_Line, QBusiness_Line> businessLineList = this.<Business_Line, QBusiness_Line>createList("businessLineList", Business_Line.class, QBusiness_Line.class, PathInits.DIRECT2);

    public final ListPath<BusinessUnit, QBusinessUnit> businessUnitList = this.<BusinessUnit, QBusinessUnit>createList("businessUnitList", BusinessUnit.class, QBusinessUnit.class, PathInits.DIRECT2);

    public final StringPath country = createString("country");

    public final StringPath customerGroup = createString("customerGroup");

    public final StringPath customerName = createString("customerName");

    public final ListPath<Departement, QDepartement> departementList = this.<Departement, QDepartement>createList("departementList", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final QGeography geographies;

    public final NumberPath<Long> idCustomer = createNumber("idCustomer", Long.class);

    public final StringPath sapPartner = createString("sapPartner");

    public final BooleanPath status = createBoolean("status");

    public QCustomer(String variable) {
        this(Customer.class, forVariable(variable), INITS);
    }

    public QCustomer(Path<? extends Customer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomer(PathMetadata metadata, PathInits inits) {
        this(Customer.class, metadata, inits);
    }

    public QCustomer(Class<? extends Customer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.geographies = inits.isInitialized("geographies") ? new QGeography(forProperty("geographies"), inits.get("geographies")) : null;
    }

}

