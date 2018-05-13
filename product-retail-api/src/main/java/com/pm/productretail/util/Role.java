package com.pm.productretail.util;

/**
 * @author lnurullina
 */
public enum Role {
    SUPERUSER("Владелец"),
    WAREHOUSE_HEAD("Директор склада"),
    WAREHOUSE_WORKER("Работник склада"),
    SHOP_HEAD("Директор магазина"),
    STUFF_MANAGER("Менеджер магазина"),
    SELLER("Продавец");

    private String name;

    public static Role findByValue(String value){
        for(Role role:values()){
            if (role.toString().equals(value)){
                return role;
            }
        }
        return null;
    }

    Role(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
