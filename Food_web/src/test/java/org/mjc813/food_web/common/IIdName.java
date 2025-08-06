package org.mjc813.food_web.common;

public interface IIdName {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String id);

    default void copyMembersIdName(IIdName iFoodCategory) {
        if ( iFoodCategory == null ) {  // 매개변수의 객체가 null 이면 복사 중지
            return;
        }
        this.setId(iFoodCategory.getId());
        this.setName(iFoodCategory.getName());
    }

    default void copyMembersIdNameNotNull(IIdName iFoodCategory) {
        if ( iFoodCategory == null ) {  // 매개변수의 객체가 null 이면 복사 중지
            return;
        }
        if (iFoodCategory.getId() != null) {  // 매개변수의 객체의 멤버변수 id가 null 이면 복사 중지
            this.setId(iFoodCategory.getId());
        }
        if (iFoodCategory.getName() != null) {  // 매개변수의 객체의 멤버변수 name이 null 이면 복사 중지
            this.setName(iFoodCategory.getName());
        }
    }
}
