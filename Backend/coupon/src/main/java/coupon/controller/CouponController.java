package coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupon.model.Coupon;
import coupon.service.CouponService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/coupons")

public class CouponController {

	@Autowired
	private CouponService couponService;
	
	@GetMapping(value = "/list")
	public List<Coupon> getAllCoupons(){
		return couponService.getAllCoupons();
	}
	
	@PostMapping(value = "/add")
	public Coupon addCoupon(@RequestBody Coupon topic) {
		return couponService.addCoupon(topic);
		//return "added";
	}
	
	//updating existing topics in url topicslist we use PUT
	@PutMapping(value = "/update/{couponID}")
	public Coupon updateCoupon(@RequestBody Coupon topic, @PathVariable String couponID) {
		return couponService.updateCoupon(couponID, topic);
		//return "coupon Updated Succesfully";
	}
	
	//deleting available topics in url topicslist we use DELETE
	@DeleteMapping(value = "/delete/{couponID}")
	public String deleteProduct(@PathVariable String couponID) {
		couponService.deleteProduct(couponID);
		return "Deleted Successfully";
	}
}

    /*@Autowired
    private CouponRepository couponRepository;

    @GetMapping(value = "/list")
    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }

    @PostMapping(value = "/add")
    public Coupon addCoupon(@RequestBody Coupon coupon){
    	return couponRepository.save(coupon);
    }
    
    
    @DeleteMapping(value = "/delete/{couponID}")
    public String deleteProduct(@PathVariable String couponID) {
       System.out.println("Delete method called");
        couponRepository.deleteById(couponID);
        return "Deleted Successfully";
    }
    
    
    @PutMapping(value = "/update/{couponID}")
    public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
        couponRepository.save(coupon);
        return "coupon Updated Succesfully";
    }
}*/
