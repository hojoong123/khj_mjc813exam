package org.mjc813.food_web.food.dto;

import org.mjc813.food_web.common.IIdName;
import org.mjc813.food_web.food_category.dto.FoodCategoryDto;
import org.mjc813.food_web.ingredient.dto.IIngredient;
import org.mjc813.food_web.ingredient.dto.IngredientDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDto implements IFood {
    private Long id;
    private String name;
    private Integer spicyLevel;
    private Integer sweetLevel;
    private Integer sourLevel;
    private Integer saltyLevel;

    private Long ingredientId;
    private Long foodCategoryId;

    private IngredientDto ingredientDto;
    private FoodCategoryDto foodCategoryDto;

    @Override
    public IIngredient getIngredient() {
        return this.ingredientDto;
    }

    @Override
    public void setIngredient(IIngredient iIngredient) {
        if ( iIngredient == null ) {
            return;
        }
        if ( this.ingredientDto == null ) {
            this.ingredientDto = new IngredientDto();
        }
        this.ingredientDto.copyMembersIngredient(iIngredient);
    }

    @Override
    public IIdName getFoodCategory() {
        return this.foodCategoryDto;
    }

    @Override
    public void setFoodCategory(IIdName iIdName) {
        if ( iIdName == null ) {
            return;
        }
        if ( this.foodCategoryDto == null ) {
            this.foodCategoryDto = new FoodCategoryDto();
        }
        this.foodCategoryDto.copyMembersIdName(iIdName);
    }
}
