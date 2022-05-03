package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoles is a Querydsl query type for Roles
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoles extends EntityPathBase<Roles> {

    private static final long serialVersionUID = 1169541886L;

    public static final QRoles roles = new QRoles("roles");

    public final NumberPath<Long> idRole = createNumber("idRole", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Permissions, QPermissions> permissions = this.<Permissions, QPermissions>createList("permissions", Permissions.class, QPermissions.class, PathInits.DIRECT2);

    public final ListPath<User, QUser> users = this.<User, QUser>createList("users", User.class, QUser.class, PathInits.DIRECT2);

    public QRoles(String variable) {
        super(Roles.class, forVariable(variable));
    }

    public QRoles(Path<? extends Roles> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoles(PathMetadata metadata) {
        super(Roles.class, metadata);
    }

}

