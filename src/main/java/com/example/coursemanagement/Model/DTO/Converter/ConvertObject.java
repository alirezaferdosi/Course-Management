package com.example.coursemanagement.Model.DTO.Converter;

public interface ConvertObject<E,D> {
    D ConvertEntityToDto(E e);
    E ConvertDtoToEntity(D d);
}
