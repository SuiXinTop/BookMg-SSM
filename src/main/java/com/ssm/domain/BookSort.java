package com.ssm.domain;

/**
 * @author STARS
 */
public class BookSort {
    private Integer sortId;

    private String sortName;

    private String sortText;

    public BookSort(Integer sortId, String sortName, String sortText) {
        this.sortId = sortId;
        this.sortName = sortName;
        this.sortText = sortText;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName == null ? null : sortName.trim();
    }

    public String getSortText() {
        return sortText;
    }

    public void setSortText(String sortText) {
        this.sortText = sortText == null ? null : sortText.trim();
    }

    @Override
    public String toString() {
        return "BookSort{" +
                "sortId=" + sortId +
                ", sortName='" + sortName + '\'' +
                ", sortText='" + sortText + '\'' +
                '}';
    }
}