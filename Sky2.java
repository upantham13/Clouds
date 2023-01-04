package weather;
import java.util.ArrayList;

//Resources Used:
//CS 46B Discord: Many of my peers had the same questions as I had in the group chat and I built off of the constructive help that some peers gave.

public class Sky2 extends ArrayList<Cloud> {
	
	public Sky2() {
		super(100);
	}
	
	public float getMeanHeight() {
		float sum = 0;
		for (Cloud c: this) {
			sum += c.getHeight();			
		}
		return sum / this.size();
	}
	
	public boolean add(Cloud c) {
		super.add(c);		
		return true;
	}
	
	public static void main(String[] args)
	{
		Sky2 sky2 = new Sky2();
		
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		sky2.add(strat);
		
		float stratMean = sky2.getMeanHeight();
		if (stratMean < 899  ||  stratMean > 901)
			System.out.println("Bad mean height: expected 900, saw " + stratMean);
		System.out.println("Everything (else) is ok");
		
		CumulusCloud cumulus = new CumulusCloud(100, 1000);
		if (!cumulus.rain().startsWith("It is raining"))
			System.out.println("Bad CumulusCloud::rain");
		sky2.add(cumulus);
		
		float cumulusMean = sky2.getMeanHeight();
		if (cumulusMean < 899  ||  cumulusMean > 901)
			System.out.println("Bad mean height: expected 900, saw " + cumulusMean);
		System.out.println("Everything (else) is ok");
		
		CirrusCloud cirrus = new CirrusCloud(100, 1000);
		if (!cirrus.rain().startsWith("I cannot make"))
			System.out.println("Bad CirrusCloud::rain");
		sky2.add(cirrus);
		
		float cirrusMean = sky2.getMeanHeight();
		if (cirrusMean < 899  ||  cirrusMean > 901)
			System.out.println("Bad mean height: expected 900, saw " + cirrusMean);
		System.out.println("Everything (else) is ok");
	}
}
