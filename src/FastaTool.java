import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FastaTool {
	private Map<String, Sequence> firstHalf = new LinkedHashMap<String, Sequence>();
	private Map<String, Sequence> secoundHalf = new LinkedHashMap<String, Sequence>();
	private int min = Integer.MAX_VALUE;
	private int minExcluding = Integer.MAX_VALUE;
	private int sum;
	private int sumExcluding;
	private int max;
	private int maxExcluding;

	public void read(Reader r) throws IOException {
		BufferedReader br = new BufferedReader(r);
		String line = null;
		String key = null;
		String value1 = null;
		String value2 = null;
		while ((line = br.readLine()) != null) {
			if (line.startsWith(">")) {
				if (value1 != null && value2 != null) {
					if ((value1.length() + value2.length()) > max) {
						max = (value1.length() + value2.length());
					}
					
					if ((value1.replaceAll("-", "").length() + value2.replaceAll("-", "").length()) > maxExcluding) {
						maxExcluding = value1.replaceAll("-", "").length() + value2.replaceAll("-", "").length();
					}

					sum = sum + value1.length() + value2.length();
					sumExcluding = sumExcluding + value1.replaceAll("-", "").length() + value2.replaceAll("-", "").length();

					if ((value1.length() + value2.length()) < min) {
						min = (value1.length() + value2.length());
					}
					
					if ((value1.replaceAll("-", "").length() + value2.replaceAll("-", "").length()) < minExcluding) {
						minExcluding = value1.replaceAll("-", "").length() + value2.replaceAll("-", "").length();
					}
					
					Sequence seq1 = new Sequence(value1);
					firstHalf.put(key, seq1);
					value1 = null;
					Sequence seq2 = new Sequence(value2);
					secoundHalf.put(key, seq2);
					value2 = null;
				}
				key = line.substring(1);
			} else {
				if (value1 == null) {
					value1 = line;
				} else if (value2 == null) {
					value2 = line;
				}
			}
		}
	}

	public Map<String, Sequence> getFirstHalf() {
		return firstHalf;
	}

	public void setFirstHalf(Map<String, Sequence> firstHalf) {
		this.firstHalf = firstHalf;
	}

	public Map<String, Sequence> getSecoundHalf() {
		return secoundHalf;
	}

	public void setSecoundHalf(Map<String, Sequence> secoundHalf) {
		this.secoundHalf = secoundHalf;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMinExcluding() {
		return minExcluding;
	}

	public void setMinExcluding(int minExcluding) {
		this.minExcluding = minExcluding;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSumExcluding() {
		return sumExcluding;
	}

	public void setSumExcluding(int sumExcluding) {
		this.sumExcluding = sumExcluding;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMaxExcluding() {
		return maxExcluding;
	}

	public void setMaxExcluding(int maxExcluding) {
		this.maxExcluding = maxExcluding;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FastaTool object = new FastaTool();
		CommandLine cmd = new CommandLine();
		object.read(new FileReader(args[0]));
		cmd.print(object.firstHalf, object.secoundHalf, object);

	}

}
