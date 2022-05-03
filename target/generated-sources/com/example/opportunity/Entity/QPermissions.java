package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPermissions is a Querydsl query type for Permissions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPermissions extends EntityPathBase<Permissions> {

    private static final long serialVersionUID = 1323711493L;

    public static final QPermissions permissions = new QPermissions("permissions");

    public final StringPath codePermission = createString("codePermission");

    public final NumberPath<Long> idPermission = createNumber("idPermission", Long.class);

    public final StringPath label = createString("label");

    public final ListPath<Roles, QRoles> rolesList = this.<Roles, QRoles>createList("rolesList", Roles.class, QRoles.class, PathInits.DIRECT2);

    public QPermissions(String variable) {
        super(Permissions.class, forVariable(variable));
    }

    public QPermissions(Path<? extends Permissions> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPermissions(PathMetadata metadata) {
        super(Permissions.class, metadata);
    }

}

