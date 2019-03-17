package App.Domain;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ShopCar {
    private Integer shopCarId;
    private Integer userId;
    private String goodsName;
    private String goodsImg;
    private Double goodsPrice;
    private Integer purchaseQuantity;

}
