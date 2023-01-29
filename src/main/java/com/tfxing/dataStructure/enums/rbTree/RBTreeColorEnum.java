package com.tfxing.dataStructure.enums.rbTree;

/**
 * @author :tanfuxing
 * @date :2023/1/10
 * @description :
 */
public enum RBTreeColorEnum {
    
    BLACK(true,"BLACK"),
    
    RED(false,"RED");
    
    private final Boolean color;
    
    private final String desc;
    
    
    private RBTreeColorEnum(boolean color, String desc) {
        this.color = color;
        this.desc = desc;
    }
    
    public static String getDescByKey(Boolean color) {
        String desc = "";
        for (RBTreeColorEnum rbTreeColorEnum : RBTreeColorEnum.values()) {
            if(rbTreeColorEnum.color.equals(color)) {
                desc = rbTreeColorEnum.desc;
                break;
            }
        }
        return desc;
    }

    public boolean getKey() {
        return this.color;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
}
