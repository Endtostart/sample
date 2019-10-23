package temp.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActivityRequest {
    private Integer activityId;
    private Integer businessmold;
    private Integer publicCategory;
    private String activityTitle;
    private String activityDescription;
    private Integer signUpExpectCount;
    private Integer signUpActualCount;
    @JsonFormat(
            timezone = "GMT+8",
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private Date startTime;
    @JsonFormat(
            timezone = "GMT+8",
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private Date endTime;
    private Date createTime;
    private Integer createdBy;
    private Date updateTime;
    private Integer updatedBy;
    private Integer isDeleted;
    private String linkUrl;
    private String activityCategory;
    private String activityShortDescription;
    private String activityTip;
    private String coverImageUrl;
    private Integer activityType;
    @JsonFormat(
            timezone = "GMT+8",
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private Date advertiseStartTime;
    @JsonFormat(
            timezone = "GMT+8",
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private Date advertiseEndTime;
    private Integer assistentWechatID;
    private String checkCode;
    private Integer[] teacherIds;
    private String qRCodeUrl;
    private String bindAccountUrl;
    private String[] activityItem;
    private String activityLabel;
    private String suitCrowds;
    private String solveProblems;
    private String recruitVideo;
    private String recruitImage;
    private String openingVideo;
    private String openingImage;
    private String questionKeyWords;
    private String analyseKeyWords;
    private String advertisingPositionUrl1;
    private String advertisingPositionUrl2;
    private String advertisingPositionUrl3;
    private Integer activitySort;
    private Integer userId;
    private String activityMainTitle;
    private String activitySubTitle;
    private String userPortraitImage;
    private String solution;
    private String userIdentity;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getBusinessmold() {
        return businessmold;
    }

    public void setBusinessmold(Integer businessmold) {
        this.businessmold = businessmold;
    }

    public Integer getPublicCategory() {
        return publicCategory;
    }

    public void setPublicCategory(Integer publicCategory) {
        this.publicCategory = publicCategory;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Integer getSignUpExpectCount() {
        return signUpExpectCount;
    }

    public void setSignUpExpectCount(Integer signUpExpectCount) {
        this.signUpExpectCount = signUpExpectCount;
    }

    public Integer getSignUpActualCount() {
        return signUpActualCount;
    }

    public void setSignUpActualCount(Integer signUpActualCount) {
        this.signUpActualCount = signUpActualCount;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getActivityCategory() {
        return activityCategory;
    }

    public void setActivityCategory(String activityCategory) {
        this.activityCategory = activityCategory;
    }

    public String getActivityShortDescription() {
        return activityShortDescription;
    }

    public void setActivityShortDescription(String activityShortDescription) {
        this.activityShortDescription = activityShortDescription;
    }

    public String getActivityTip() {
        return activityTip;
    }

    public void setActivityTip(String activityTip) {
        this.activityTip = activityTip;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Date getAdvertiseStartTime() {
        return advertiseStartTime;
    }

    public void setAdvertiseStartTime(Date advertiseStartTime) {
        this.advertiseStartTime = advertiseStartTime;
    }

    public Date getAdvertiseEndTime() {
        return advertiseEndTime;
    }

    public void setAdvertiseEndTime(Date advertiseEndTime) {
        this.advertiseEndTime = advertiseEndTime;
    }

    public Integer getAssistentWechatID() {
        return assistentWechatID;
    }

    public void setAssistentWechatID(Integer assistentWechatID) {
        this.assistentWechatID = assistentWechatID;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer[] getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(Integer[] teacherIds) {
        this.teacherIds = teacherIds;
    }

    public String getqRCodeUrl() {
        return qRCodeUrl;
    }

    public void setqRCodeUrl(String qRCodeUrl) {
        this.qRCodeUrl = qRCodeUrl;
    }

    public String getBindAccountUrl() {
        return bindAccountUrl;
    }

    public void setBindAccountUrl(String bindAccountUrl) {
        this.bindAccountUrl = bindAccountUrl;
    }

    public String[] getActivityItem() {
        return activityItem;
    }

    public void setActivityItem(String[] activityItem) {
        this.activityItem = activityItem;
    }

    public String getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(String activityLabel) {
        this.activityLabel = activityLabel;
    }

    public String getSuitCrowds() {
        return suitCrowds;
    }

    public void setSuitCrowds(String suitCrowds) {
        this.suitCrowds = suitCrowds;
    }

    public String getSolveProblems() {
        return solveProblems;
    }

    public void setSolveProblems(String solveProblems) {
        this.solveProblems = solveProblems;
    }

    public String getRecruitVideo() {
        return recruitVideo;
    }

    public void setRecruitVideo(String recruitVideo) {
        this.recruitVideo = recruitVideo;
    }

    public String getRecruitImage() {
        return recruitImage;
    }

    public void setRecruitImage(String recruitImage) {
        this.recruitImage = recruitImage;
    }

    public String getOpeningVideo() {
        return openingVideo;
    }

    public void setOpeningVideo(String openingVideo) {
        this.openingVideo = openingVideo;
    }

    public String getOpeningImage() {
        return openingImage;
    }

    public void setOpeningImage(String openingImage) {
        this.openingImage = openingImage;
    }

    public String getQuestionKeyWords() {
        return questionKeyWords;
    }

    public void setQuestionKeyWords(String questionKeyWords) {
        this.questionKeyWords = questionKeyWords;
    }

    public String getAnalyseKeyWords() {
        return analyseKeyWords;
    }

    public void setAnalyseKeyWords(String analyseKeyWords) {
        this.analyseKeyWords = analyseKeyWords;
    }

    public String getAdvertisingPositionUrl1() {
        return advertisingPositionUrl1;
    }

    public void setAdvertisingPositionUrl1(String advertisingPositionUrl1) {
        this.advertisingPositionUrl1 = advertisingPositionUrl1;
    }

    public String getAdvertisingPositionUrl2() {
        return advertisingPositionUrl2;
    }

    public void setAdvertisingPositionUrl2(String advertisingPositionUrl2) {
        this.advertisingPositionUrl2 = advertisingPositionUrl2;
    }

    public String getAdvertisingPositionUrl3() {
        return advertisingPositionUrl3;
    }

    public void setAdvertisingPositionUrl3(String advertisingPositionUrl3) {
        this.advertisingPositionUrl3 = advertisingPositionUrl3;
    }

    public Integer getActivitySort() {
        return activitySort;
    }

    public void setActivitySort(Integer activitySort) {
        this.activitySort = activitySort;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getActivityMainTitle() {
        return activityMainTitle;
    }

    public void setActivityMainTitle(String activityMainTitle) {
        this.activityMainTitle = activityMainTitle;
    }

    public String getActivitySubTitle() {
        return activitySubTitle;
    }

    public void setActivitySubTitle(String activitySubTitle) {
        this.activitySubTitle = activitySubTitle;
    }

    public String getUserPortraitImage() {
        return userPortraitImage;
    }

    public void setUserPortraitImage(String userPortraitImage) {
        this.userPortraitImage = userPortraitImage;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }
}
