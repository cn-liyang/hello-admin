package com.liyang.helloadmin.framework.orm.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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

    @Column(value = "is_deleted", isLogicDelete = true)
    private Long deleted;

    private String createBy;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(onInsertValue = "now()")
    private LocalDateTime createAt;

    private String updateBy;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(onInsertValue = "now()", onUpdateValue = "now()")
    private LocalDateTime updateAt;

    private String remark;
}
