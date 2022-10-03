package Es_D1;

public class BancaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double errVote;

	public BancaException(String message, double eV) {
		super(message);
		this.errVote = eV;
	}

	public double getErrVote() {
		return errVote;
	}

}
