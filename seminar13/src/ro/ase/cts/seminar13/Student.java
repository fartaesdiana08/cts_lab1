package ro.ase.cts.seminar13;

import ro.ase.cts.seminar13.exceptions.StudentExceptionWrongValue;

public class Student {
	String nume;
	int varsta;
	int note[];
	
	private static final int NOTA_MAX = 10;
	private static final int NOTA_MIN = 10;
	
	public Student(String nume, int varsta, int[] note) {
		super();
		this.nume = nume;
		this.varsta = varsta;
		this.note = note;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) throws StudentExceptionWrongValue {
		if (varsta < 0)
			throw new StudentExceptionWrongValue("Value can't be belox 0");
		this.varsta = varsta;
	}

	public int[] getNote() {
		return note;
	}

	public void setNote(int[] note) throws StudentExceptionWrongValue {
		if (note != null) {
			for (int i = 0; i < note.length; i++) {
				if (note[i] > NOTA_MAX || note[i] < NOTA_MIN)
					throw new StudentExceptionWrongValue("Invalid input for nota - " + note[i]);

			}
			
		}
		this.note = note;
	}

	public float calculMedie() throws StudentExceptionWrongValue {
		if (note == null) {
			throw new StudentExceptionWrongValue("empty dataset - note");
		}
		float suma = 0;
		for (int i = 0; i < note.length; i++) {
			suma += note[i];
		}

		float medie = suma / note.length;
		return (int) (medie * 100) / 100.0f;
	}


}