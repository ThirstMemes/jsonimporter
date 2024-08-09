package com.scuffed.jsonimporter.dto;

import java.math.BigDecimal;

public record PositionDTO(Long positionNumber, String description, BigDecimal positionPrice) {}