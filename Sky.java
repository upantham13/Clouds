package weather;
import java.util.ArrayList;

public class Sky {
	private ArrayList<Cloud> clouds;
	
	public Sky() {
		clouds = new ArrayList<Cloud>(100);
	}
	
	public boolean add(Cloud c) {
		clouds.add(c);
		return true;
	}
	
	public float getMeanHeight() {
		float sum = 0;
		for (Cloud c: clouds) {
			sum += c.getHeight();			
		}
		return sum / clouds.size();
	}
	
	public static void main(String[] args)
	{
		Sky sky = new Sky();
		
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		sky.add(strat);
		
		float stratMean = sky.getMeanHeight();
		if (stratMean < 899  ||  stratMean > 901)
			System.out.println("Bad mean height: expected 900, saw " + stratMean);
		System.out.println("Everything (else) is ok");
		
		CumulusCloud cumulus = new CumulusCloud(100, 1000);
		if (!cumulus.rain().startsWith("It is raining"))
			System.out.println("Bad CumulusCloud::rain");
		sky.add(cumulus);
		
		float cumulusMean = sky.getMeanHeight();
		if (cumulusMean < 899  ||  cumulusMean > 901)
			System.out.println("Bad mean height: expected 900, saw " + cumulusMean);
		System.out.println("Everything (else) is ok");
		
		CirrusCloud cirrus = new CirrusCloud(100, 1000);
		if (!cirrus.rain().startsWith("I cannot make"))
			System.out.println("Bad CirrusCloud::rain");
		sky.add(cirrus);
		
		float cirrusMean = sky.getMeanHeight();
		if (cirrusMean < 899  ||  cirrusMean > 901)
			System.out.println("Bad mean height: expected 900, saw " + cirrusMean);
		System.out.println("Everything (else) is ok");
	}

}
