
public class predmet {
int IDPREDMET;
String NAZIV_PREDMETA; 
String OPIS_PREDMETA;
int BROJ_CASOVA;
String IME_PROFESORA;
public predmet(int iDPREDMET, String nAZIV_PREDMETA, String oPIS_PREDMETA, int bROJ_CASOVA, String iME_PROFESORA) {
	super();
	IDPREDMET = iDPREDMET;
	NAZIV_PREDMETA = nAZIV_PREDMETA;
	OPIS_PREDMETA = oPIS_PREDMETA;
	BROJ_CASOVA = bROJ_CASOVA;
	IME_PROFESORA = iME_PROFESORA;
}
public int getIDPREDMET() {
	return IDPREDMET;
}
public void setIDPREDMET(int iDPREDMET) {
	IDPREDMET = iDPREDMET;
}
public String getNAZIV_PREDMETA() {
	return NAZIV_PREDMETA;
}
public void setNAZIV_PREDMETA(String nAZIV_PREDMETA) {
	NAZIV_PREDMETA = nAZIV_PREDMETA;
}
public String getOPIS_PREDMETA() {
	return OPIS_PREDMETA;
}
public void setOPIS_PREDMETA(String oPIS_PREDMETA) {
	OPIS_PREDMETA = oPIS_PREDMETA;
}
public int getBROJ_CASOVA() {
	return BROJ_CASOVA;
}
public void setBROJ_CASOVA(int bROJ_CASOVA) {
	BROJ_CASOVA = bROJ_CASOVA;
}
public String getIME_PROFESORA() {
	return IME_PROFESORA;
}
public void setIME_PROFESORA(String iME_PROFESORA) {
	IME_PROFESORA = iME_PROFESORA;
}
@Override
public String toString() {
	return  IDPREDMET +  NAZIV_PREDMETA + OPIS_PREDMETA
			+  BROJ_CASOVA +  IME_PROFESORA ;
}



}
