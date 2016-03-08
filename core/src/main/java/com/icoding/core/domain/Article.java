package com.icoding.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.icoding.core.config.TableConstant;

@Entity
@Table(name = TableConstant.ARTICLE_TBL)
public class Article extends BaseEntity {

	private static final long serialVersionUID = -7320302406355513638L;

	private String title;
	private String description;
	private String content;
	private String urlKey;
	private String keyword;
	private String importantKeyword;
	private String metaDescription;
	private String metaKeyword;
	private String shortUrl;

	@OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
	private ArticleEN articleEN;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrlKey() {
		return urlKey;
	}

	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getImportantKeyword() {
		return importantKeyword;
	}

	public void setImportantKeyword(String importantKeyword) {
		this.importantKeyword = importantKeyword;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public ArticleEN getArticleEN() {
		return articleEN;
	}

	public void setArticleEN(ArticleEN articleEN) {
		this.articleEN = articleEN;
	}

}
