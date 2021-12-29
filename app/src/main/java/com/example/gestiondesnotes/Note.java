package com.example.gestiondesnotes;

public class Note {
    double note;
    String module;

    public Note(double note,String module){

        this.note=note;
        this.module=module;
    }
    public Note(){}

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
