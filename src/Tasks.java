
public class Tasks {
	private char letterOfProcess;
	private int arrival; // llegada
	private int duration; // duration
	private int start; // inicio
	private int end; // fin
	private int T; // end - arrival
	private int E; // (T - t)
	private float P; // ( T / t )

	public Tasks(char letterOfProcess, int arrival, int duration) {
		this.letterOfProcess = letterOfProcess;
		this.arrival = arrival;
		this.duration = duration;
	}

	public int ConvertMyLetterToAsci() {
		System.out.println((int) letterOfProcess);
		return letterOfProcess;
	}

	public char getLetterOfProcess() {
		return letterOfProcess;
	}

	public void setLetterOfProcess(char letterOfProcess) {
		this.letterOfProcess = letterOfProcess;
	}

	public int getArrival() {
		return arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd() {

		this.end = this.duration + this.start;

	}

	public int getT() {
		return T;
	}

	public void setT(int t) {
		T = t;
	}

	public int getE() {

		return E;
	}

	public void setE() {
		E = (this.end - this.arrival) - this.duration;
	}

	public float getP() {
		return P;
	}

	public void setP(float p) {
		P = p;
	}
}
