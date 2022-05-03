package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductLine is a Querydsl query type for ProductLine
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductLine extends EntityPathBase<ProductLine> {

    private static final long serialVersionUID = -1301862140L;

    public static final QProductLine productLine = new QProductLine("productLine");

    public final ListPath<BusinessUnit, QBusinessUnit> business_units = this.<BusinessUnit, QBusinessUnit>createList("business_units", BusinessUnit.class, QBusinessUnit.class, PathInits.DIRECT2);

    public final ListPath<Business_Line, QBusiness_Line> businessLines = this.<Business_Line, QBusiness_Line>createList("businessLines", Business_Line.class, QBusiness_Line.class, PathInits.DIRECT2);

    public final ListPath<Departement, QDepartement> departementList = this.<Departement, QDepartement>createList("departementList", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final NumberPath<Long> idProductLine = createNumber("idProductLine", Long.class);

    public final StringPath name = createString("name");

    public final BooleanPath status = createBoolean("status");

    public QProductLine(String variable) {
        super(ProductLine.class, forVariable(variable));
    }

    public QProductLine(Path<? extends ProductLine> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductLine(PathMetadata metadata) {
        super(ProductLine.class, metadata);
    }

}

