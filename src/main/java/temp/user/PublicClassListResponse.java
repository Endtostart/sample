package temp.user;

import java.util.Date;

public class PublicClassListResponse {
    private Integer publicID;
    private Integer publicCategory;
    private String publicTitle;
    private Integer teacherID;
    private String teacherName;
    private Date startTime;
    private Date endTime;
    private String publicType;
    private String publicSubType;
    private Integer publicSort;
    private String description;
    private int enrollCount;
    private int viewCount;
    private Integer showInPublic;
    private String assistantJoinUrl;
    private String organizerJoinUrl;
    private String attendeeJoinUrl;
    private String attendeeViewUrl;
    private String studentViewUrl;
    private String qRCodeUrl;
    private String qRCodeOssUrl;

    private Integer zClass;

    //4.8.1新增返回字段
    private String userIdentity;//新老用量标识 0新老用量 1老用量 2新用量
    private String userIdentityName;//新老用量标识名称
    private Integer mktQrId;//活码id
    private String mktQrCode;//活码链接
    private Boolean isExistQrId;//是否存在活码id
    private String attributionOperation;//归属运营

    private String hasMktUrl;
    private String noMktUrl;
    private String showUrl;
    private String publicClassUrl;

    /**
     * 封面图
     */
    private String advertisingPositionUrl;
    /**
     * 直播大图
     */
    private String bigPhotoUrl;

    /**
     * 封面，直播大图标示 PublicClassPicEnum
     */
    private int uploadFlag;

    private String flagName;

    public Integer getPublicID() {
        return publicID;
    }

    public void setPublicID(Integer publicID) {
        this.publicID = publicID;
    }

    public Integer getPublicCategory() {
        return publicCategory;
    }

    public void setPublicCategory(Integer publicCategory) {
        this.publicCategory = publicCategory;
    }

    public String getPublicTitle() {
        return publicTitle;
    }

    public void setPublicTitle(String publicTitle) {
        this.publicTitle = publicTitle;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPublicType() {
        return publicType;
    }

    public void setPublicType(String publicType) {
        this.publicType = publicType;
    }

    public String getPublicSubType() {
        return publicSubType;
    }

    public void setPublicSubType(String publicSubType) {
        this.publicSubType = publicSubType;
    }

    public Integer getPublicSort() {
        return publicSort;
    }

    public void setPublicSort(Integer publicSort) {
        this.publicSort = publicSort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnrollCount() {
        return enrollCount;
    }

    public void setEnrollCount(int enrollCount) {
        this.enrollCount = enrollCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getShowInPublic() {
        return showInPublic;
    }

    public void setShowInPublic(Integer showInPublic) {
        this.showInPublic = showInPublic;
    }

    public String getAssistantJoinUrl() {
        return assistantJoinUrl;
    }

    public void setAssistantJoinUrl(String assistantJoinUrl) {
        this.assistantJoinUrl = assistantJoinUrl;
    }

    public String getOrganizerJoinUrl() {
        return organizerJoinUrl;
    }

    public void setOrganizerJoinUrl(String organizerJoinUrl) {
        this.organizerJoinUrl = organizerJoinUrl;
    }

    public String getAttendeeJoinUrl() {
        return attendeeJoinUrl;
    }

    public void setAttendeeJoinUrl(String attendeeJoinUrl) {
        this.attendeeJoinUrl = attendeeJoinUrl;
    }

    public String getAttendeeViewUrl() {
        return attendeeViewUrl;
    }

    public void setAttendeeViewUrl(String attendeeViewUrl) {
        this.attendeeViewUrl = attendeeViewUrl;
    }

    public String getStudentViewUrl() {
        return studentViewUrl;
    }

    public void setStudentViewUrl(String studentViewUrl) {
        this.studentViewUrl = studentViewUrl;
    }

    public String getqRCodeUrl() {
        return qRCodeUrl;
    }

    public void setqRCodeUrl(String qRCodeUrl) {
        this.qRCodeUrl = qRCodeUrl;
    }

    public String getqRCodeOssUrl() {
        return qRCodeOssUrl;
    }

    public void setqRCodeOssUrl(String qRCodeOssUrl) {
        this.qRCodeOssUrl = qRCodeOssUrl;
    }

    public Integer getzClass() {
        return zClass;
    }

    public void setzClass(Integer zClass) {
        this.zClass = zClass;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserIdentityName() {
        return userIdentityName;
    }

    public void setUserIdentityName(String userIdentityName) {
        this.userIdentityName = userIdentityName;
    }

    public Integer getMktQrId() {
        return mktQrId;
    }

    public void setMktQrId(Integer mktQrId) {
        this.mktQrId = mktQrId;
    }

    public String getMktQrCode() {
        return mktQrCode;
    }

    public void setMktQrCode(String mktQrCode) {
        this.mktQrCode = mktQrCode;
    }

    public Boolean getExistQrId() {
        return isExistQrId;
    }

    public void setExistQrId(Boolean existQrId) {
        isExistQrId = existQrId;
    }

    public String getAttributionOperation() {
        return attributionOperation;
    }

    public void setAttributionOperation(String attributionOperation) {
        this.attributionOperation = attributionOperation;
    }

    public String getHasMktUrl() {
        return hasMktUrl;
    }

    public void setHasMktUrl(String hasMktUrl) {
        this.hasMktUrl = hasMktUrl;
    }

    public String getNoMktUrl() {
        return noMktUrl;
    }

    public void setNoMktUrl(String noMktUrl) {
        this.noMktUrl = noMktUrl;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getPublicClassUrl() {
        return publicClassUrl;
    }

    public void setPublicClassUrl(String publicClassUrl) {
        this.publicClassUrl = publicClassUrl;
    }

    public String getAdvertisingPositionUrl() {
        return advertisingPositionUrl;
    }

    public void setAdvertisingPositionUrl(String advertisingPositionUrl) {
        this.advertisingPositionUrl = advertisingPositionUrl;
    }

    public String getBigPhotoUrl() {
        return bigPhotoUrl;
    }

    public void setBigPhotoUrl(String bigPhotoUrl) {
        this.bigPhotoUrl = bigPhotoUrl;
    }

    public int getUploadFlag() {
        return uploadFlag;
    }

    public void setUploadFlag(int uploadFlag) {
        this.uploadFlag = uploadFlag;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }
}
