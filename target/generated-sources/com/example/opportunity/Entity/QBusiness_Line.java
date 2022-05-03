package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBusiness_Line is a Querydsl query type for Business_Line
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusiness_Line extends EntityPathBase<Business_Line> {

    private static final long serialVersionUID = -1457823628L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBusiness_Line business_Line = new QBusiness_Line("business_Line");

    public final ListPath<Customer, QCustomer> customerList = this.<Customer, QCustomer>createList("customerList", Customer.class, QCustomer.class, PathInits.DIRECT2);

    public final ListPath<Departement, QDepartement> departementList = this.<Departement, QDepartement>createList("departementList", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final ListPath<Departement, QDepartement> departements = this.<Departement, QDepartement>createList("departements", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final NumberPath<Long> idLine = createNumber("idLine", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<PreSalesEngineer, QPreSalesEngineer> PreSalesList = this.<PreSalesEngineer, QPreSalesEngineer>createList("PreSalesList", PreSalesEngineer.class, QPreSalesEngineer.class, PathInits.DIRECT2);

    public final ListPath<ProductLine, QProductLine> ProductLineList = this.<ProductLine, QProductLine>createList("ProductLineList", ProductLine.class, QProductLine.class, PathInits.DIRECT2);

    public final BooleanPath Status = createBoolean("Status");

    public final QBusinessUnit unit;

    public final ListPath<User, QUser> userList = this.<User, QUser>createList("userList", User.class, QUser.class, PathInits.DIRECT2);

    public QBusiness_Line(String variable) {
        this(Business_Line.class, forVariable(variable), INITS);
    }

    public QBusiness_Line(Path<? extends Business_Line> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBusiness_Line(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBusiness_Line(PathMetadata metadata, PathInits inits) {
        this(Business_Line.class, metadata, inits);
    }

    public QBusiness_Line(Class<? extends Business_Line> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.unit = inits.isInitialized("unit") ? new QBusinessUnit(forProperty("unit")) : null;
    }

}

