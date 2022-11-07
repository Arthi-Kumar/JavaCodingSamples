import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HierarchyPeriodsImplementation {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		HierarchyPeriods hp = new HierarchyPeriods();
		List<HierarchyPeriods> list = new ArrayList<>();
		list.add(new HierarchyPeriods("27-06-2022","31-12-3099"));
		SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the input date");
		String date = sc.next();
		Date d = sdformat.parse(date);
	
		boolean ans = list.isEmpty();
		if(ans == true) {
		System.out.println("Hierarchy period is" +d+ "31-12-3099");
		}
		else {
			Date d1 = null,d2 = null;
			List<Date> li = new ArrayList<>();
			for(HierarchyPeriods x : list) {
				d1 = sdformat.parse(x.getEffectiveFrom());
				d2 = sdformat.parse(x.getEffectivetill());
			}
			if(d.compareTo(d1)<0) {
				LocalDate mdate = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate middleDate = mdate.minusDays(1);
				Date md = new SimpleDateFormat("yyyy-MM-dd").parse(middleDate.toString());
//				hp.setEffectiveFrom(d1.toString());
//				hp.setEffectivetill(d2.toString());
				li.add(0,d);
				li.add(1,md);
				li.add(2,d1);
				li.add(3,d2);
				for(Date dates : li) {
					System.out.println(dates);
					
				}	
			}
			
			else if(d.compareTo(d1)>0) {
				LocalDate mdate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate middleDate = mdate.minusDays(1);
				Date md = new SimpleDateFormat("yyyy-MM-dd").parse(middleDate.toString());
//				hp.setEffectiveFrom(d1.toString());
//				hp.setEffectivetill(d2.toString());
				li.add(0,d1);
				li.add(1,md);
				li.add(2,d);
				li.add(3,d2);
				for(Date dates : li) {
					System.out.println(dates);
					
				}	
				
			}
			
		}
		
		
		
		
	}

}
