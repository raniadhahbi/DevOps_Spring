package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -932011158L;

    public static final QUser user = new QUser("user");

    public final ListPath<Area, QArea> AreaList = this.<Area, QArea>createList("AreaList", Area.class, QArea.class, PathInits.DIRECT2);

    public final ListPath<Business_Line, QBusiness_Line> businessLines = this.<Business_Line, QBusiness_Line>createList("businessLines", Business_Line.class, QBusiness_Line.class, PathInits.DIRECT2);

    public final ListPath<BusinessUnit, QBusinessUnit> businessUnits = this.<BusinessUnit, QBusinessUnit>createList("businessUnits", BusinessUnit.class, QBusinessUnit.class, PathInits.DIRECT2);

    public final DatePath<java.util.Date> CreationDate = createDate("CreationDate", java.util.Date.class);

    public final ListPath<Departement, QDepartement> departementList = this.<Departement, QDepartement>createList("departementList", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.util.Date> LastConnectionDate = createDate("LastConnectionDate", java.util.Date.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath login = createString("login");

    public final StringPath mypassword = createString("mypassword");

    public final ListPath<Roles, QRoles> roles = this.<Roles, QRoles>createList("roles", Roles.class, QRoles.class, PathInits.DIRECT2);

    public final BooleanPath status = createBoolean("status");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

