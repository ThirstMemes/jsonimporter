package com.scuffed.jsonimporter.converter;

import java.util.Collection;
import java.util.List;
import com.scuffed.jsonimporter.dto.AddressDTO;
import com.scuffed.jsonimporter.model.Address;

public final class AddressConverter {
	
	private AddressConverter() {}
	
	public static AddressDTO toDTO(Address address) {
		return new AddressDTO(address.getCity(), address.getPlz(), address.getStreet()
		);
	}
	
	public static List<AddressDTO> toDTOs(Collection<Address> addresses) {
		return addresses.stream()
						.map(AddressConverter::toDTO)
						.toList();
	}
	
	public static Address toEntity(AddressDTO dto) {
		return new Address(dto.city(), dto.plz(), dto.street());
	}
	
	public static List<Address> toEntities(Collection<AddressDTO> dtos) {
		return dtos.stream()
				   .map(AddressConverter::toEntity)
				   .toList();
	}
}