package iplanalyser.enums;


import iplanalyser.model.RunClass;
import iplanalyser.model.WicketClass;

public enum Type {
    RUN(RunClass.class),
    WICKET(WicketClass.class);

    private Class klass;

    Type(Class klass){
        this.klass=klass;
    }

    public Class getKlass(){
        return this.klass;
    }

}
