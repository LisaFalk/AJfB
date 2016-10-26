import java.util.Map;

public class CommandLine {

	public void print(Map<String, Sequence> map1, Map<String, Sequence> map2, FastaTool object){
		printSequence(map1);
		System.out.println();
		printSequence(map2);
		System.out.println();
		numberOfSequences(map1);
		minLength(object);
		avLength(map1, object);
		maxLength(object);
		count(map1, map2);
	}

	private void printSequence(Map<String, Sequence> map){

		for (Map.Entry<String, Sequence> entry : map.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
	
	private void numberOfSequences(Map<String, Sequence> map){
		System.out.println("Number of sequences: " + map.size());
	}
	
	private void minLength(FastaTool object){
		System.out.println("Shortest length: " + object.getMin() + " (excluding '-'s: " + object.getMinExcluding() + ")");
	}
	
	private void avLength(Map<String, Sequence> map, FastaTool object){
		int average = object.getSum()/map.size();
		int averageExcluding = object.getSumExcluding()/map.size();
		System.out.println("Average length: " + average + " (excluding '-'s: " + averageExcluding + ")");
	}
	
	private void maxLength(FastaTool object){
		System.out.println("Longest length: " + object.getMax() + " (excluding '-'s: " + object.getMaxExcluding() + ")");
	}
	
	private void count(Map<String, Sequence> map1, Map<String, Sequence> map2){
		Nucleotide nuc = new Nucleotide();
		int adenin = 0;
		int cytosin = 0;
		int guanin = 0;
		int uracil = 0;
		int gap = 0;
		for (Map.Entry<String, Sequence> entry : map1.entrySet())
		{
			adenin += nuc.countA(entry.getValue());
			cytosin += nuc.countC(entry.getValue());
			guanin += nuc.countG(entry.getValue());
			uracil += nuc.countU(entry.getValue());
			gap += nuc.countGap(entry.getValue());
		}
		for (Map.Entry<String, Sequence> entry : map2.entrySet())
		{
			adenin += nuc.countA(entry.getValue());
			cytosin += nuc.countC(entry.getValue());
			guanin += nuc.countG(entry.getValue());
			uracil += nuc.countU(entry.getValue());
			gap += nuc.countGap(entry.getValue());
		}
		System.out.println("Counts: A: " + adenin + ", C: " + cytosin + ", G: " + guanin + ", U: " + uracil + ", -: " + gap);
	}
}
