package com.mjc813.food_web.food.dto;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.ingredient.dto.IIngredient;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "FoodEntity")
@Table(name = "food_tbl")
public class FoodDto implements IFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Long getIngredientId() {
        // Long ingredientId 값과 IngredientDto ingredientDto.getId() 값이 항상 같도록 get 하는 기능
        this.setIngredientId(this.ingredientId);
        return this.ingredientId;
    }

    @Override
    public void setIngredientId(Long ingredientId) {
        // Long ingredientId 값과 IngredientDto ingredientDto.getId() 값이 항상 같도록 set 하는 기능
        if (ingredientId == null) {
            if (this.ingredientDto != null && this.ingredientDto.getId() != null) {
                this.ingredientId = this.ingredientDto.getId();
            }
            return;
        }
        this.ingredientId = ingredientId;
        if (this.ingredientDto == null) {
            this.ingredientDto = new IngredientDto();
        }
        this.ingredientDto.setId(ingredientId);
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

    @Override
    public Long getFoodCategoryId() {
        // Long foodCategoryId 값과 FoodCategoryDto foodCategoryDto.getId() 값이 항상 같도록 get 하는 기능
        this.setFoodCategoryId(this.foodCategoryId);
        return this.foodCategoryId;
    }

    @Override
    public void setFoodCategoryId(Long foodCategoryId) {
        // Long foodCategoryId 값과 FoodCategoryDto foodCategoryDto.getId() 값이 항상 같도록 set 하는 기능
        if (foodCategoryId == null) {
            if (this.foodCategoryDto != null && this.foodCategoryDto.getId() != null) {
                this.foodCategoryId = this.foodCategoryDto.getId();
            }
            return;
        }
        this.foodCategoryId = ingredientId;
        if (this.foodCategoryDto == null) {
            this.foodCategoryDto = new FoodCategoryDto();
        }
        this.foodCategoryDto.setId(foodCategoryId);
    }
}
