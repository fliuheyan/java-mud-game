package org.cloud.mud.models;

public class BaseInfo {
    protected final static float PLAYER_ATTR_RATE = 0.3f;  //1
    protected final static float NPC_ATTR_RATE = 0.2f;     //2
    protected final static float BOSS_ATTR_RATE = 0.4f;    //3

    private int hp;
    private int mp;
    private int att;
    private int def;
    private int agi;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public void build(float rate, int level) {
        setHp(Math.round(BaseAttr.HP.getBase() * (1 + level * rate)));
        setMp(Math.round(BaseAttr.MP.getBase() * (1 + level * rate)));
        setAtt(Math.round(BaseAttr.Att.getBase() * (1 + level * rate)));
        setDef(Math.round(BaseAttr.Def.getBase() * (1 + level * rate)));
        setAgi(Math.round(BaseAttr.Agi.getBase() * (1 + level * rate)));
    }
}
