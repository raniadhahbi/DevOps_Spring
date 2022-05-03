package com.example.opportunity.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOpportuniy is a Querydsl query type for Opportuniy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOpportuniy extends EntityPathBase<Opportuniy> {

    private static final long serialVersionUID = -728290614L;

    public static final QOpportuniy opportuniy = new QOpportuniy("opportuniy");

    public final ListPath<Departement, QDepartement> departementList = this.<Departement, QDepartement>createList("departementList", Departement.class, QDepartement.class, PathInits.DIRECT2);

    public final NumberPath<Long> idOpportunity = createNumber("idOpportunity", Long.class);

    public QOpportuniy(String variable) {
        super(Opportuniy.class, forVariable(variable));
    }

    public QOpportuniy(Path<? extends Opportuniy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOpportuniy(PathMetadata metadata) {
        super(Opportuniy.class, metadata);
    }

}

