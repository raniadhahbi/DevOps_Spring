package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreSalesEngineer is a Querydsl query type for PreSalesEngineer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreSalesEngineer extends EntityPathBase<PreSalesEngineer> {

    private static final long serialVersionUID = 1612955351L;

    public static final QPreSalesEngineer preSalesEngineer = new QPreSalesEngineer("preSalesEngineer");

    public final ListPath<Area, QArea> areaList = this.<Area, QArea>createList("areaList", Area.class, QArea.class, PathInits.DIRECT2);

    public final ListPath<BusinessUnit, QBusinessUnit> business_units = this.<BusinessUnit, QBusinessUnit>createList("business_units", BusinessUnit.class, QBusinessUnit.class, PathInits.DIRECT2);

    public final ListPath<Business_Line, QBusiness_Line> businessLines = this.<Business_Line, QBusiness_Line>createList("businessLines", Business_Line.class, QBusiness_Line.class, PathInits.DIRECT2);

    public final ListPath<Departement, QDepartement> departementList = this.<Departement, QDepartement>createList("departementList", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final NumberPath<Long> idPreSales = createNumber("idPreSales", Long.class);

    public final StringPath name = createString("name");

    public final BooleanPath status = createBoolean("status");

    public QPreSalesEngineer(String variable) {
        super(PreSalesEngineer.class, forVariable(variable));
    }

    public QPreSalesEngineer(Path<? extends PreSalesEngineer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPreSalesEngineer(PathMetadata metadata) {
        super(PreSalesEngineer.class, metadata);
    }

}

