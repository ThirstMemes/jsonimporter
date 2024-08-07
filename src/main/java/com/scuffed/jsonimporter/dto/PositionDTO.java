package com.scuffed.jsonimporter.dto;

import java.math.BigDecimal;

public record PositionDTO(Integer positionNumber, String description, BigDecimal positionPrice) {}