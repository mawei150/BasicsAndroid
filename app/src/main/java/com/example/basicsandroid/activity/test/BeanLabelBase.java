package com.example.basicsandroid.activity.test;

import java.io.Serializable;
import java.util.List;

//标签名字
public class BeanLabelBase implements Serializable {

    private String name;
    private String isOpen;//是否展开
    /**
     * total : 9
     * institutionCode : 6338985180526542851
     * state : 0
     * patIdArr : [{"patIdEnd":"992269233","patIdStart":"6392613304"},{"patIdEnd":"940953159","patIdStart":"6407174053"},{"patIdEnd":"029489082","patIdStart":"6406742305"},{"patIdEnd":"807588693","patIdStart":"6395467448"},{"patIdEnd":"807588693","patIdStart":"6395467448"},{"patIdEnd":"807588693","patIdStart":"6395467448"},{"patIdEnd":"487666365","patIdStart":"6616136411"},{"patIdEnd":"487666365","patIdStart":"6616136411"},{"patIdEnd":"487666365","patIdStart":"6616136411"},{"patIdEnd":"422886655","patIdStart":"6616137210"},{"patIdEnd":"422886655","patIdStart":"6616137210"},{"patIdEnd":"422886655","patIdStart":"6616137210"},{"patIdEnd":"483739287","patIdStart":"6616138905"},{"patIdEnd":"483739287","patIdStart":"6616138905"},{"patIdEnd":"483739287","patIdStart":"6616138905"},{"patIdEnd":"093867928","patIdStart":"6616141669"},{"patIdEnd":"093867928","patIdStart":"6616141669"},{"patIdEnd":"093867928","patIdStart":"6616141669"},{"patIdEnd":"324220121","patIdStart":"6616142190"},{"patIdEnd":"324220121","patIdStart":"6616142190"},{"patIdEnd":"324220121","patIdStart":"6616142190"}]
     * teamId : 6404560125763256467
     */

    private int total;
    private String institutionCode;
    private String state;
    private String teamId;
    private List<PatIdArrBean> patIdArr;
    private String type;//关联患者为"2",团队为"1"
    private boolean isGainPatientContent;//表示是否获取患者内容  因为首先点击全选的时候  并没有拿到或者内容

    //我的关联患者相关
    private List<PatIdArrBean> dpIdArr;
    private int dpCount;
    private boolean selected;
    private String centerId;
    private String pLists;
    private String mUserIdList;

    private String teamImageUriLong;
    private String institutionName;// -> 江苏省人民医院肾内科
    private String doctorName;//团队成员
    private String introduction;//团队介绍
    private int  patCount;
    //4.30 前端新加字段
    private String selectedAll;//表示自定义是否选择全部  1:选择全部  2.全部没选择  3.选了一部分

    //超滤量  24小时尿量  总饮水量  体重  血压
    private String filtrationAmount;//总超滤量
    private boolean isEmptyFiltration;

    private int waterTotal;//饮水量
    private int urineTotal;//24小时尿量
    private String weight;//体重
    private boolean isEmptyWeight;

    private int systolicPressure;//收缩压->高压
    private int diastolicPressure;//舒张压->低压
    private boolean isEmptyBloodPressure;//血压是否是暂无数据  这里主要分辨  当患者数据填的是0 那就是有数据  没填就是暂无数据
    private String patientCount;
    private String tagName;
    private String icdCode;// -> Q61.300
    private String diagnosisOther;// -> 肠道病原性大肠杆菌感染
    private String concentration;//浓度
    private String irrigationVolume;//灌入量
    private String retentionTime;//留存时间


