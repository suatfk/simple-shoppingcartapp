package com.sc.app.boundary.dto;

import com.sc.app.domain.category.Category;
import com.sc.app.domain.discount.Discount;

import javax.persistence.*;

public class CampaignDto {

    private String title;

    private int minQuantity;

    private Discount discount;

    private Category category;

}
