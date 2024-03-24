package com.liyang.helloadmin.project.entry.controller.model;

import com.liyang.helloadmin.project.system.constant.PermType;
import java.util.List;

/**
 * @author cn-liyang
 */
public record MenuTree(
    PermType permType,
    String permSign,
    String name,
    String icon,
    String label,
    String caption,
    List<MenuTree> children
) {}
