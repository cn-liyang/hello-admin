package com.liyang.helloadmin.project.entry.controller.model;

import com.liyang.helloadmin.framework.crypto.model.AesPair;

/**
 * @author cn-liyang
 */
public record LoginResponse(AesPair aesPair) {}
