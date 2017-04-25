package me.mancos.data.model;

/**
 * Created by mancos on 2017/3/17.
 * 下午2:12
 * TODO:
 */
public class TimeModel extends ItemTypeModel {
    public static final String sTABLE_NAME = "TIME_TABLE";
    public static final String _id = "_id";
    public static final String sNAME = "NAME";
    public static final String sCREATE_TIME = "CREATE_TIME";
    public static final String sUPDATE_TIME = "UPDATE_TIME";
    public static final String sSTATE = "STATE";
    public static final String sKEEP_TIME = "KEEP_TIME";

    private long id;
    private String name;
    private String crateTime;
    private String updateTime;
    private int state;
    private int keepTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getKeepTime() {
        return keepTime;
    }

    public void setKeepTime(int keepTime) {
        this.keepTime = keepTime;
    }

    @Override
    public String toString() {
        return "TimeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crateTime='" + crateTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", state=" + state +
                ", keepTime=" + keepTime +
                '}';
    }
}
