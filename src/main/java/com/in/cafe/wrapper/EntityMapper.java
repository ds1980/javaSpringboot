package com.in.cafe.wrapper;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityMapper <D, E> {
	
	  E toEntity(D dto);

	   D toDto(E entity);
	   
	   default  List<E> toEntity(List<D> list){
	        return list.stream().map(this::toEntity).collect(Collectors.toList());
	    }

	    default List<D> toDto(List<E> list){
	        return list.stream().map(this::toDto).collect(Collectors.toList());
	    }
}
