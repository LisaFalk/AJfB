
public class Nucleotide {
	
	public int countA (Sequence seq){
		return seq.toString().replaceAll("U", "").replaceAll("C", "").replaceAll("G", "").replaceAll("-", "").length();
	}
	
	public int countC (Sequence seq){
		return seq.toString().replaceAll("U", "").replaceAll("A", "").replaceAll("G", "").replaceAll("-", "").length();
	}
	
	public int countG (Sequence seq){
		return seq.toString().replaceAll("U", "").replaceAll("C", "").replaceAll("A", "").replaceAll("-", "").length();
	}
	
	public int countU(Sequence seq){
		return seq.toString().replaceAll("A", "").replaceAll("C", "").replaceAll("G", "").replaceAll("-", "").length();
	}
	
	public int countGap (Sequence seq){
		return seq.toString().replaceAll("U", "").replaceAll("C", "").replaceAll("G", "").replaceAll("A", "").length();
	}
}