    public BeanLabelBase(String name, String concentration, String irrigationVolume, String retentionTime) {
        this.name = name;
        this.concentration = concentration;
        this.irrigationVolume = irrigationVolume;
        this.retentionTime = retentionTime;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String getIrrigationVolume() {
        return irrigationVolume;
    }

    public void setIrrigationVolume(String irrigationVolume) {
        this.irrigationVolume = irrigationVolume;
    }

    public String getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(String retentionTime) {
        this.retentionTime = retentionTime;
    }

    public String getDiagnosisOther() {
        return diagnosisOther;
    }

    public void setDiagnosisOther(String diagnosisOther) {
        this.diagnosisOther = diagnosisOther;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setPatCount(int patCount) {
        this.patCount = patCount;
    }

    public int getPatCount() {
        return patCount;
    }

    public String getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(String patientCount) {
        this.patientCount = patientCount;
    }

    public boolean isEmptyWeight() {
        return isEmptyWeight;
    }

    public void setEmptyWeight(boolean emptyWeight) {
        isEmptyWeight = emptyWeight;
    }

    public boolean isEmptyFiltration() {
        return isEmptyFiltration;
    }

    public void setEmptyFiltration(boolean emptyFiltration) {
        isEmptyFiltration = emptyFiltration;
    }

    public boolean isEmptyBloodPressure() {
        return isEmptyBloodPressure;
    }

    public void setEmptyBloodPressure(boolean emptyBloodPressure) {
        isEmptyBloodPressure = emptyBloodPressure;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFiltrationAmount() {
        return filtrationAmount;
    }

    public void setFiltrationAmount(String filtrationAmount) {
        this.filtrationAmount = filtrationAmount;
    }

    public int getWaterTotal() {
        return waterTotal;
    }

    public void setWaterTotal(int waterTotal) {
        this.waterTotal = waterTotal;
    }

    public int getUrineTotal() {
        return urineTotal;
    }

    public void setUrineTotal(int urineTotal) {
        this.urineTotal = urineTotal;
    }


    public String getTeamImageUriLong() {
        return teamImageUriLong;
    }

    public void setTeamImageUriLong(String teamImageUriLong) {
        this.teamImageUriLong = teamImageUriLong;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public BeanLabelBase(String name) {
        this.name = name;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public BeanLabelBase(String name, boolean selected, String centerId) {
        this.name = name;
        this.selected = selected;
        this.centerId = centerId;
    }


    public BeanLabelBase(String name, boolean selected, String centerId, String patientCount) {
        this.name = name;
        this.selected = selected;
        this.centerId = centerId;
        this.patientCount = patientCount;
    }

    public String getSelectedAll() {
        return selectedAll;
    }

    public void setSelectedAll(String selectedAll) {
        this.selectedAll = selectedAll;
    }



    public boolean isGainPatientContent() {
        return isGainPatientContent;
    }

    public void setGainPatientContent(boolean gainPatientContent) {
        isGainPatientContent = gainPatientContent;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getpLists() {
        return pLists;
    }

    public void setpLists(String pLists) {
        this.pLists = pLists;
    }

    public String getmUserIdList() {
        return mUserIdList;
    }

    public void setmUserIdList(String mUserIdList) {
        this.mUserIdList = mUserIdList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BeanLabelBase() {
    }

    public List<PatIdArrBean> getDpIdArr() {
        return dpIdArr;
    }

    public void setDpIdArr(List<PatIdArrBean> dpIdArr) {
        this.dpIdArr = dpIdArr;
    }

    public int getDpCount() {
        return dpCount;
    }

    public void setDpCount(int dpCount) {
        this.dpCount = dpCount;
    }

    public BeanLabelBase(String name, String isOpen) {
        this.name = name;
        this.isOpen = isOpen;
    }

    public BeanLabelBase(String name, boolean selected) {
        this.name = name;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public List<PatIdArrBean> getPatIdArr() {
        return patIdArr;
    }

    public void setPatIdArr(List<PatIdArrBean> patIdArr) {
        this.patIdArr = patIdArr;
    }

    public static class PatIdArrBean {
        /**
         * patIdEnd : 992269233
         * patIdStart : 6392613304
         */

        private String patIdEnd;
        private String patIdStart;
        private String patUserIdEnd;
        private String patUserIdStart;


        public String getPatUserIdEnd() {
            return patUserIdEnd;
        }

        public void setPatUserIdEnd(String patUserIdEnd) {
            this.patUserIdEnd = patUserIdEnd;
        }

        public String getPatUserIdStart() {
            return patUserIdStart;
        }

        public void setPatUserIdStart(String patUserIdStart) {
            this.patUserIdStart = patUserIdStart;
        }

        public String getPatIdEnd() {
            return patIdEnd;
        }

        public void setPatIdEnd(String patIdEnd) {
            this.patIdEnd = patIdEnd;
        }

        public String getPatIdStart() {
            return patIdStart;
        }

        public void setPatIdStart(String patIdStart) {
            this.patIdStart = patIdStart;
        }
    }
}
