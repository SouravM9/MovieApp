package dev.souravm9.MovieAPI.models;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {

	@Id
	private ObjectId id;

	private String body;

	private LocalDateTime created;

	private LocalDateTime updated;

	public Review() {
		super();
	}
	
	public Review(ObjectId id, String body, LocalDateTime created, LocalDateTime updated) {
		super();
		this.id = id;
		this.body = body;
		this.created = created;
		this.updated = updated;
	}

	public Review(String body, LocalDateTime created, LocalDateTime updated) {
		super();
		this.body = body;
		this.created = created;
		this.updated = updated;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", body=" + body + "]";
	}

}
