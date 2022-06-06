package coupon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coupon.model.Coupon;
import coupon.repo.CouponRepository;

@Service
public class CouponService {
	
	@Autowired
	private CouponRepository couponRepository;
	
	public List<Coupon> getAllCoupons(){
		List<Coupon> topics = new ArrayList<>();
		couponRepository.findAll()
		.forEach(topics::add);
		return topics;
	} 
	
	public Coupon addCoupon(Coupon topic) {
		return couponRepository.save(topic);
	}

	public Coupon updateCoupon(String id, Coupon topic) {	
		return couponRepository.save(topic);
	}

	public void deleteProduct(String id) {
		couponRepository.deleteById(id);
	}
}
