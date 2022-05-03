package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArea is a Querydsl query type for Area
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArea extends EntityPathBase<Area> {

    private static final long serialVersionUID = -932607956L;

    public static final QArea area = new QArea("area");

    public final ListPath<BusinessUnit, QBusinessUnit> businessUnits = this.<BusinessUnit, QBusinessUnit>createList("businessUnits", BusinessUnit.class, QBusinessUnit.class, PathInits.DIRECT2);

    public final ListPath<Customer, QCustomer> customerList = this.<Customer, QCustomer>createList("customerList", Customer.class, QCustomer.class, PathInits.DIRECT2);

    public final ListPath<Geography, QGeography> GeographyList = this.<Geography, QGeography>createList("GeographyList", Geography.class, QGeography.class, PathInits.DIRECT2);

    public final NumberPath<Long> idArea = createNumber("idArea", Long.class);

    public final StringPath nameArea = createString("nameArea");

    public final ListPath<PreSalesEngineer, QPreSalesEngineer> PreSalesList = this.<PreSalesEngineer, QPreSalesEngineer>createList("PreSalesList", PreSalesEngineer.class, QPreSalesEngineer.class, PathInits.DIRECT2);

    public final BooleanPath status = createBoolean("status");

    public final ListPath<User, QUser> userList = this.<User, QUser>createList("userList", User.class, QUser.class, PathInits.DIRECT2);

    public QArea(String variable) {
        super(Area.class, forVariable(variable));
    }

    public QArea(Path<? extends Area> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArea(PathMetadata metadata) {
        super(Area.class, metadata);
    }

}

