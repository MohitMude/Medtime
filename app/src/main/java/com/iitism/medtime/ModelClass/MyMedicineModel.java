package com.iitism.medtime.ModelClass;

public class MyMedicineModel {
String medname,medtype;

    public MyMedicineModel(String medname, String medtype) {
        this.medname = medname;
        this.medtype = medtype;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public String getMedtype() {
        return medtype;
    }

    public void setMedtype(String medtype) {
        this.medtype = medtype;
    }
}
