package org.ssum.sumstay.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStay is a Querydsl query type for Stay
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStay extends EntityPathBase<Stay> {

    private static final long serialVersionUID = 29480976L;

    public static final QStay stay1 = new QStay("stay1");

    public final org.ssum.global.entities.QBaseEntity _super = new org.ssum.global.entities.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final StringPath description = createString("description");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath pageLink = createString("pageLink");

    public final StringPath photoUrl1 = createString("photoUrl1");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath stay = createString("stay");

    public final ListPath<StayTag, QStayTag> tags = this.<StayTag, QStayTag>createList("tags", StayTag.class, QStayTag.class, PathInits.DIRECT2);

    public final StringPath tel = createString("tel");

    public QStay(String variable) {
        super(Stay.class, forVariable(variable));
    }

    public QStay(Path<? extends Stay> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStay(PathMetadata metadata) {
        super(Stay.class, metadata);
    }

}

