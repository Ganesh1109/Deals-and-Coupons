package coupon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import coupon.controller.CouponController;
import coupon.model.Coupon;
import coupon.repo.CouponRepository;
import coupon.service.CouponService;


@SpringBootTest
class CouponApplicationTests {

    @MockBean
    CouponRepository couponRepository;

    @Autowired
    CouponController couponController;

    @Autowired
    CouponService couponService;

    @BeforeAll
	static void BeforeAllTests() {
		System.out.println("Start\n");
	}
    
    @BeforeEach
	void BeforeEachTest() {
		System.out.println("++++ Before each is printing ++++");
	}
    
    @Test
    public void getAllCouponsTest() {
        when(couponRepository.findAll()).thenReturn(   //return the list of records
                Stream.of(new Coupon("2", "", "", "", "","")).collect(Collectors.toList()));
        assertEquals(0, couponController.getAllCoupons().size());//we comparing it with the size
    }

    @Test
    public void addCouponTest() {
        Coupon coupon = new Coupon("200", "amazon", "ama12", "mobiles", "10% offer","");
        
        when(couponRepository.save(coupon)).thenReturn(coupon);
        assertEquals(coupon, couponController.addCoupon(coupon));
    }

    @Test
    public void deleteDealTest() {
        String couponId = "23";
        couponRepository.deleteById(couponId);
    }
    
    @AfterEach
	  void AfterEachTest() {
	    System.out.println("---- After each is printing ----\n");
	  }
    
    @AfterAll
	static void AfterAllTests() {
	    System.out.println("End");
	    }

}