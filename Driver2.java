/* Jamey Dogom
   Comp. 282
   Project 2 */  
   
public class Driver2 {
public static void main(String args[])
{
	long startTime1,endTime1,totalTime1;
	long startTime2,endTime2,totalTime2;
	
	startTime1= System.currentTimeMillis();

	SplayTree t = new SplayTree();	
	t.insert(5);
	t.delete(1);
	endTime1 = System.currentTimeMillis();
	
	startTime2= System.currentTimeMillis();
	TwoThreeTree t1 = new TwoThreeTree();	
	t.insert(5);
	endTime2= System.currentTimeMillis();
	
	totalTime1 = endTime1-startTime1;
	totalTime2 = endTime2-startTime2;
	
	System.out.println("\tStartTime\tEndTime\t\tTotalTime");
	System.out.println("Splay   "+startTime1+"\t"+endTime1+"\t"+totalTime1);
	System.out.println("TwoThree"+startTime2+"\t"+endTime2+"\t"+totalTime2);
}
}
