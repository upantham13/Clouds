package weather;

public class CirrusCloud extends Cloud {
	
	CirrusCloud(float top, float bottom) {
		super(top, bottom);
	}
	@Override
	public String rain() {
		return "I cannot make rain";
	}
}
