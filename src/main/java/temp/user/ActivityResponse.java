package temp.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActivityResponse {
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
    @JsonFormat(
            timezone = "GMT+8",
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date createTime;
    private Integer createdBy;
    @JsonFormat(
            timezone = "GMT+8",
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date updateTime;
    private Integer updatedBy;
    private Integer isDeleted;
    private String linkUrl;
    private String activityCategory;
    private String activityCategoryName;
    private String activityShortDescription;
    private String activityTip;
    private String coverImageUrl;
    private Integer activityType;
    private String activityTypeName;
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
    private String[] teacherNames;
    private String qRCodeUrl;
    private String bindAccountUrl;
    private String[] activityItem;
    private String[] activityItemName;
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
    private String coverImageOssUrl;
    private String recruitVideoOss;
    private String recruitImageOss;
    private String openingVideoOss;
    private String openingImageOss;
    private String advertisingPositionOssUrl1;
    private String advertisingPositionOssUrl2;
    private String advertisingPositionOssUrl3;
    private Boolean hasHomework;
    private String activityPreviewUrl;
    private String activityHomeworkUrl;
    private Integer groupCount;
    private String refreshUrl;
    private Integer activityStatus;
    private String homeWorkDataUrl;
    private String activityMainTitle;
    private String activitySubTitle;
    private String userPortraitImage;
    private String solution;
    private String userPortraitImageOss;
    private Integer currentStep;
    private String userIdentity;
    private String userIdentityName;
    private Integer mktQrId;
    private String mktQrCode;
    private Boolean isExistQrId;

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

    public String getActivityCategoryName() {
        return activityCategoryName;
    }

    public void setActivityCategoryName(String activityCategoryName) {
        this.activityCategoryName = activityCategoryName;
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

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
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

    public String[] getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(String[] teacherNames) {
        this.teacherNames = teacherNames;
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

    public String[] getActivityItemName() {
        return activityItemName;
    }

    public void setActivityItemName(String[] activityItemName) {
        this.activityItemName = activityItemName;
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

    public String getCoverImageOssUrl() {
        return coverImageOssUrl;
    }

    public void setCoverImageOssUrl(String coverImageOssUrl) {
        this.coverImageOssUrl = coverImageOssUrl;
    }

    public String getRecruitVideoOss() {
        return recruitVideoOss;
    }

    public void setRecruitVideoOss(String recruitVideoOss) {
        this.recruitVideoOss = recruitVideoOss;
    }

    public String getRecruitImageOss() {
        return recruitImageOss;
    }

    public void setRecruitImageOss(String recruitImageOss) {
        this.recruitImageOss = recruitImageOss;
    }

    public String getOpeningVideoOss() {
        return openingVideoOss;
    }

    public void setOpeningVideoOss(String openingVideoOss) {
        this.openingVideoOss = openingVideoOss;
    }

    public String getOpeningImageOss() {
        return openingImageOss;
    }

    public void setOpeningImageOss(String openingImageOss) {
        this.openingImageOss = openingImageOss;
    }

    public String getAdvertisingPositionOssUrl1() {
        return advertisingPositionOssUrl1;
    }

    public void setAdvertisingPositionOssUrl1(String advertisingPositionOssUrl1) {
        this.advertisingPositionOssUrl1 = advertisingPositionOssUrl1;
    }

    public String getAdvertisingPositionOssUrl2() {
        return advertisingPositionOssUrl2;
    }

    public void setAdvertisingPositionOssUrl2(String advertisingPositionOssUrl2) {
        this.advertisingPositionOssUrl2 = advertisingPositionOssUrl2;
    }

    public String getAdvertisingPositionOssUrl3() {
        return advertisingPositionOssUrl3;
    }

    public void setAdvertisingPositionOssUrl3(String advertisingPositionOssUrl3) {
        this.advertisingPositionOssUrl3 = advertisingPositionOssUrl3;
    }

    public Boolean getHasHomework() {
        return hasHomework;
    }

    public void setHasHomework(Boolean hasHomework) {
        this.hasHomework = hasHomework;
    }

    public String getActivityPreviewUrl() {
        return activityPreviewUrl;
    }

    public void setActivityPreviewUrl(String activityPreviewUrl) {
        this.activityPreviewUrl = activityPreviewUrl;
    }

    public String getActivityHomeworkUrl() {
        return activityHomeworkUrl;
    }

    public void setActivityHomeworkUrl(String activityHomeworkUrl) {
        this.activityHomeworkUrl = activityHomeworkUrl;
    }

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getHomeWorkDataUrl() {
        return homeWorkDataUrl;
    }

    public void setHomeWorkDataUrl(String homeWorkDataUrl) {
        this.homeWorkDataUrl = homeWorkDataUrl;
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

    public String getUserPortraitImageOss() {
        return userPortraitImageOss;
    }

    public void setUserPortraitImageOss(String userPortraitImageOss) {
        this.userPortraitImageOss = userPortraitImageOss;
    }

    public Integer getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(Integer currentStep) {
        this.currentStep = currentStep;
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
}
