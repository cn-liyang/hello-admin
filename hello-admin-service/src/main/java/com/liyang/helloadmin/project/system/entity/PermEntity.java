package com.liyang.helloadmin.project.system.entity;

import com.liyang.helloadmin.framework.orm.entity.IdEntity;
import com.liyang.helloadmin.framework.orm.entity.OptionEntity;
import com.liyang.helloadmin.project.system.constant.PermType;
import com.liyang.helloadmin.project.system.constant.SystemTables;
import com.mybatisflex.annotation.RelationOneToMany;
import com.mybatisflex.annotation.Table;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

/**
 * @author cn-liyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@FieldNameConstants
@Table(SystemTables.PERM)
public class PermEntity extends OptionEntity {

    private Long parentId;
    private PermType permType;
    private String permSign;

    private Integer sortBy;

    @RelationOneToMany(selfField = IdEntity.Fields.id, targetField = Fields.parentId)
    private List<PermEntity> children;
}
