package ppljoss.ppl2_pmb.BeritaUAI_RSS;

/**
 * Created by khenshaa on 1/15/19.
 */

public class FeedItem {
    String title;
    String link;
    String description;
    String pubDate;
    String thumbnailUrl;
    private String item_image = "no image";
    private String item_image2 = "no image";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    void setImage(String image) {
        item_image = image;

        item_image = image;
    }

    //this is used when getImage() fails (this happens when img is placed in content:encoded)
    void setImage2(String image2) {

        item_image2 = image2;
    }

    public String getImage() {
        return item_image;
    }

    //this is used when getImage() fails (this happens when img is placed in content:encoded)
    public String getImage2() {
        return item_image2;
    }
}
