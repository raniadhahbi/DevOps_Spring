package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBusinessUnit is a Querydsl query type for BusinessUnit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusinessUnit extends EntityPathBase<BusinessUnit> {

    private static final long serialVersionUID = 922539523L;

    public static final QBusinessUnit businessUnit = new QBusinessUnit("businessUnit");

    public final ListPath<Area, QArea> areaLists = this.<Area, QArea>createList("areaLists", Area.class, QArea.class, PathInits.DIRECT2);

    public final ListPath<Business_Line, QBusiness_Line> Business_Lines = this.<Business_Line, QBusiness_Line>createList("Business_Lines", Business_Line.class, QBusiness_Line.class, PathInits.DIRECT2);

    public final ListPath<Customer, QCustomer> customerList = this.<Customer, QCustomer>createList("customerList", Customer.class, QCustomer.class, PathInits.DIRECT2);

    public final ListPath<Departement, QDepartement> departementList = this.<Departement, QDepartement>createList("departementList", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final NumberPath<Long> idUnit = createNumber("idUnit", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<PreSalesEngineer, QPreSalesEngineer> PreSalesList = this.<PreSalesEngineer, QPreSalesEngineer>createList("PreSalesList", PreSalesEngineer.class, QPreSalesEngineer.class, PathInits.DIRECT2);

    public final ListPath<ProductLine, QProductLine> ProductLineList = this.<ProductLine, QProductLine>createList("ProductLineList", ProductLine.class, QProductLine.class, PathInits.DIRECT2);

    public final BooleanPath Status = createBoolean("Status");

    public final ListPath<User, QUser> userList = this.<User, QUser>createList("userList", User.class, QUser.class, PathInits.DIRECT2);

    public QBusinessUnit(String variable) {
        super(BusinessUnit.class, forVariable(variable));
    }

    public QBusinessUnit(Path<? extends BusinessUnit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBusinessUnit(PathMetadata metadata) {
        super(BusinessUnit.class, metadata);
    }

}

