package com.scuffed.jsonimporter.converter;

import java.util.Collection;
import java.util.List;
import com.scuffed.jsonimporter.dto.CostUnitDTO;
import com.scuffed.jsonimporter.model.CostUnit;

public final class CostUnitConverter {
	
	private CostUnitConverter() {}
	
	public static CostUnitDTO toDTO(CostUnit costUnit) {
		return new CostUnitDTO(costUnit.getName(),
							   costUnit.getInstitutionalId());
	}
	
	public static List<CostUnitDTO> toDTOs(Collection<CostUnit> costUnits) {
		return costUnits.stream()
						.map(CostUnitConverter::toDTO)
						.toList();
	}
	
	public static CostUnit toEntity(CostUnitDTO dto) {
		return new CostUnit(dto.institutionalId(),
							dto.name());
	}
	
	public static List<CostUnit> toEntities(Collection<CostUnitDTO> dtos) {
		return dtos.stream()
				   .map(CostUnitConverter::toEntity)
				   .toList();
	}
}