package com.sc.app.boundary.service;

import com.sc.app.boundary.dto.CampaignDto;
import com.sc.app.boundary.mapper.CampaignMapper;
import com.sc.app.domain.discount.Campaign;
import com.sc.app.domain.discount.CampaignRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CampaignService {

    private CampaignRepository campaignRepository;

    private CampaignMapper campaignMapper;

    public CampaignService(CampaignRepository campaignRepository, CampaignMapper campaignMapper) {
        this.campaignRepository = campaignRepository;
        this.campaignMapper = campaignMapper;
    }

    public CampaignDto findById(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        return campaignMapper.map(campaign);
    }

    @Transactional
    public CampaignDto save(CampaignDto campaignDto) {
        Campaign campaign = campaignMapper.map(campaignDto);
        campaign = campaignRepository.save(campaign);
        return campaignMapper.map(campaign);
    }

}
