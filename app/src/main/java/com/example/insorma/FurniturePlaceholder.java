package com.example.insorma;

public class FurniturePlaceholder {
    String FurnitureName, FurnitureRating, FurniturePrice, FurnitureDesc;
    Integer FurnitureImage;

    public FurniturePlaceholder(String furnitureName, String furnitureRating, String furniturePrice, String furnitureDesc, Integer furnitureImage) {
        FurnitureName = furnitureName;
        FurnitureRating = furnitureRating;
        FurniturePrice = furniturePrice;
        FurnitureDesc = furnitureDesc;
        FurnitureImage = furnitureImage;
    }

    public String getFurnitureName() {
        return FurnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        FurnitureName = furnitureName;
    }

    public String getFurnitureRating() {
        return FurnitureRating;
    }

    public void setFurnitureRating(String furnitureRating) {
        FurnitureRating = furnitureRating;
    }

    public String getFurniturePrice() {
        return FurniturePrice;
    }

    public void setFurniturePrice(String furniturePrice) {
        FurniturePrice = furniturePrice;
    }

    public String getFurnitureDesc() {
        return FurnitureDesc;
    }

    public void setFurnitureDesc(String furnitureDesc) {
        FurnitureDesc = furnitureDesc;
    }

    public Integer getFurnitureImage() {
        return FurnitureImage;
    }

    public void setFurnitureImage(Integer furnitureImage) {
        FurnitureImage = furnitureImage;
    }



}
