package admin.controller;

import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;

import admin.model.Coupon;
import admin.repo.CouponRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    RestTemplate restTemplate;
    
    private CouponRepository couponRepository;

    @GetMapping(value = "/listCoupon")
    public List<Coupon> getAllCoupons(){
        return Arrays.asList(restTemplate.getForObject("http://coupons/coupons/list",Coupon[].class));
    }

    @PostMapping(value = "/addCoupon")
    public  String addCoupon(@RequestBody Coupon coupon){
        return restTemplate.postForObject("http://coupons/coupons/add",coupon,String.class);
    }

    @DeleteMapping(value = "/deleteCoupon/{couponID}")
    public String deleteProduct(@PathVariable String couponID) {
        restTemplate.delete("http://coupons/coupons/delete/{couponID}", couponID, String.class);
        return "Deleted Successfully";
    }

    @PutMapping(value = "/updateCoupon/{couponID}")
    public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
        restTemplate.put("http://coupons/coupons/update/{couponID}",coupon,couponID,String.class);
        return "coupon Updated Succesfully";
    }
}
