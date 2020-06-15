package com.sc.app.boundary.mapper;

import com.sc.app.boundary.dto.CampaignDto;
import com.sc.app.domain.discount.Campaign;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampaignMapper {

    Campaign map(CampaignDto campaignDto);

    CampaignDto map(Campaign campaign);

    List<CampaignDto> map(List<Campaign> campaigns);
}
