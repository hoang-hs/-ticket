package sherlock.ticket.present.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Order {
    @NotNull
    @Min(0)
    @JsonProperty("product_id")
    Long productId;
    @NotNull
    @Min(0)
    Integer number;

    public Order() {
        productId = 0L;
        number = 0;
    }

    public @NotNull Long getProductId() {
        return productId;
    }

    public @NotNull Integer getNumber() {
        return number;
    }
}
