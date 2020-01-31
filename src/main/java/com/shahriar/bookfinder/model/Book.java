package com.shahriar.bookfinder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Score;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;


@Document(indexName = "books", type = "book")
@Builder
@Data
public class Book {
	@Id
	private String _id;
	
	@Score
	@JsonFormat (shape = JsonFormat.Shape.NUMBER_FLOAT)
	private Float score;
	
	@Field(type = FieldType.Text)
	@JsonFormat (shape = JsonFormat.Shape.STRING)
    private String isbn;
	
	@Field(type = FieldType.Text)
	@JsonFormat (shape = JsonFormat.Shape.STRING)
    private String title;
	
	@Field(type = FieldType.Text)
	@JsonFormat (shape = JsonFormat.Shape.STRING)
    private String author;
	
	@Field(type = FieldType.Date, store = true, pattern = "yyyy-MM-dd")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    private String releaseDate;

    public Book() {
    }

    public Book(String id, Float score, String isbn, String title, String author, String releaseDate) {
    	this._id = id;    	
    	this.score = score;    	
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
        		"id='" + _id + '\'' +
        		"score='" + score + '\'' +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
