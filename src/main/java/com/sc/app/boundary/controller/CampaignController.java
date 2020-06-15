package com.sc.app.boundary.controller;


import com.sc.app.boundary.dto.CampaignDto;
import com.sc.app.boundary.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/campaigns")
@RestController
public class CampaignController {

    private CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CampaignDto> findCampaignById(@PathVariable Long id) {
        CampaignDto output = campaignService.findById(id);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CampaignDto> save(@RequestBody CampaignDto campaignDto) {
        CampaignDto output = campaignService.save(campaignDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
