package com.mjc813.food_web.food.dto;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient.dto.IIngredient;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodEntity implements IFood {
    private Long id;
    private String name;
    private Integer spicyLevel;
    private Integer sweetLevel;
    private Integer sourLevel;
    private Integer saltyLevel;

    private Long ingredientId;
    private Long foodCategoryId;

    private IngredientEntity ingredientEntity;
    private FoodCategoryEntity foodCategoryEntity;

    @Override
    public IIngredient getIngredient() {
        return this.ingredientEntity;
    }

    @Override
    public void setIngredient(IIngredient iIngredient) {
        if ( iIngredient == null ) {
            return;
        }
        if ( this.ingredientEntity == null ) {
            this.ingredientEntity = new IngredientEntity();
        }
        this.ingredientEntity.copyMembersIngredient(iIngredient);
    }

    @Override
    public IIdName getFoodCategory() {
        return this.foodCategoryEntity;
    }

    @Override
    public void setFoodCategory(IIdName iIdName) {
        if ( iIdName == null ) {
            return;
        }
        if ( this.foodCategoryEntity == null ) {
            this.foodCategoryEntity = new FoodCategoryEntity();
        }
        this.foodCategoryEntity.copyMembersIdName(iIdName);
    }
}
