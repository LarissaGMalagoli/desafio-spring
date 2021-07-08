package br.com.grupo3.socialmeli.dto;

public class QuantityProductPromoDto {
    private Long userId;
    private String userName;
    private Long promoProducts_count;

    public QuantityProductPromoDto(Long userId, String userName, Long promoProducts_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoProducts_count = promoProducts_count;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Long getPromoProducts_count() {
        return promoProducts_count;
    }
}
