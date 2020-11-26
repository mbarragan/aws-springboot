package com.quercusdata.awsspringboot.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quercusdata.awsspringboot.model.UserModel;

public class TestDTOData
{
	public static UserModel generateUser(Long userId, String username, String nickname)
	{
		UserModel userModel = new UserModel();
		userModel.setId(userId);
		userModel.setUsername(username);
		userModel.setNickname(nickname);
		return userModel;
	}

	public static String asJsonString(final Object obj)
	{
		try
		{
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}