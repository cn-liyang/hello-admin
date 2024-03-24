package com.liyang.helloadmin.project.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.liyang.helloadmin.framework.orm.entity.IdEntity;
import com.liyang.helloadmin.project.system.constant.SystemDomains;
import com.liyang.helloadmin.project.system.constant.SystemTables;
import com.mybatisflex.annotation.RelationManyToMany;
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
@Table(SystemTables.ROLE)
public class RoleEntity extends BaseEntity {

    private String name;
    private String label;

    @JsonIgnore
    @RelationManyToMany(
        joinTable = SystemTables.ROLE_MTM_PERM,
        joinSelfColumn = SystemDomains.ROLE + Chars.UNDERSCORE + IdEntity.Fields.id,
        joinTargetColumn = SystemDomains.PERM + Chars.UNDERSCORE + IdEntity.Fields.id
    )
    private List<PermEntity> permEntities;
}
