package coupon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Coupons")
@NoArgsConstructor
@AllArgsConstructor
@Data

@Getter
@Setter
public class Coupon {

	@Id
    private String id;
    private String provider;
    private String code;
    private String category;
    private String description;	
    private String expiryDate;
	
}
