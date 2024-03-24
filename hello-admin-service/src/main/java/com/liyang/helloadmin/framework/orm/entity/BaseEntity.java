package com.liyang.helloadmin.framework.orm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mybatisflex.annotation.Column;
import java.time.LocalDateTime;
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
public class BaseEntity extends IdEntity {

    @JsonIgnore
    @Column(value = "is_deleted", isLogicDelete = true)
    private Long deleted;

    private String createBy;

    private LocalDateTime createAt;

    private String updateBy;

    private LocalDateTime updateAt;

    private String remark;
}
