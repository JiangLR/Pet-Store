package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "photos", schema = "pet_service", catalog = "")
public class PhotosEntity {
    private int photoId;
    private String imgSrc;
    private PetEntity pet;

    @Id
    @Column(name = "photo_id")
    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "img_src")
    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotosEntity that = (PhotosEntity) o;
        return photoId == that.photoId &&
                Objects.equals(imgSrc, that.imgSrc);
    }

    @Override
    public String toString() {
        return "PhotosEntity{" +
                "photoId=" + photoId +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, imgSrc);
    }
}
