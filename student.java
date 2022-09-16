
public class student {
int IDSTUDENT;
String IME;
String PREZIME;
String TELEFON;
public student(int iDSTUDENT, String iME, String pREZIME, String tELEFON) {
	super();
	IDSTUDENT = iDSTUDENT;
	IME = iME;
	PREZIME = pREZIME;
	TELEFON = tELEFON;
}
public int getIDSTUDENT() {
	return IDSTUDENT;
}
public void setIDSUDENT(int iDSUDENT) {
	IDSTUDENT = iDSUDENT;
}
public String getIME() {
	return IME;
}
public void setIME(String iME) {
	IME = iME;
}
public String getPREZIME() {
	return PREZIME;
}
public void setPREZIME(String pREZIME) {
	PREZIME = pREZIME;
}
public String getTELEFON() {
	return TELEFON;
}
public void setTELEFON(String tELEFON) {
	TELEFON = tELEFON;
}
@Override
public String toString() {
	return  IDSTUDENT +" " + IME+" " +  PREZIME +" "+  TELEFON ;
}





}
