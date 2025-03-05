package me.dio.dto;

import java.util.List;

public class UserDTO {
    private String name;
    private String CPF;
    private List<Integer> favoriteBookIds;
    private List<Integer> wishlistBookIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public List<Integer> getFavoriteBookIds() {
        return favoriteBookIds;
    }

    public void setFavoriteBookIds(List<Integer> favoriteBookIds) {
        this.favoriteBookIds = favoriteBookIds;
    }

    public List<Integer> getWishlistBookIds() {
        return wishlistBookIds;
    }

    public void setWishlistBookIds(List<Integer> wishlistBookIds) {
        this.wishlistBookIds = wishlistBookIds;
    }
}
