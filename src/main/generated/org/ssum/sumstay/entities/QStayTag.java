package org.ssum.sumstay.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStayTag is a Querydsl query type for StayTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStayTag extends EntityPathBase<StayTag> {

    private static final long serialVersionUID = 2094511466L;

    public static final QStayTag stayTag = new QStayTag("stayTag");

    public final ListPath<Stay, QStay> items = this.<Stay, QStay>createList("items", Stay.class, QStay.class, PathInits.DIRECT2);

    public final StringPath tag = createString("tag");

    public QStayTag(String variable) {
        super(StayTag.class, forVariable(variable));
    }

    public QStayTag(Path<? extends StayTag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStayTag(PathMetadata metadata) {
        super(StayTag.class, metadata);
    }

}

