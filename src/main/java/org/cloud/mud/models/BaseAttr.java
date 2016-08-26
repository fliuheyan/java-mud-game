package org.cloud.mud.models;

public enum BaseAttr {
    HP(100), MP(50), Att(30), Def(10),Agi(10);
    private int base;

    BaseAttr(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
