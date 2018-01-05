package com.story.happyjie.dailyinformation.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by llj on 2018/1/3.
 */

public class JokeListResult implements Serializable{
    private String message;
    private DataBeanX data;
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }
    public DataBeanX getDataBeanX() {
        return data;
    }

    public static class DataBeanX implements Serializable{

        private boolean has_more;
        private String tip;
        private boolean has_new_message;
        private double max_time;
        private int min_time;
        private List<Data> data;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public boolean isHas_new_message() {
            return has_new_message;
        }

        public void setHas_new_message(boolean has_new_message) {
            this.has_new_message = has_new_message;
        }

        public double getMax_time() {
            return max_time;
        }

        public void setMax_time(double max_time) {
            this.max_time = max_time;
        }

        public int getMin_time() {
            return min_time;
        }

        public void setMin_time(int min_time) {
            this.min_time = min_time;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public static class Data implements Serializable{

            private Group group;
            private List<Comment> comments;
            private int type;
            private double display_time;
            private double online_time;
            public void setGroup(Group group) {
                this.group = group;
            }
            public Group getGroup() {
                return group;
            }

            public List<Comment> getComments() {
                return comments;
            }

            public void setComments(List<Comment> comments) {
                this.comments = comments;
            }

            public void setType(int type) {
                this.type = type;
            }
            public int getType() {
                return type;
            }

            public double getDisplay_time() {
                return display_time;
            }

            public void setDisplay_time(double display_time) {
                this.display_time = display_time;
            }

            public double getOnline_time() {
                return online_time;
            }

            public void setOnline_time(double online_time) {
                this.online_time = online_time;
            }


            public static class Comment implements Serializable{
                private String text;
                private int create_time;
                private boolean user_verified;
                private int user_bury;
                private long user_id;
                private int bury_count;
                private String share_url;
                private long id;
                private String platform;
                private int is_digg;
                private String user_name;
                private String user_profile_image_url;
                private int status;
                private String description;
                private int user_digg;
                private String user_profile_url;
                private int share_type;
                private int digg_count;
                private boolean is_pro_user;
                private String platform_id;
                private String avatar_url;
                private long group_id;
                private List<Group.Medals> medals;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }

                public int getUser_bury() {
                    return user_bury;
                }

                public void setUser_bury(int user_bury) {
                    this.user_bury = user_bury;
                }

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public int getBury_count() {
                    return bury_count;
                }

                public void setBury_count(int bury_count) {
                    this.bury_count = bury_count;
                }

                public String getShare_url() {
                    return share_url;
                }

                public void setShare_url(String share_url) {
                    this.share_url = share_url;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getPlatform() {
                    return platform;
                }

                public void setPlatform(String platform) {
                    this.platform = platform;
                }

                public int getIs_digg() {
                    return is_digg;
                }

                public void setIs_digg(int is_digg) {
                    this.is_digg = is_digg;
                }

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }

                public String getUser_profile_image_url() {
                    return user_profile_image_url;
                }

                public void setUser_profile_image_url(String user_profile_image_url) {
                    this.user_profile_image_url = user_profile_image_url;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getUser_digg() {
                    return user_digg;
                }

                public void setUser_digg(int user_digg) {
                    this.user_digg = user_digg;
                }

                public String getUser_profile_url() {
                    return user_profile_url;
                }

                public void setUser_profile_url(String user_profile_url) {
                    this.user_profile_url = user_profile_url;
                }

                public int getShare_type() {
                    return share_type;
                }

                public void setShare_type(int share_type) {
                    this.share_type = share_type;
                }

                public int getDigg_count() {
                    return digg_count;
                }

                public void setDigg_count(int digg_count) {
                    this.digg_count = digg_count;
                }

                public boolean isIs_pro_user() {
                    return is_pro_user;
                }

                public void setIs_pro_user(boolean is_pro_user) {
                    this.is_pro_user = is_pro_user;
                }

                public String getPlatform_id() {
                    return platform_id;
                }

                public void setPlatform_id(String platform_id) {
                    this.platform_id = platform_id;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public long getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(long group_id) {
                    this.group_id = group_id;
                }

                public List<Group.Medals> getMedals() {
                    return medals;
                }

                public void setMedals(List<Group.Medals> medals) {
                    this.medals = medals;
                }

            }

            public static class Group implements Serializable{

                @SerializedName("video_id")
                private String videoId;
                @SerializedName("mp4_url")
                private String mp4Url;
                private String text;
                @SerializedName("category_activity_start_time")
                private int categoryActivityStartTime;
                @SerializedName("digg_count")
                private int diggCount;
                private double duration;
                @SerializedName("create_time")
                private int createTime;
                @SerializedName("share_url")
                private String shareUrl;
                @SerializedName("go_detail_count")
                private int goDetailCount;
                private String keywords;
                private long id;
                @SerializedName("favorite_count")
                private int favoriteCount;
                @SerializedName("danmaku_attrs")
                private DanmakuAttrs danmakuAttrs;
                @SerializedName("m3u8_url")
                private String m3u8Url;
                @SerializedName("large_cover")
                private LargeCover largeCover;
                @SerializedName("category_activity_schema_url")
                private String categoryActivitySchemaUrl;
                @SerializedName("user_favorite")
                private int userFavorite;
                @SerializedName("share_type")
                private int shareType;
                private String title;
                @SerializedName("category_activity_text")
                private String categoryActivityText;
                private User user;
                @SerializedName("is_can_share")
                private int isCanShare;
                @SerializedName("category_type")
                private int categoryType;
                @SerializedName("download_url")
                private String downloadUrl;
                private int label;
                private String content;
                @SerializedName("video_height")
                private int videoHeight;
                @SerializedName("comment_count")
                private int commentCount;
                @SerializedName("id_str")
                private String idStr;
                @SerializedName("media_type")
                private int mediaType;
                @SerializedName("share_count")
                private int shareCount;
                private int type;
                @SerializedName("category_id")
                private int categoryId;
                private int status;
                @SerializedName("has_comments")
                private int hasComments;
                @SerializedName("publish_time")
                private String publishTime;
                @SerializedName("user_bury")
                private int userBury;
                @SerializedName("origin_video")
                private OriginVideo originVideo;
//                private Activity activity;
                @SerializedName("status_desc")
                private String statusDesc;
                @SerializedName("dislike_reason")
                private List<DislikeReason> dislikeReason;
                @SerializedName("neihan_hot_start_time")
                private String neihanHotStartTime;
                @SerializedName("play_count")
                private int playCount;
                @SerializedName("user_repin")
                private int userRepin;
                @SerializedName("quick_comment")
                private boolean quickComment;
                @SerializedName("category_activity_end_time")
                private int categoryActivityEndTime;
                @SerializedName("medium_cover")
                private MediumCover mediumCover;
                @SerializedName("neihan_hot_end_time")
                private String neihanHotEndTime;
                @SerializedName("user_digg")
                private int userDigg;
                @SerializedName("video_width")
                private int videoWidth;
                @SerializedName("online_time")
                private int onlineTime;
                @SerializedName("category_name")
                private String categoryName;
                @SerializedName("flash_url")
                private String flashUrl;
                @SerializedName("category_visible")
                private boolean categoryVisible;
                @SerializedName("bury_count")
                private int buryCount;
                @SerializedName("is_anonymous")
                private boolean isAnonymous;
                @SerializedName("repin_count")
                private int repinCount;
                @SerializedName("is_neihan_hot")
                private boolean isNeihanHot;
                private String uri;
                @SerializedName("is_public_url")
                private int isPublicUrl;
                @SerializedName("has_hot_comments")
                private int hasHotComments;
                @SerializedName("category_show_ranking")
                private int categoryShowRanking;
                @SerializedName("cover_image_uri")
                private String coverImageUri;
                @SerializedName("category_is_activity")
                private int categoryIsActivity;
                @SerializedName("cover_image_url")
                private String coverImageUrl;
//                @SerializedName("neihan_hot_link")
//                private NeihanHotLink neihanHotLink;
                @SerializedName("group_id")
                private long groupId;
                @SerializedName("is_video")
                private int isVideo;
                @SerializedName("allow_dislike")
                private boolean allowDislike;
                @SerializedName("display_type")
                private int displayType;
                public void setVideoId(String videoId) {
                    this.videoId = videoId;
                }
                public String getVideoId() {
                    return videoId;
                }


                public void setMp4Url(String mp4Url) {
                    this.mp4Url = mp4Url;
                }
                public String getMp4Url() {
                    return mp4Url;
                }

                public void setText(String text) {
                    this.text = text;
                }
                public String getText() {
                    return text;
                }

                public void setCategoryActivityStartTime(int categoryActivityStartTime) {
                    this.categoryActivityStartTime = categoryActivityStartTime;
                }
                public int getCategoryActivityStartTime() {
                    return categoryActivityStartTime;
                }


                public void setDiggCount(int diggCount) {
                    this.diggCount = diggCount;
                }
                public int getDiggCount() {
                    return diggCount;
                }

                public void setDuration(double duration) {
                    this.duration = duration;
                }
                public double getDuration() {
                    return duration;
                }

                public void setCreateTime(int createTime) {
                    this.createTime = createTime;
                }
                public int getCreateTime() {
                    return createTime;
                }

                public void setShareUrl(String shareUrl) {
                    this.shareUrl = shareUrl;
                }
                public String getShareUrl() {
                    return shareUrl;
                }

                public void setGoDetailCount(int goDetailCount) {
                    this.goDetailCount = goDetailCount;
                }
                public int getGoDetailCount() {
                    return goDetailCount;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
                }
                public String getKeywords() {
                    return keywords;
                }

                public void setId(long id) {
                    this.id = id;
                }
                public long getId() {
                    return id;
                }

                public void setFavoriteCount(int favoriteCount) {
                    this.favoriteCount = favoriteCount;
                }
                public int getFavoriteCount() {
                    return favoriteCount;
                }

                public void setDanmakuAttrs(DanmakuAttrs danmakuAttrs) {
                    this.danmakuAttrs = danmakuAttrs;
                }
                public DanmakuAttrs getDanmakuAttrs() {
                    return danmakuAttrs;
                }

                public void setM3u8Url(String m3u8Url) {
                    this.m3u8Url = m3u8Url;
                }
                public String getM3u8Url() {
                    return m3u8Url;
                }

                public void setLargeCover(LargeCover largeCover) {
                    this.largeCover = largeCover;
                }
                public LargeCover getLargeCover() {
                    return largeCover;
                }

                public void setCategoryActivitySchemaUrl(String categoryActivitySchemaUrl) {
                    this.categoryActivitySchemaUrl = categoryActivitySchemaUrl;
                }
                public String getCategoryActivitySchemaUrl() {
                    return categoryActivitySchemaUrl;
                }

                public void setUserFavorite(int userFavorite) {
                    this.userFavorite = userFavorite;
                }
                public int getUserFavorite() {
                    return userFavorite;
                }

                public void setShareType(int shareType) {
                    this.shareType = shareType;
                }
                public int getShareType() {
                    return shareType;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
                public String getTitle() {
                    return title;
                }

                public void setCategoryActivityText(String categoryActivityText) {
                    this.categoryActivityText = categoryActivityText;
                }
                public String getCategoryActivityText() {
                    return categoryActivityText;
                }

                public void setUser(User user) {
                    this.user = user;
                }
                public User getUser() {
                    return user;
                }

                public void setIsCanShare(int isCanShare) {
                    this.isCanShare = isCanShare;
                }
                public int getIsCanShare() {
                    return isCanShare;
                }

                public void setCategoryType(int categoryType) {
                    this.categoryType = categoryType;
                }
                public int getCategoryType() {
                    return categoryType;
                }

                public void setDownloadUrl(String downloadUrl) {
                    this.downloadUrl = downloadUrl;
                }
                public String getDownloadUrl() {
                    return downloadUrl;
                }

                public void setLabel(int label) {
                    this.label = label;
                }
                public int getLabel() {
                    return label;
                }

                public void setContent(String content) {
                    this.content = content;
                }
                public String getContent() {
                    return content;
                }

                public void setVideoHeight(int videoHeight) {
                    this.videoHeight = videoHeight;
                }
                public int getVideoHeight() {
                    return videoHeight;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }
                public int getCommentCount() {
                    return commentCount;
                }

                public void setIdStr(String idStr) {
                    this.idStr = idStr;
                }
                public String getIdStr() {
                    return idStr;
                }

                public void setMediaType(int mediaType) {
                    this.mediaType = mediaType;
                }
                public int getMediaType() {
                    return mediaType;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }
                public int getShareCount() {
                    return shareCount;
                }

                public void setType(int type) {
                    this.type = type;
                }
                public int getType() {
                    return type;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }
                public int getCategoryId() {
                    return categoryId;
                }

                public void setStatus(int status) {
                    this.status = status;
                }
                public int getStatus() {
                    return status;
                }

                public void setHasComments(int hasComments) {
                    this.hasComments = hasComments;
                }
                public int getHasComments() {
                    return hasComments;
                }

                public void setPublishTime(String publishTime) {
                    this.publishTime = publishTime;
                }
                public String getPublishTime() {
                    return publishTime;
                }

                public void setUserBury(int userBury) {
                    this.userBury = userBury;
                }
                public int getUserBury() {
                    return userBury;
                }

                public void setOriginVideo(OriginVideo originVideo) {
                    this.originVideo = originVideo;
                }
                public OriginVideo getOriginVideo() {
                    return originVideo;
                }

                public void setStatusDesc(String statusDesc) {
                    this.statusDesc = statusDesc;
                }
                public String getStatusDesc() {
                    return statusDesc;
                }

                public void setDislikeReason(List<DislikeReason> dislikeReason) {
                    this.dislikeReason = dislikeReason;
                }
                public List<DislikeReason> getDislikeReason() {
                    return dislikeReason;
                }

                public void setNeihanHotStartTime(String neihanHotStartTime) {
                    this.neihanHotStartTime = neihanHotStartTime;
                }
                public String getNeihanHotStartTime() {
                    return neihanHotStartTime;
                }

                public void setPlayCount(int playCount) {
                    this.playCount = playCount;
                }
                public int getPlayCount() {
                    return playCount;
                }

                public void setUserRepin(int userRepin) {
                    this.userRepin = userRepin;
                }
                public int getUserRepin() {
                    return userRepin;
                }

                public void setQuickComment(boolean quickComment) {
                    this.quickComment = quickComment;
                }
                public boolean getQuickComment() {
                    return quickComment;
                }

                public void setCategoryActivityEndTime(int categoryActivityEndTime) {
                    this.categoryActivityEndTime = categoryActivityEndTime;
                }
                public int getCategoryActivityEndTime() {
                    return categoryActivityEndTime;
                }

                public void setMediumCover(MediumCover mediumCover) {
                    this.mediumCover = mediumCover;
                }
                public MediumCover getMediumCover() {
                    return mediumCover;
                }

                public void setNeihanHotEndTime(String neihanHotEndTime) {
                    this.neihanHotEndTime = neihanHotEndTime;
                }
                public String getNeihanHotEndTime() {
                    return neihanHotEndTime;
                }

                public void setUserDigg(int userDigg) {
                    this.userDigg = userDigg;
                }
                public int getUserDigg() {
                    return userDigg;
                }

                public void setVideoWidth(int videoWidth) {
                    this.videoWidth = videoWidth;
                }
                public int getVideoWidth() {
                    return videoWidth;
                }

                public void setOnlineTime(int onlineTime) {
                    this.onlineTime = onlineTime;
                }
                public int getOnlineTime() {
                    return onlineTime;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }
                public String getCategoryName() {
                    return categoryName;
                }

                public void setFlashUrl(String flashUrl) {
                    this.flashUrl = flashUrl;
                }
                public String getFlashUrl() {
                    return flashUrl;
                }

                public void setCategoryVisible(boolean categoryVisible) {
                    this.categoryVisible = categoryVisible;
                }
                public boolean getCategoryVisible() {
                    return categoryVisible;
                }

                public void setBuryCount(int buryCount) {
                    this.buryCount = buryCount;
                }
                public int getBuryCount() {
                    return buryCount;
                }

                public void setIsAnonymous(boolean isAnonymous) {
                    this.isAnonymous = isAnonymous;
                }
                public boolean getIsAnonymous() {
                    return isAnonymous;
                }

                public void setRepinCount(int repinCount) {
                    this.repinCount = repinCount;
                }
                public int getRepinCount() {
                    return repinCount;
                }

                public void setIsNeihanHot(boolean isNeihanHot) {
                    this.isNeihanHot = isNeihanHot;
                }
                public boolean getIsNeihanHot() {
                    return isNeihanHot;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }
                public String getUri() {
                    return uri;
                }

                public void setIsPublicUrl(int isPublicUrl) {
                    this.isPublicUrl = isPublicUrl;
                }
                public int getIsPublicUrl() {
                    return isPublicUrl;
                }

                public void setHasHotComments(int hasHotComments) {
                    this.hasHotComments = hasHotComments;
                }
                public int getHasHotComments() {
                    return hasHotComments;
                }

                public void setCategoryShowRanking(int categoryShowRanking) {
                    this.categoryShowRanking = categoryShowRanking;
                }
                public int getCategoryShowRanking() {
                    return categoryShowRanking;
                }

                public void setCoverImageUri(String coverImageUri) {
                    this.coverImageUri = coverImageUri;
                }
                public String getCoverImageUri() {
                    return coverImageUri;
                }

                public void setCategoryIsActivity(int categoryIsActivity) {
                    this.categoryIsActivity = categoryIsActivity;
                }
                public int getCategoryIsActivity() {
                    return categoryIsActivity;
                }

                public void setCoverImageUrl(String coverImageUrl) {
                    this.coverImageUrl = coverImageUrl;
                }
                public String getCoverImageUrl() {
                    return coverImageUrl;
                }

//                public void setNeihanHotLink(NeihanHotLink neihanHotLink) {
//                    this.neihanHotLink = neihanHotLink;
//                }
//                public NeihanHotLink getNeihanHotLink() {
//                    return neihanHotLink;
//                }

                public void setGroupId(long groupId) {
                    this.groupId = groupId;
                }
                public long getGroupId() {
                    return groupId;
                }

                public void setIsVideo(int isVideo) {
                    this.isVideo = isVideo;
                }
                public int getIsVideo() {
                    return isVideo;
                }

                public void setAllowDislike(boolean allowDislike) {
                    this.allowDislike = allowDislike;
                }
                public boolean getAllowDislike() {
                    return allowDislike;
                }

                public void setDisplayType(int displayType) {
                    this.displayType = displayType;
                }
                public int getDisplayType() {
                    return displayType;
                }


                public static class DanmakuAttrs implements Serializable{

                    @SerializedName("allow_show_danmaku")
                    private int allowShowDanmaku;
                    @SerializedName("allow_send_danmaku")
                    private int allowSendDanmaku;
                    public void setAllowShowDanmaku(int allowShowDanmaku) {
                        this.allowShowDanmaku = allowShowDanmaku;
                    }
                    public int getAllowShowDanmaku() {
                        return allowShowDanmaku;
                    }

                    public void setAllowSendDanmaku(int allowSendDanmaku) {
                        this.allowSendDanmaku = allowSendDanmaku;
                    }
                    public int getAllowSendDanmaku() {
                        return allowSendDanmaku;
                    }

                }

                public static class LargeCover implements Serializable{

                    @SerializedName("url_list")
                    private List<UrlList> urlList;
                    private String uri;
                    public void setUrlList(List<UrlList> urlList) {
                        this.urlList = urlList;
                    }
                    public List<UrlList> getUrlList() {
                        return urlList;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }
                    public String getUri() {
                        return uri;
                    }

                }

                public static class UrlList implements Serializable{

                    private String url;
                    public void setUrl(String url) {
                        this.url = url;
                    }
                    public String getUrl() {
                        return url;
                    }

                }

                public static class User implements Serializable{

                    @SerializedName("is_living")
                    private boolean isLiving;
                    @SerializedName("user_id")
                    private long userId;
                    private String name;
                    private int followings;
                    @SerializedName("user_verified")
                    private boolean userVerified;
                    @SerializedName("ugc_count")
                    private int ugcCount;
                    @SerializedName("avatar_url")
                    private String avatarUrl;
                    private int followers;
                    @SerializedName("is_following")
                    private boolean isFollowing;
                    @SerializedName("is_pro_user")
                    private boolean isProUser;
                    private List<Medals> medals;
                    public void setIsLiving(boolean isLiving) {
                        this.isLiving = isLiving;
                    }
                    public boolean getIsLiving() {
                        return isLiving;
                    }

                    public void setUserId(long userId) {
                        this.userId = userId;
                    }
                    public long getUserId() {
                        return userId;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                    public String getName() {
                        return name;
                    }

                    public void setFollowings(int followings) {
                        this.followings = followings;
                    }
                    public int getFollowings() {
                        return followings;
                    }

                    public void setUserVerified(boolean userVerified) {
                        this.userVerified = userVerified;
                    }
                    public boolean getUserVerified() {
                        return userVerified;
                    }

                    public void setUgcCount(int ugcCount) {
                        this.ugcCount = ugcCount;
                    }
                    public int getUgcCount() {
                        return ugcCount;
                    }

                    public void setAvatarUrl(String avatarUrl) {
                        this.avatarUrl = avatarUrl;
                    }
                    public String getAvatarUrl() {
                        return avatarUrl;
                    }

                    public void setFollowers(int followers) {
                        this.followers = followers;
                    }
                    public int getFollowers() {
                        return followers;
                    }

                    public void setIsFollowing(boolean isFollowing) {
                        this.isFollowing = isFollowing;
                    }
                    public boolean getIsFollowing() {
                        return isFollowing;
                    }

                    public void setIsProUser(boolean isProUser) {
                        this.isProUser = isProUser;
                    }
                    public boolean getIsProUser() {
                        return isProUser;
                    }

                    public void setMedals(List<Medals> medals) {
                        this.medals = medals;
                    }
                    public List<Medals> getMedals() {
                        return medals;
                    }

                }

                public static class MediumCover implements Serializable{

                    @SerializedName("url_list")
                    private List<UrlList> urlList;
                    private String uri;
                    public void setUrlList(List<UrlList> urlList) {
                        this.urlList = urlList;
                    }
                    public List<UrlList> getUrlList() {
                        return urlList;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }
                    public String getUri() {
                        return uri;
                    }

                }

                public static class Medals implements Serializable{

                    private int count;
                    @SerializedName("icon_url")
                    private String iconUrl;
                    private String name;
                    @SerializedName("small_icon_url")
                    private String smallIconUrl;
                    public void setCount(int count) {
                        this.count = count;
                    }
                    public int getCount() {
                        return count;
                    }

                    public void setIconUrl(String iconUrl) {
                        this.iconUrl = iconUrl;
                    }
                    public String getIconUrl() {
                        return iconUrl;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                    public String getName() {
                        return name;
                    }

                    public void setSmallIconUrl(String smallIconUrl) {
                        this.smallIconUrl = smallIconUrl;
                    }
                    public String getSmallIconUrl() {
                        return smallIconUrl;
                    }

                }

                public static class OriginVideo implements Serializable{

                    private int width;
                    @SerializedName("url_list")
                    private List<UrlList> urlList;
                    private String uri;
                    private int height;
                    public void setWidth(int width) {
                        this.width = width;
                    }
                    public int getWidth() {
                        return width;
                    }

                    public void setUrlList(List<UrlList> urlList) {
                        this.urlList = urlList;
                    }
                    public List<UrlList> getUrlList() {
                        return urlList;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }
                    public String getUri() {
                        return uri;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }
                    public int getHeight() {
                        return height;
                    }

                }

                public static class DislikeReason implements Serializable{

                    private int type;
                    private long id;
                    private String title;
                    public void setType(int type) {
                        this.type = type;
                    }
                    public int getType() {
                        return type;
                    }

                    public void setId(long id) {
                        this.id = id;
                    }
                    public long getId() {
                        return id;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                    public String getTitle() {
                        return title;
                    }

                }
            }
        }
    }
}
