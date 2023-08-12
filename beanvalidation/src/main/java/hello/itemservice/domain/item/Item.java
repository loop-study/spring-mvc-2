package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// 자바 코드로 사용하자.
// @ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10,000원 넘게 입력해주세요.") // 복잡해서 잘 사용안함.
@Data
public class Item {

//    @NotNull // 수정 요구사항
    private Long id;

//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
//    @NotBlank
    private String itemName;    // A

//    @NotNull
//    @Range(min = 1000, max=1000000,groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;      // A, typeMismatch 이런 경우 빈벨리데이션 적용안됨.

//    @NotNull
//    @Max(value = 9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
