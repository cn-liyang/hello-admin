package com.liyang.helloadmin.framework.web.encryption.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author cn-liyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class WithDecryption<T> extends BaseEncryption {

    private T decrypted;
}
