package coupon.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import coupon.model.Coupon;

public interface CouponRepository extends MongoRepository<Coupon, String> {

    ///Coupon findProductById(String Id);

}
