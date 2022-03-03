package com.ginogipsy.magicbus.dto;


import com.ginogipsy.magicbus.domain.enums.AvailabilityPeriod;
import com.ginogipsy.magicbus.domain.enums.IngredientType;
import com.ginogipsy.magicbus.domain.enums.MeasureUnit;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
public class IngredientDTO {

    private Integer id;
    @NotBlank(message = "Name is necessary!")
    private String name;
    @NotBlank(message = "Name is necessary!")
    private String description;
    private Boolean available;
    private Double additionalCostForClient;
    private Double purchaseCost;
    private MeasureUnit measureUnit;
    private Set<AllergenDTO> allergens;
    private IngredientType ingredientType;
    private AvailabilityPeriod availabilityPeriod;
    private BrandDTO brand;
    private List<String> toppings;
    private List<String> fried;
    private List<String> doughs;
}
