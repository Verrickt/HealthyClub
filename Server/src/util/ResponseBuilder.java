package util;

import java.io.IOException;

import com.google.*;
import com.google.gson.*;

public class ResponseBuilder<T> {
	private String msg;

	private T json;
	private transient static Gson gson = new Gson();

	public ResponseBuilder(String msg, T result) {
		this.json = result;
		this.msg = msg;
	}

	@Override
	public String toString() {

		return gson.toJson(this);
	}

}
