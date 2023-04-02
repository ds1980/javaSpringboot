package com.in.cafe.wrapper;

import org.mapstruct.*;

import com.in.cafe.POJO.AddBidderDTO;
import com.in.cafe.domain.AddBidder;
import com.in.cafe.domain.TblBidder;

/**
 * Mapper for the entity {@link TblBidder} and its DTO {@link AddBidderDTO}.
 */

@Mapper(componentModel = "spring", uses = {})
public interface AddBidderMapper extends EntityMapper<AddBidderDTO, TblBidder> {
	default AddBidder fromId(Long id) {
        if (id == null) {
            return null;
        }
        AddBidder addBidder = new AddBidder();
        addBidder.setId(id);
        return addBidder;
    }
	
}
