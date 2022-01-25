package com.cg;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.repository.LendItemRepository;
import com.cg.service.LendItemService;
import com.cg.entity.LendItems;


@SuppressWarnings("unused")
@SpringBootTest
class LendItemsTesting {

	@Autowired
	LendItemService lendService;
	
	@MockBean
	com.cg.repository.LendItemRepository lendRepo;
	
	@Test
	void testinsertLend() {
		LendItems d1=new LendItems();
		
		d1.setLendId(1);
		String lendDate = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date = null;
		try {
			date = dt.parse(lendDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));
       
        String returnDate = " 2011-02-18 00:00:00.0";
        SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date1 = null;
		try {
			date1 = dt2.parse(returnDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt3 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt3.format(date1));
       
		d1.setFine(100);
		
		
	    Mockito.when(lendRepo.save(d1)).thenReturn(d1);		
		assertThat(lendService.insertLendItems(d1)).isEqualTo(d1);
	}
	@Test
	boolean testlendput() throws Throwable {
		LendItems  d1=new LendItems();
		
		d1.setLendId(1);
		String lendDate = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date = null;
		try {
			date = dt.parse(lendDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));
       
        String returnDate = " 2011-02-18 00:00:00.0";
        SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date1 = null;
		try {
			date1 = dt2.parse(returnDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt3 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt3.format(date1));
		d1.setFine(100);
		
		Optional<LendItems> d2=Optional.of(d1);
		
		Mockito.when(lendRepo.findById(1)).thenReturn(d2);
		
		Mockito.when(lendRepo.save(d1)).thenReturn(d1);
		d1.setFine(200);
		d1.setLendId(1);
		
		assertThat (lendService.updateLendItems(d1)).isEqualTo(d1);
		return true;
	}
	@Test
	void testviewall() {
		LendItems d1=new LendItems();
		d1.setLendId(1);
		String lendDate = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date = null;
		try {
			date = dt.parse(lendDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));
       
        String returnDate = " 2011-02-18 00:00:00.0";
        SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date1 = null;
		try {
			date1 = dt2.parse(returnDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt3 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt3.format(date1));
		d1.setFine(100);
		
		LendItems d2=new LendItems();
		d2.setLendId(1);
		String lendDate1 = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt4 = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date5 = null;
		try {
			date5 = dt4.parse(lendDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt6 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt6.format(date5));
       
        String returnDate1 = " 2011-02-18 00:00:00.0";
        SimpleDateFormat dt7 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date8 = null;
		try {
			date8 = dt7.parse(returnDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt8 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt8.format(date8));
		d2.setFine(200);

		List<LendItems> LendModelList = new ArrayList<>();
		LendModelList.add(d1);
		LendModelList.add(d2);
		
		Mockito.when(lendRepo.findAll()).thenReturn(LendModelList);
		
		assertThat(lendService.viewAllLendings()).isEqualTo(LendModelList);
	}
	@Test
	void testdeleteLendItems() {
		LendItems d1=new LendItems();
		d1.setLendId(1);
		String lendDate = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date = null;
		try {
			date = dt.parse(lendDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));
       
        String returnDate = " 2011-02-18 00:00:00.0";
        SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date1 = null;
		try {
			date1 = dt2.parse(returnDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt3 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt3.format(date1));
       
		d1.setFine(100);
		
		Optional<LendItems> d2=Optional.of(d1);
		
		Mockito.when(lendRepo.findById(1)).thenReturn(d2);
		 Mockito.when(lendRepo.existsById(d1.getLendId())).thenReturn(false);
		   assertFalse(lendRepo.existsById(d1.getLendId()));
	}
}

