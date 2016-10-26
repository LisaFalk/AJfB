
public class Sequence {
	private String seq;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Sequence(String seq) {
		super();
		this.seq = seq;
	}

	@Override
	public String toString() {
		return seq;
	}
}
