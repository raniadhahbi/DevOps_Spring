package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartement is a Querydsl query type for Departement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartement extends EntityPathBase<Departement> {

    private static final long serialVersionUID = 706753360L;

    public static final QDepartement departement = new QDepartement("departement");

    public final ListPath<Business_Line, QBusiness_Line> businessLine = this.<Business_Line, QBusiness_Line>createList("businessLine", Business_Line.class, QBusiness_Line.class, PathInits.DIRECT2);

    public final ListPath<BusinessUnit, QBusinessUnit> businessUnit = this.<BusinessUnit, QBusinessUnit>createList("businessUnit", BusinessUnit.class, QBusinessUnit.class, PathInits.DIRECT2);

    public final ListPath<Customer, QCustomer> customerList = this.<Customer, QCustomer>createList("customerList", Customer.class, QCustomer.class, PathInits.DIRECT2);

    public final NumberPath<Long> idDepartement = createNumber("idDepartement", Long.class);

    public final StringPath nameDep = createString("nameDep");

    public final ListPath<PreSalesEngineer, QPreSalesEngineer> PreSalesList = this.<PreSalesEngineer, QPreSalesEngineer>createList("PreSalesList", PreSalesEngineer.class, QPreSalesEngineer.class, PathInits.DIRECT2);

    public final ListPath<ProductLine, QProductLine> ProductLineList = this.<ProductLine, QProductLine>createList("ProductLineList", ProductLine.class, QProductLine.class, PathInits.DIRECT2);

    public final BooleanPath status = createBoolean("status");

    public final ListPath<User, QUser> userList = this.<User, QUser>createList("userList", User.class, QUser.class, PathInits.DIRECT2);

    public QDepartement(String variable) {
        super(Departement.class, forVariable(variable));
    }

    public QDepartement(Path<? extends Departement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartement(PathMetadata metadata) {
        super(Departement.class, metadata);
    }

}

