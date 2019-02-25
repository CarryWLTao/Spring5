package com.wlt.handler;

import java.sql.ResultSet;

public interface ResultSetHandler{

	public <T> T handler(ResultSet rs);

}
