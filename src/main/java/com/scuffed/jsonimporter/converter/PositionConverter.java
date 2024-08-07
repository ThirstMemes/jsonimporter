package com.scuffed.jsonimporter.converter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import com.scuffed.jsonimporter.dto.PositionDTO;
import com.scuffed.jsonimporter.model.Position;

public final class PositionConverter {
	
	private PositionConverter() {}
	
	public static PositionDTO toDTO(Position position) {
		return new PositionDTO(position.getPositionNumber(),
							   position.getDescription(),
							   BigDecimal.TEN);
	}
	
	public static List<PositionDTO> toDTOs(Collection<Position> positions) {
		return positions.stream().map(PositionConverter::toDTO).toList();
	}
	
	public static Position toEntity(PositionDTO dto) {
		return new Position(dto.positionNumber(), dto.description());
	}
	
	public static List<Position> toEntities(Collection<PositionDTO> dtos) {
		return dtos.stream().map(PositionConverter::toEntity).toList();
	}
}