package iplanalyser.enums;


import iplanalyser.dao.RunDAO;
import iplanalyser.model.RunClass;

public enum Type {
    RUN(RunClass.class);

    private Class klass;

    Type(Class klass){
        this.klass=klass;
    }

    public Class getKlass(){
        return this.klass;
    }

}
